import React, { useState, useCallback } from 'react';
import { Button, Card, Row, Col, Divider, Empty } from 'antd';
import { useSelector } from 'react-redux';
import RecommendModal from '../components/RecommendModal';

const Home = () => {
  const [isModalVisible, setIsModalVisible] = useState(false);
  
  // recommendReducer에서 정의한 상태값 가져오기
  const { recommendations, loadRecommendationsLoading, hasSearched } = useSelector((state) => state.recommend);

  const showModal = useCallback(() => {
    setIsModalVisible(true);
  }, []);

  return (
    <div style={{ padding: '30px', maxWidth: '900px', margin: '0 auto' }}>
      <div style={{ textAlign: 'center', marginBottom: '40px' }}>
        <h1 style={{ fontSize: '2.5rem', fontWeight: 'bold' }}>🥘 오늘 뭐 먹지?</h1>
        <p style={{ color: '#666' }}>결정 장애를 해결해드리는 맞춤형 레시피 추천 서비스</p>
        <Button 
          type="primary" 
          size="large" 
          onClick={showModal} 
          style={{ backgroundColor: '#FF6B00', borderColor: '#FF6B00', height: '50px', padding: '0 40px', borderRadius: '25px', marginTop: '20px' }}
        >
          맞춤 레시피 찾기 시작! 🔍
        </Button>
      </div>

      <Divider />

      {/* 결과 리스트 영역 */}
      {hasSearched && !loadRecommendationsLoading && recommendations.length === 0 ? (
        <Empty description="조건에 맞는 레시피가 없네요. 다른 조건으로 시도해보세요!" />
      ) : (
        <Row gutter={[20, 20]}>
          {recommendations.map((item) => (
            <Col xs={24} sm={12} md={8} key={item.recipeId}>
              <Card 
                hoverable
                loading={loadRecommendationsLoading}
              cover={
   
          <img 
            alt={item.title} 
            src={`http://localhost:8484/uploads/${item.image}`} 
            style={{ height: '200px', objectFit: 'cover' }} 
          />
        }
>
              
                <Card.Meta 
                  title={item.title} 
                  description={
                    <div>
                      <p>{item.categoryName} | {item.difficulty}</p>
                      <p style={{ color: '#FF6B00', fontWeight: 'bold' }}>{item.cookTime}분 소요</p>
                    </div>
                  } 
                />
              </Card>
            </Col>
          ))}
        </Row>
      )}

      {/* 분리된 모달 컴포넌트 */}
      <RecommendModal 
        open={isModalVisible} 
        setOpen={setIsModalVisible} 
      />
    </div>
  );
};

export default Home;