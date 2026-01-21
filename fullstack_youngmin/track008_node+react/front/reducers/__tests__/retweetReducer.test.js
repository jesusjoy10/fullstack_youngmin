import reducer, {
  addRetweetSuccess,
  addRetweetFailure,
  removeRetweetSuccess,
  hasRetweetedSuccess,
  fetchMyRetweetsSuccess,
} from '../retweetReducer';

describe('retweet reducer ', () => {
  const initialState = {
    retweets: {},       
    retweetsCount: {},  
    loading: false,
    error: null,
  };

  // 1. 리트윗 추가 성공 테스트
  it('addRetweetSuccess ', () => {
    const postId = 1;
    const retweetCount = 10;
    
    // 리듀서 실행
    const state = reducer(initialState, addRetweetSuccess({ postId, retweetCount }));
    
    // 검증: 해당 포스트 아이디의 리트윗 여부는 true, 카운트는 10이어야 함
    expect(state.retweets[postId]).toBe(true);
    expect(state.retweetsCount[postId]).toBe(10);
    expect(state.loading).toBe(false);
  });

  // 2. 리트윗 실패 테스트
  it('addRetweetFailure', () => {
    const errorMsg = '리트윗 실패';
    const state = reducer(initialState, addRetweetFailure(errorMsg));
    
    expect(state.error).toBe(errorMsg);
    expect(state.loading).toBe(false);
  });

  // 3. 리트윗 취소 성공 테스트
  it('removeRetweetSuccess', () => {
    // 기존에 리트윗이 되어 있던 상태를 가정 (prev)
    const prev = {
      ...initialState,
      retweets: { 1: true },
      retweetsCount: { 1: 10 }
    };
    
    const state = reducer(prev, removeRetweetSuccess({ postId: 1, retweetCount: 9 }));
    
    // 검증: 리트윗 여부는 false로 바뀌고, 카운트는 9가 되어야 함
    expect(state.retweets[1]).toBe(false);
    expect(state.retweetsCount[1]).toBe(9);
  });

  // 4. 특정 포스트 리트윗 여부 확인 테스트
  it('hasRetweetedSuccess ', () => {
    const state = reducer(initialState, hasRetweetedSuccess({ postId: 2, hasRetweeted: true }));
    
    expect(state.retweets[2]).toBe(true);
  });

  // 5. 내 리트윗 목록 일괄 업데이트 테스트
  it('fetchMyRetweetsSuccess ', () => {
    const myRetweets = { 101: true, 102: true };
    const state = reducer(initialState, fetchMyRetweetsSuccess(myRetweets));
    
    // 검증: 기존 retweets 객체에 새로운 목록이 병합되어야 함
    expect(state.retweets[101]).toBe(true);
    expect(state.retweets[102]).toBe(true);
  });
});