// back_p1/models/recipe.js 수정
const Recipe = {
  getRecommended: async (category) => {
    console.log(category + " 카테고리 요청됨");
    
    // 실제로는 DB에서 가져오겠지만, 일단은 로직 확인용 가짜 데이터입니다.
    const allRecipes = {
      '한식': [
        { id: 1, title: '김치찌개', category: '한식', image: 'https://via.placeholder.com/150' },
        { id: 2, title: '제육볶음', category: '한식', image: 'https://via.placeholder.com/150' }
      ],
      '일식': [
        { id: 3, title: '돈카츠', category: '일식', image: 'https://via.placeholder.com/150' },
        { id: 4, title: '라멘', category: '일식', image: 'https://via.placeholder.com/150' }
      ],
      '중식': [
        { id: 5, title: '짜장면', category: '중식', image: 'https://via.placeholder.com/150' },
        { id: 6, title: '탕수육', category: '중식', image: 'https://via.placeholder.com/150' }
      ]
    };

    return allRecipes[category] || [];
  }
};

module.exports = Recipe;