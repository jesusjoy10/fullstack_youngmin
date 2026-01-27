// back_p1/routes/recipe.js
const express = require('express');
const router = express.Router();
const Recipe = require('../models/recipe');

// '서버주소/recipe/recommend'로 접속하면 실행되는 코드입니다.
router.get('/recommend', async (req, res) => {
  const category = req.query.category || '한식';
  const recommendations = await Recipe.getRecommended(category);
  res.json(recommendations);
});

module.exports = router;