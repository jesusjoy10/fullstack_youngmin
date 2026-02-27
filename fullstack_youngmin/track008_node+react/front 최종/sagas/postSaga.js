import { call, put, takeLatest, delay } from 'redux-saga/effects';
import axios from '../api/axios';
import { message } from 'antd';
import {
  fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
  fetchPostRequest, fetchPostSuccess, fetchPostFailure,
  fetchPostsPagedRequest, fetchPostsPagedSuccess, fetchPostsPagedFailure,
  fetchCategoryPostsRequest, fetchCategoryPostsSuccess, fetchCategoryPostsFailure,
  searchHashtagRequest, searchHashtagSuccess, searchHashtagFailure,
  fetchLikedPostsRequest, fetchLikedPostsSuccess, fetchLikedPostsFailure,
  fetchMyAndRetweetsRequest, fetchMyAndRetweetsSuccess, fetchMyAndRetweetsFailure,
  createPostRequest, createPostSuccess, createPostFailure,
  updatePostRequest, updatePostSuccess, updatePostFailure,
  deletePostRequest, deletePostSuccess, deletePostFailure,
  recommendPostsRequest, recommendPostsSuccess, recommendPostsFailure, // ✅ 추천 액션 추가
} from '../reducers/postReducer';

// 1. 전체 게시글 조회
export function* fetchPosts() {
  try {
    const { data } = yield call(() => axios.get('/api/posts'));
    yield put(fetchPostsSuccess(data));
  } catch (err) {
    yield put(fetchPostsFailure(err.response?.data?.message || err.message));
  }
}

// 2. 단건 게시글 상세 조회
export function* fetchPost(action) {
  try {
    const { data } = yield call(() => axios.get(`/api/posts/${action.payload.postId}`));
    yield put(fetchPostSuccess(data));
  } catch (err) {
    yield put(fetchPostFailure(err.response?.data?.message || err.message));
  }
}

// 3. 전체 게시글 페이징 조회
export function* fetchPostsPaged(action) {
  try {
    const { page, size } = action.payload;
    const { data } = yield call(() => axios.get(`/api/posts?page=${page}&size=${size}`));
    yield put(fetchPostsPagedSuccess({ data, page })); 
  } catch (err) {
    if (err.response?.status === 404 && err.response?.data?.path === '/login') {
      message.error("세션이 만료되었습니다.");
      window.location.href = '/login';
      return;
    }
    yield put(fetchPostsPagedFailure(err.response?.data?.message || err.message));
  }
}

// 4. 카테고리별 검색
export function* fetchCategoryPosts(action) {
  try {
    const { category } = action.payload;
    const { data } = yield call(() => axios.get(`/api/posts/search/category?category=${encodeURIComponent(category)}`));
    yield put(fetchCategoryPostsSuccess(data));
  } catch (err) {
    yield put(fetchCategoryPostsFailure(err.response?.data?.message || err.message));
  }
}

// 5. 해시태그로 검색
export function* searchHashtag(action) {
  try {
    const { tag } = action.payload;
    const { data } = yield call(() => axios.get(`/api/posts/search/hashtag?tag=${encodeURIComponent(tag)}`));
    yield put(searchHashtagSuccess(data));
  } catch (err) {
    yield put(searchHashtagFailure(err.response?.data?.message || err.message));
  }
}

// 6. ✅ 맛집 추천 로직 (첨가 및 보완)
export function* recommendPosts(action) {
  try {
    const { categories, location } = action.payload;
    yield delay(1000); // 딜레이 추가

    // 서버 에러를 방지하기 위해 안전하게 파라미터 추출
    const categoryQuery = (categories && categories.length > 0) ? categories[0] : '';
    
    // params 객체를 사용해 axios 호출 (500 에러 방지)
    const { data } = yield call(() => 
      axios.get(`/api/posts/search/category`, {
        params: { category: categoryQuery }
      })
    );

    let filteredData = data;
    // 지역 필터링 (선택 사항)
    if (location && location.length > 1) {
      const detailLocation = location[1];
      filteredData = data.filter(post => 
        post.content?.includes(detailLocation) || post.title?.includes(detailLocation)
      );
    }

    // 성공 시 리듀서로 데이터 전달
    yield put(recommendPostsSuccess({
        posts: filteredData,
        selection: action.payload 
    }));
  } catch (err) {
    console.error("추천 로직 에러:", err);
    // 실패 시 반드시 Failure를 put해야 무한 로딩이 멈춤
    yield put(recommendPostsFailure(err.response?.data?.message || err.message));
    message.error("추천 데이터를 가져오는 중 서버 에러가 발생했습니다.");
  }
}

// 7. 좋아요한 게시글 조회
export function* fetchLikedPosts(action) {
  try {
    const { page, size } = action.payload;
    const { data } = yield call(() => axios.get(`/api/posts/liked?page=${page}&size=${size}`));
    yield put(fetchLikedPostsSuccess(data));
  } catch (err) {
    yield put(fetchLikedPostsFailure(err.response?.data?.message || err.message));
  }
}

// 8. 내 쓴 글 + 리트윗 조회
export function* fetchMyAndRetweets(action) {
  try {
    const { page, size } = action.payload;
    const response = yield call(() => axios.get(`/api/posts/my-activity`, {
        params: { page, size }
    }));
    yield put(fetchMyAndRetweetsSuccess(response.data));
  } catch (err) {
    yield put(fetchMyAndRetweetsFailure(err.response?.data?.message || err.message));
  }
}

// 9. 게시글 작성
export function* createPost(action) {
  try {
    const { dto, files } = action.payload;
    const formData = new FormData();
    formData.append('title', dto.title);
    formData.append('category', dto.category);
    formData.append('servingSize', dto.servingSize);
    formData.append('difficulty', dto.difficulty);
    formData.append('description', dto.description || "");
    formData.append('ingredients', dto.ingredients);
    formData.append('instructions', dto.instructions);
    formData.append('content', dto.instructions); 
    
    if (dto.hashtags) formData.append('hashtags', dto.hashtags);
    if (files && files.length > 0) {
      files.forEach((f) => formData.append('files', f));
    }

    const { data } = yield call(() =>
      axios.post('/api/posts', formData, {
        headers: { 'Content-Type': 'multipart/form-data' },
      })
    );
    yield put(createPostSuccess(data));
    message.success("레시피가 등록되었습니다!");
  } catch (err) {
    yield put(createPostFailure(err.response?.data?.message || err.message));
  }
}

// 10. 게시글 수정
export function* updatePost(action) {
  try {
    const { postId, dto, files } = action.payload;
    const formData = new FormData();
    formData.append('title', dto.title);
    formData.append('category', dto.category);
    formData.append('servingSize', dto.servingSize);
    formData.append('difficulty', dto.difficulty);
    formData.append('description', dto.description || "");
    formData.append('ingredients', dto.ingredients);
    formData.append('instructions', dto.instructions);
    formData.append('content', dto.instructions);

    if (dto.hashtags) {
      const hashtagsValue = Array.isArray(dto.hashtags) ? dto.hashtags.join(',') : dto.hashtags;
      formData.append('hashtags', hashtagsValue);
    }

    if (files && files.length > 0) {
      files.forEach(f => {
        const actualFile = f.originFileObj ? f.originFileObj : f;
        formData.append('files', actualFile);
      });
    }

    const { data } = yield call(() =>
      axios.put(`/api/posts/${postId}`, formData, {
        headers: { 'Content-Type': 'multipart/form-data' },
      })
    );
    yield put(updatePostSuccess(data));
    message.success("수정이 완료되었습니다.");
  } catch (err) {
    const errorMsg = err.response?.status === 404 && err.response?.data?.path === '/login'
        ? "로그인 세션이 만료되었습니다." : (err.response?.data?.message || err.message);
    yield put(updatePostFailure(errorMsg));
    message.error(errorMsg);
  }
}

// 11. 게시글 삭제
export function* deletePost(action) {
  try {
    yield call(() => axios.delete(`/api/posts/${action.payload.postId}`));
    yield put(deletePostSuccess(action.payload.postId));
    message.success('레시피가 삭제되었습니다.');
  } catch (err) {
    yield put(deletePostFailure(err.response?.data?.message || err.message));
    message.error('삭제에 실패했습니다.');
  }
}

// 감시자 제너레이터
export default function* postSaga() {
  yield takeLatest(fetchPostsRequest.type, fetchPosts);
  yield takeLatest(fetchPostRequest.type, fetchPost);
  yield takeLatest(fetchPostsPagedRequest.type, fetchPostsPaged);
  yield takeLatest(fetchCategoryPostsRequest.type, fetchCategoryPosts);
  yield takeLatest(searchHashtagRequest.type, searchHashtag);
  yield takeLatest(fetchLikedPostsRequest.type, fetchLikedPosts);
  yield takeLatest(fetchMyAndRetweetsRequest.type, fetchMyAndRetweets);
  yield takeLatest(createPostRequest.type, createPost);
  yield takeLatest(updatePostRequest.type, updatePost);
  yield takeLatest(deletePostRequest.type, deletePost);
  yield takeLatest(recommendPostsRequest.type, recommendPosts); // ✅ 연결
}