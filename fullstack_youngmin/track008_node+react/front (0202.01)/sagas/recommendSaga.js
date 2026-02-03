import { call, put, takeLatest, all, fork } from 'redux-saga/effects';
import axios from '../api/axios'; 
import {
  LOAD_RECOMMENDATIONS_REQUEST,
  LOAD_RECOMMENDATIONS_SUCCESS,
  LOAD_RECOMMENDATIONS_FAILURE,
} from '../reducers/recommendReducer';

function loadRecommendationsAPI(data) {
  // 백엔드 컨트롤러의 @RequestParam("category")에 맞게 이름을 category로 변경
  // data.categoryName에 사용자가 선택한 '한식', '양식' 등이 들어있습니다.
  return axios.get('/api/recipe/recommend', { 
    params: {
      category: data.categoryName 
    } 
  });
}
function* loadRecommendations(action) {
  try {
    console.log('백엔드로 보내는 데이터:', action.payload);
    const { data } = yield call(loadRecommendationsAPI, action.payload);
    // 성공 시 액션 직접 객체로 전달 (함수 오류 방지)
    yield put({
      type: LOAD_RECOMMENDATIONS_SUCCESS,
      payload: data,
    });
  } catch (err) {
    // 실패 시 액션 직접 객체로 전달
    yield put({
      type: LOAD_RECOMMENDATIONS_FAILURE,
      payload: err.response?.data?.message || err.message,
    });
  }
}

function* watchLoadRecommendations() {
  yield takeLatest(LOAD_RECOMMENDATIONS_REQUEST, loadRecommendations);
}

export default function* recommendSaga() {
  yield all([fork(watchLoadRecommendations)]);
}