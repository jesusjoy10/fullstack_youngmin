import { all, fork } from 'redux-saga/effects';
import recommendSaga from './recommendSaga'; 

export default function* rootSaga() {
  yield all([
    fork(recommendSaga), // 👈 여기에 등록해야 비동기 액션을 가로챌 수 있습니다.
  ]);  
}