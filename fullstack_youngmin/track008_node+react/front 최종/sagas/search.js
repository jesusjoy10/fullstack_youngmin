import { all, fork, put, takeLatest, call } from 'redux-saga/effects';
import { 
    SEARCH_REQUEST, SEARCH_SUCCESS, SEARCH_FAILURE,
    LOAD_HISTORY_REQUEST, LOAD_HISTORY_SUCCESS, LOAD_HISTORY_FAILURE 
} from '../reducers/search';
import { searchRestaurantsAPI, loadHistoryAPI } from '../api/search';

function* search(action) {
    try {
        const result = yield call(searchRestaurantsAPI, action.data);
        yield put({ type: SEARCH_SUCCESS, data: result.data });
        yield put({ type: LOAD_HISTORY_REQUEST }); // 검색 성공 후 히스토리 갱신
    } catch (err) {
        yield put({ type: SEARCH_FAILURE, error: err.response.data });
    }
}

function* loadHistory() {
    try {
        const result = yield call(loadHistoryAPI);
        yield put({ type: LOAD_HISTORY_SUCCESS, data: result.data });
    } catch (err) {
        yield put({ type: LOAD_HISTORY_FAILURE, error: err.response.data });
    }
}

function* watchSearch() { yield takeLatest(SEARCH_REQUEST, search); }
function* watchLoadHistory() { yield takeLatest(LOAD_HISTORY_REQUEST, loadHistory); }

export default function* searchSaga() {
    yield all([ fork(watchSearch), fork(watchLoadHistory) ]);
}