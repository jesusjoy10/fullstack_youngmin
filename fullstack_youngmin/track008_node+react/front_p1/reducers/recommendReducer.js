import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  recommendations: [], // mainRecipes 대신 recommendations
  loadRecommendationsLoading: false,
  loadRecommendationsDone: false,
  loadRecommendationsError: null,
  hasSearched: false,
};

const recommendSlice = createSlice({
  name: 'recommend',
  initialState,
  reducers: {
    loadRecommendationsRequest: (state) => {
      state.loadRecommendationsLoading = true;
      state.loadRecommendationsError = null;
      state.loadRecommendationsDone = false;
    },
    loadRecommendationsSuccess: (state, action) => {
      state.loadRecommendationsLoading = false;
      state.loadRecommendationsDone = true;
      state.recommendations = action.payload;
      state.hasSearched = true;
    },
    loadRecommendationsFailure: (state, action) => {
      state.loadRecommendationsLoading = false;
      state.loadRecommendationsError = action.payload;
    },
  },
});

export const {
  loadRecommendationsRequest,
  loadRecommendationsSuccess,
  loadRecommendationsFailure,
} = recommendSlice.actions;

export default recommendSlice.reducer;