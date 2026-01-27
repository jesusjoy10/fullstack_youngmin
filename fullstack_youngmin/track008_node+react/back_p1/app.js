// back_p1/app.js
const express = require('express');
const cors = require('cors'); // 1. 이 줄이 있는지 확인!
const app = express();
const recipeRouter = require('./routes/recipe');

// 2. 이 부분이 반드시 recipeRouter 등록보다 "위"에 있어야 합니다!
app.use(cors({
  origin: 'http://localhost:3001', // 리액트 주소 허용
  credentials: true,
}));

app.get('/', (req, res) => {
  res.send('백엔드 서버 정상 작동 중!');
});

app.use('/recipe', recipeRouter);

app.listen(3065, () => {
  console.log('서버 실행 중: http://localhost:3065');
});