import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  posts: [],               
  recommendPosts: [],      
  likedPosts: [],          
  currentPost: null,       
  myAndRetweets: [],       
  loading: false,          
  recommendPostsLoading: false, 
  error: null,             
  createPostDone: false,   
  updatePostDone: false,   
  deletePostDone: false,   
  recommendPostsDone: false,
  recommendHistory: [], 
};

const postSlice = createSlice({
  name: 'post',
  initialState,
  reducers: {
    CREATE_POST_RESET: (state) => {
      state.createPostDone = false;
      state.error = null;
    },
    UPDATE_POST_RESET: (state) => {
      state.updatePostDone = false;
      state.error = null;
    },
    RECOMMEND_POST_RESET: (state) => {
      state.recommendPosts = [];
      state.recommendPostsDone = false;
    },

    fetchPostsRequest: (state) => { state.loading = true; state.error = null; },
    fetchPostsSuccess: (state, action) => {
      state.loading = false;
      state.posts = action.payload;
    },
    fetchPostsFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },

    fetchPostRequest: (state) => { state.loading = true; state.error = null; },
    fetchPostSuccess: (state, action) => {
      state.loading = false;
      state.currentPost = action.payload;
    },
    fetchPostFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
      state.currentPost = null;
    },

    fetchPostsPagedRequest: (state) => { state.loading = true; state.error = null; },
    fetchPostsPagedSuccess: (state, action) => {
      state.loading = false;
      const { data, page } = action.payload;
      if (page === 1) {
        state.posts = data;
      } else {
        const merged = [...state.posts, ...data];
        const unique = merged.filter(
          (post, index, self) => index === self.findIndex(p => p.id === post.id)
        );
        state.posts = unique.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt));
      }
    },
    fetchPostsPagedFailure: (state, action) => { state.loading = false; state.error = action.payload; },

    fetchCategoryPostsRequest: (state) => { state.loading = true; state.error = null; },
    fetchCategoryPostsSuccess: (state, action) => {
      state.loading = false;
      state.posts = action.payload;
    },
    fetchCategoryPostsFailure: (state, action) => { state.loading = false; state.error = action.payload; },

    searchHashtagRequest: (state) => { state.loading = true; state.error = null; },
    searchHashtagSuccess: (state, action) => {
      state.loading = false;
      state.posts = action.payload;
    },
    searchHashtagFailure: (state, action) => { state.loading = false; state.error = action.payload; },

    // ---------------------------------------------------------
    // ✅ 맛집 추천 로직 (여기가 핵심 첨가 부분입니다)
    // ---------------------------------------------------------
    recommendPostsRequest: (state) => { 
      state.recommendPostsLoading = true; 
      state.error = null; 
      state.recommendPostsDone = false;
    },
    recommendPostsSuccess: (state, action) => {
      state.recommendPostsLoading = false; // 👈 무한 로딩 방지: false로 변경
      state.recommendPostsDone = true;
      
      // ✅ 게시글 삭제 방지: state.posts가 아닌 state.recommendPosts에 저장
      const resultPosts = action.payload?.posts || (Array.isArray(action.payload) ? action.payload : []);
      const selection = action.payload?.selection || { categories: [], location: [], tags: [] };
      
      state.recommendPosts = resultPosts;

      // 히스토리 관리
      if (resultPosts.length > 0) {
        state.recommendHistory.unshift({
          id: Date.now(),
          selection: selection,
          shopNames: resultPosts.map(p => p.title || p.shopName || '이름 없음'), 
          date: new Date().toLocaleString(),
        });
        if (state.recommendHistory.length > 5) state.recommendHistory.pop();
      }
    },
    recommendPostsFailure: (state, action) => { 
      state.recommendPostsLoading = false; // 👈 무한 로딩 방지
      state.recommendPostsDone = false;
      state.error = action.payload; 
    },
    // ---------------------------------------------------------

    fetchLikedPostsRequest: (state) => { state.loading = true; state.error = null; },
    fetchLikedPostsSuccess: (state, action) => {
      state.loading = false;
      state.likedPosts = action.payload;
    },
    fetchLikedPostsFailure: (state, action) => { state.loading = false; state.error = action.payload; },

    fetchMyAndRetweetsRequest: (state) => { state.loading = true; state.error = null; },
    fetchMyAndRetweetsSuccess: (state, action) => {
      state.loading = false;
      state.myAndRetweets = action.payload;
    },
    fetchMyAndRetweetsFailure: (state, action) => { state.loading = false; state.error = action.payload; },

    createPostRequest: (state) => { 
      state.loading = true; 
      state.error = null; 
      state.createPostDone = false; 
    },
    createPostSuccess: (state, action) => {
      state.loading = false;
      state.createPostDone = true; 
      state.posts.unshift(action.payload);
    },
    createPostFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },

    updatePostRequest: (state) => { 
      state.loading = true; 
      state.error = null; 
      state.updatePostDone = false; 
    },
    updatePostSuccess: (state, action) => {
      state.loading = false;
      state.updatePostDone = true; 
      state.posts = state.posts.map(p => p.id === action.payload.id ? action.payload : p);
      if (state.currentPost && state.currentPost.id === action.payload.id) {
        state.currentPost = action.payload;
      }
    },
    updatePostFailure: (state, action) => { 
      state.loading = false; 
      state.error = action.payload; 
    },

    deletePostRequest: (state) => { state.loading = true; state.error = null; },
    deletePostSuccess: (state, action) => {
      state.loading = false;
      state.deletePostDone = true; 
      state.posts = state.posts.filter(p => p.id !== action.payload);
      if (state.currentPost && state.currentPost.id === action.payload) {
        state.currentPost = null;
      }
    },
    deletePostFailure: (state, action) => { state.loading = false; state.error = action.payload; },
  },
});

export const {
  CREATE_POST_RESET,
  UPDATE_POST_RESET,
  RECOMMEND_POST_RESET,
  fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
  fetchPostRequest, fetchPostSuccess, fetchPostFailure,
  fetchPostsPagedRequest, fetchPostsPagedSuccess, fetchPostsPagedFailure,
  fetchCategoryPostsRequest, fetchCategoryPostsSuccess, fetchCategoryPostsFailure,
  searchHashtagRequest, searchHashtagSuccess, searchHashtagFailure,
  recommendPostsRequest, recommendPostsSuccess, recommendPostsFailure, // ✅ export 포함 확인
  fetchLikedPostsRequest, fetchLikedPostsSuccess, fetchLikedPostsFailure,
  fetchMyAndRetweetsRequest, fetchMyAndRetweetsSuccess, fetchMyAndRetweetsFailure,
  createPostRequest, createPostSuccess, createPostFailure,
  updatePostRequest, updatePostSuccess, updatePostFailure,
  deletePostRequest, deletePostSuccess, deletePostFailure,
} = postSlice.actions;

export default postSlice.reducer;