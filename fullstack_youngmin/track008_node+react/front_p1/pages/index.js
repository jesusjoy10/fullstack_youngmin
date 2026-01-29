import React, { useState } from 'react';
import { Button, Card, Row, Col, Divider, Modal, Progress } from 'antd';
import axios from 'axios';

const Home = () => {
  const [recipes, setRecipes] = useState([]);
  const [loading, setLoading] = useState(false);
  
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [step, setStep] = useState(1);
  const [selections, setSelections] = useState({
    mealType: '',
    categoryName: '',
    maxTime: 180,
    difficulty: ''
  });

  const showModal = () => {
    setStep(1);
    setIsModalVisible(true);
  };

  const handleNext = async () => {
    if (step < 4) {
      setStep(step + 1);
    } else {
      setIsModalVisible(false);
      fetchRecommendedRecipes();
    }
  };

  const fetchRecommendedRecipes = async () => {
    setLoading(true);
    try {
      const response = await axios.get(`http://localhost:8484/api/recipe/recommend`, {
        params: {
          categoryName: selections.categoryName,
          difficulty: selections.difficulty,
          maxTime: selections.maxTime
        }
      });
      setRecipes(response.data);
    } catch (error) {
      alert("데이터를 가져오는데 실패했어요!");
    }
    setLoading(false);
  };

  return (
    <div style={{ padding: '30px', maxWidth: '800px', margin: '0 auto' }}>
      <h1>🥘 오늘 뭐 먹지?</h1>
      
      <Button type="primary" size="large" onClick={showModal} style={{ backgroundColor: '#FF6B00', borderColor: '#FF6B00' }}>
        나에게 딱 맞는 레시피 찾기 🔍
      </Button>

      <Divider />

      <Row gutter={[16, 16]}>
        {recipes.map((recipe) => (
          <Col span={12} key={recipe.recipeId}>
            <Card title={recipe.title} hoverable cover={<img alt="food" src={recipe.image} />}>
              <Card.Meta description={`${recipe.cookTime}분 | 난이도: ${recipe.difficulty}`} />
            </Card>
          </Col>
        ))}
      </Row>

      <Modal 
        open={isModalVisible} 
        onCancel={() => setIsModalVisible(false)} 
        footer={null} 
        title="나에게 맞는 레시피 찾기" 
        centered
      >
        <div style={{ marginBottom: '20px' }}>
          <span>진행 상황 {step}/4</span>
          <Progress percent={step * 25} strokeColor="#FF6B00" showInfo={false} />
        </div>

        {/* 1단계: 식사 종류 */}
        {step === 1 && (
          <div style={{ minHeight: '200px' }}>
            <p>어떤 식사를 원하시나요?</p>
            <Row gutter={[10, 10]}>
              {['아침 식사', '점심 식사', '저녁 식사', '간식/디저트'].map(meal => (
                <Col span={12} key={meal}>
                  <Button 
                    block 
                    style={{ 
                      height: '60px', 
                      borderRadius: '8px',
                      borderColor: selections.mealType === meal ? '#FF6B00' : '#d9d9d9'
                    }}
                    onClick={() => setSelections({...selections, mealType: meal})}
                  >
                    {meal}
                  </Button>
                </Col>
              ))}
            </Row>
          </div>
        )}

        {/* 2단계: 음식 종류 */}
        {step === 2 && (
          <div style={{ minHeight: '200px' }}>
            <p>어떤 음식을 좋아하시나요?</p>
            <Row gutter={[10, 10]}>
              {['한식', '양식', '일식', '중식'].map(cat => (
                <Col span={12} key={cat}>
                  <Button 
                    block 
                    onClick={() => setSelections({...selections, categoryName: cat})}
                    style={{ 
                      height: '50px',
                      borderRadius: '8px',
                      borderColor: selections.categoryName === cat ? '#FF6B00' : '#d9d9d9' 
                    }}
                  >
                    {cat}
                  </Button>
                </Col>
              ))}
            </Row>
          </div>
        )}

        {/* 3단계: 조리 시간 */}
        {step === 3 && (
          <div style={{ minHeight: '200px' }}>
            <p style={{ fontWeight: 'bold' }}>조리 시간은 어느 정도가 적당한가요?</p>
            <Row gutter={[10, 10]}>
              {[
                { label: '빠르게 (15분 이내)', value: 15 },
                { label: '적당히 (30분 이내)', value: 30 },
                { label: '여유롭게 (60분 이내)', value: 60 },
                { label: '상관없음', value: 180 }
              ].map(item => (
                <Col span={24} key={item.value}>
                  <Button 
                    block 
                    style={{ 
                      height: '50px', 
                      textAlign: 'left',
                      borderRadius: '8px',
                      borderColor: selections.maxTime === item.value ? '#FF6B00' : '#d9d9d9'
                    }}
                    onClick={() => setSelections({...selections, maxTime: item.value})}
                  >
                    {item.label}
                  </Button>
                </Col>
              ))}
            </Row>
          </div>
        )}

        {/* 4단계: 난이도 */}
        {step === 4 && (
          <div style={{ minHeight: '200px' }}>
            <p style={{ fontWeight: 'bold' }}>어느 정도의 난이도를 원하시나요?</p>
            <Row gutter={[10, 10]}>
              {['아무나', '초급', '중급', '고급'].map(level => (
                <Col span={12} key={level}>
                  <Button 
                    block 
                    style={{ 
                      height: '80px', 
                      borderRadius: '8px',
                      borderColor: selections.difficulty === level ? '#FF6B00' : '#d9d9d9'
                    }}
                    onClick={() => setSelections({...selections, difficulty: level})}
                  >
                    {level}
                  </Button>
                </Col>
              ))}
            </Row>
          </div>
        )}

        <div style={{ marginTop: '30px', textAlign: 'right' }}>
          {step > 1 && <Button onClick={() => setStep(step - 1)}>이전</Button>}
          <Button 
            type="primary" 
            style={{ backgroundColor: '#FF6B00', borderColor: '#FF6B00', marginLeft: '10px' }}
            onClick={handleNext}
          >
            {step === 4 ? '결과 보기' : '다음'}
          </Button>
        </div>
      </Modal>
    </div>
  );
};

export default Home;