import { combineReducers } from 'redux';
import authReducer from './authReducer';
import postReducer from './postReducer';
import commentReducer from './commentReducer';
import followReducer from './followReducer';
import likeReducer from './likeReducer';
import retweetReducer from './retweetReducer';
import materialReducer from './material';
import chatReducer from './chatReducer';
import searchReducer from './search'; // search 리듀서 임포트 확인

const rootReducer = combineReducers({
    auth: authReducer,
    post: postReducer,
    comment: commentReducer,
    follow: followReducer,
    like: likeReducer,
    retweet: retweetReducer,
    material: materialReducer,
    chat: chatReducer,
    search: searchReducer, 
});

export default rootReducer;