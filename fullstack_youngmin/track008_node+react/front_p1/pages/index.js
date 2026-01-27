import React, { useState } from 'react';
import { Button, Card, Row, Col, Radio, Divider } from 'antd';
import axios from 'axios';

const Home = () => {
  const [recipes, setRecipes] = useState([]);
  const [loading, setLoading] = useState(false);
  const [category, setCategory] = useState('한식'); // 선택된 카테고리 저장용

  const fetchRecipes = async () => {
    setLoading(true);
    try {
      // 주소 끝에 사용자가 선택한 category를 붙여서 보냅니다!
      const response = await axios.get(`http://localhost:3065/recipe/recommend?category=${category}`);
      setRecipes(response.data);
    } catch (error) {
      alert("데이터를 가져오는데 실패했어요!");
    }
    setLoading(false);
  };

  return (
    <div style={{ padding: '30px', maxWidth: '800px', margin: '0 auto' }}>
      <h1>🥘 오늘 뭐 먹지? 레시피 추천</h1>
      <Divider />
      
      <div style={{ marginBottom: '20px' }}>
        <p>어떤 종류의 음식을 좋아하세요?</p>
        {/* 라디오 버튼으로 카테고리 선택 */}
        <Radio.Group value={category} onChange={(e) => setCategory(e.target.value)}>
          <Radio.Button value="한식">한식</Radio.Button>
          <Radio.Button value="일식">일식</Radio.Button>
          <Radio.Button value="중식">중식</Radio.Button>
        </Radio.Group>
        
        <Button 
          type="primary" 
          onClick={fetchRecipes} 
          loading={loading}
          style={{ marginLeft: '10px' }}
        >
          추천 받기
        </Button>
      </div>

      <Row gutter={[16, 16]}>
        {recipes.map((recipe) => (
          <Col span={12} key={recipe.id}>
            <Card title={recipe.title} hoverable cover={<img alt="food" src={recipe.image} />}>
              <Card.Meta description={`${recipe.category} 요리 중 인기 메뉴입니다.`} />
            </Card>
          </Col>
        ))}
      </Row>
    </div>
  );
};

export default Home;