export const initialState = {
    searchPosts: [], // 검색 결과 리스트
    searchHistory: [], // 최근 검색 기록
    searchLoading: false,
    searchDone: false,
    searchError: null,
};

export const SEARCH_REQUEST = 'SEARCH_REQUEST';
export const SEARCH_SUCCESS = 'SEARCH_SUCCESS';
export const SEARCH_FAILURE = 'SEARCH_FAILURE';

export const LOAD_HISTORY_REQUEST = 'LOAD_HISTORY_REQUEST';
export const LOAD_HISTORY_SUCCESS = 'LOAD_HISTORY_SUCCESS';
export const LOAD_HISTORY_FAILURE = 'LOAD_HISTORY_FAILURE';

const reducer = (state = initialState, action) => {
    switch (action.type) {
        case SEARCH_REQUEST:
            return { ...state, searchLoading: true, searchDone: false };
        case SEARCH_SUCCESS:
            return { ...state, searchLoading: false, searchDone: true, searchPosts: action.data };
        case LOAD_HISTORY_SUCCESS:
            return { ...state, searchHistory: action.data };
        default:
            return state;
    }
};

export default reducer;