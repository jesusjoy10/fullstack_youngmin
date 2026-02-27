const express = require('express');
const app = express();
const cors = require('cors');
// dbConfig와 executeQuery 임포트 확인 (본인 경로에 맞게)
const { executeQuery } = require('./dbConfig'); 

app.use(cors());
app.use(express.json());

app.get('/api/recommend/questions', async (req, res) => {
    try {
        console.log("데이터 요청 받음...");
        
        // 1. 질문 조회
        const qSql = `SELECT * FROM RECIPE_QUESTIONS ORDER BY STEP_NO ASC`;
        const qResult = await executeQuery(qSql);
        // 오라클 결과 구조에 따라 rows가 없을 경우 대비
        const questions = qResult.rows ? qResult.rows : qResult;

        const results = [];

        // 2. 동기적으로 옵션 합치기
        for (const q of questions) {
            const qid = q.Q_ID || q.q_id;
            const optSql = `SELECT * FROM RECIPE_OPTIONS WHERE Q_ID = :1`;
            const optResult = await executeQuery(optSql, [qid]);
            const options = optResult.rows ? optResult.rows : optResult;

            results.push({
                ...q,
                options: options // 이 배열이 반드시 포함되어야 함
            });
        }

        console.log("전송할 데이터 개수:", results.length);
        res.json(results);
    } catch (err) {
        console.error("서버 에러 상세:", err);
        res.status(500).send("서버 에러 발생");
    }
});

app.listen(5000, () => {
    console.log("백엔드 서버가 5000번 포트에서 실행 중입니다!");
});