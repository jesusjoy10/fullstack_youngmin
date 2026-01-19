// sagas/index.js

import {} from 'redux-sga/effects';

import authSaga from './authSaga';
import postSaga from './postSaga';
import commentSaga from './commentSaga';
import followSaga from './followSaga';
import likeSaga from './likeSaga';
import reweetSaga from './reweetSaga';

export default function * rootSaga(){
    yield all([
        fork(authSaga),
        // fork(postSaga),
        // fork(commentSaga),
        // fork(followSaga),
        // fork(likeSaga),
        // fork(reweetSaga),
    ]);
}
