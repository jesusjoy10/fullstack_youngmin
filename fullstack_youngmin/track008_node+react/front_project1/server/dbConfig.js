const oracledb = require('oracledb');
require('dotenv').config();

// 5.5.0 버전에서는 별도의 Client 설정 없이 아래 연결 정보만 있으면 됩니다.
async function executeQuery(sql, params = []) {
  let connection;
  try {
    connection = await oracledb.getConnection({
      user: process.env.DB_USER,
      password: process.env.DB_PASSWORD,
      connectString: process.env.DB_CONNECTSTRING // localhost:1521/xe
    });

    const result = await connection.execute(sql, params, { 
      outFormat: oracledb.OUT_FORMAT_OBJECT,
      autoCommit: true 
    });
    
    return result;
  } catch (err) {
    console.error("DB 오류 발생:", err);
    throw err;
  } finally {
    if (connection) {
      try { await connection.close(); } catch (e) {}
    }
  }
}

module.exports = { executeQuery };