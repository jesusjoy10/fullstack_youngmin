import { combineReducers } from 'redux';
import recommendReducer from './recommendReducer'; // 추천 리듀서

const rootReducer = combineReducers({
    
    recommend: recommendReducer, // 추천
});

export default rootReducer;