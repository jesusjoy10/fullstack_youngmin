// toolkit 없이 순수 리덕스 방식으로 교체!
export const initialState = {
  recommendations: [],
  loadRecommendationsLoading: false,
  loadRecommendationsDone: false,
  loadRecommendationsError: null,
  hasSearched: false,
};

// 액션 이름 정의
export const LOAD_RECOMMENDATIONS_REQUEST = 'LOAD_RECOMMENDATIONS_REQUEST';
export const LOAD_RECOMMENDATIONS_SUCCESS = 'LOAD_RECOMMENDATIONS_SUCCESS';
export const LOAD_RECOMMENDATIONS_FAILURE = 'LOAD_RECOMMENDATIONS_FAILURE';

// 액션 생성 함수 (Saga에서 사용)
export const loadRecommendationsRequest = (data) => ({
  type: LOAD_RECOMMENDATIONS_REQUEST,
  payload: data,
});

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case LOAD_RECOMMENDATIONS_REQUEST:
      return {
        ...state,
        loadRecommendationsLoading: true,
        loadRecommendationsError: null,
        loadRecommendationsDone: false,
      };
    case LOAD_RECOMMENDATIONS_SUCCESS:
      return {
        ...state,
        loadRecommendationsLoading: false,
        loadRecommendationsDone: true,
        recommendations: action.payload,
        hasSearched: true,
      };
    case LOAD_RECOMMENDATIONS_FAILURE:
      return {
        ...state,
        loadRecommendationsLoading: false,
        loadRecommendationsError: action.payload,
      };
    default:
      return state;
  }
};

export default reducer;