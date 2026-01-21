import reducer, { 
  fetchCommentsSuccess, fetchCommentsFailure,
  createCommentSuccess, createCommentFailure,
  updateCommentSuccess, updateCommentFailure,
  deleteCommentSuccess, deleteCommentFailure,
} from '../commentReducer';

describe('comment reducer tests', () => {
  const initialState = {
    comments: {},
    loading: false,
    error: null,
  };

  // 1. 조회 성공 테스트
  it('fetchCommentsSuccess 테스트', () => {
    const comment = [{ id: 1 }]; // 리듀서와 동일하게 comment 이름 사용
    const state = reducer(initialState, fetchCommentsSuccess({ postId: 1, comment }));
    expect(state.comments[1]).toEqual(comment);        
  }); 

  it('fetchCommentsFailure 테스트', () => {
    const state = reducer(initialState, fetchCommentsFailure('fail'));
    expect(state.error).toBe('fail');        
  }); 

  // 2. 작성 성공 테스트
  it('createCommentSuccess 테스트', () => {
    const newComment = { id: 2 }; 
    const state = reducer(initialState, createCommentSuccess({ postId: 1, comment: newComment }));
    // 기존에 데이터가 없었으므로 생성된 배열의 첫 번째 요소 확인
    expect(state.comments[1][0]).toEqual(newComment);        
  }); 

  // 3. 삭제 성공 테스트
  it('deleteCommentSuccess 테스트', () => {
    const prev = { ...initialState, comments: { 1: [{ id: 1 }, { id: 2 }] } };
    const state = reducer(prev, deleteCommentSuccess({ postId: 1, commentId: 1 }));
    // id: 1인 댓글이 삭제되고 id: 2만 남아야 함
    expect(state.comments[1]).toEqual([{ id: 2 }]);        
  }); 

  // 4. 수정 성공 테스트
  it('updateCommentSuccess 테스트', () => {
    const prev = { ...initialState, comments: { 1: [{ id: 1, content: 'old' }] } };
    const updated = { id: 1, content: 'new' };
    const state = reducer(prev, updateCommentSuccess({ postId: 1, comment: updated }));
    expect(state.comments[1][0].content).toBe('new');        
  }); 
});