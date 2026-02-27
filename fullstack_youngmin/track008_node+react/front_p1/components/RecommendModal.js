import React, { useState, useCallback } from 'react';
import { Modal, Progress, Row, Col, Button } from 'antd';
import { useDispatch } from 'react-redux';
import { loadRecommendationsRequest } from '../reducers/recommendReducer';

const RecommendModal = ({ open, setOpen }) => {
  const dispatch = useDispatch();
  const [step, setStep] = useState(1);
  const [selections, setSelections] = useState({
    mealType: '',
    categoryName: '',
    maxTime: 180,
    difficulty: ''
  });

  const onCancel = useCallback(() => {
    setOpen(false);
    setStep(1); // 닫으면 초기화
  }, [setOpen]);

  const handleNext = useCallback(() => {
    if (step < 4) {
      setStep(step + 1);
    } else {
      setOpen(false);
      // 🔥 정석: Payload에 설문 데이터 담아서 Saga로 발송
      dispatch(loadRecommendationsRequest(selections));
    }
  }, [step, selections, dispatch, setOpen]);

  return (
    <Modal 
      open={open} 
      onCancel={onCancel} 
      footer={null} 
      title="✨ 나만을 위한 맞춤 추천" 
      centered
    >
      <div style={{ marginBottom: '20px' }}>
        <span style={{ fontWeight: 'bold' }}>진행 상황 {step}/4</span>
        <Progress percent={step * 25} strokeColor="#FF6B00" showInfo={false} />
      </div>

      <div style={{ minHeight: '250px' }}>
        {step === 1 && (
          <>
            <p style={{ fontSize: '16px', marginBottom: '20px' }}>어떤 식사를 원하시나요?</p>
            <Row gutter={[10, 10]}>
              {['아침 식사', '점심 식사', '저녁 식사', '간식/디저트'].map(v => (
                <Col span={12} key={v}>
                  <Button 
                    block 
                    style={{ height: '60px', borderRadius: '8px', borderColor: selections.mealType === v ? '#FF6B00' : '#d9d9d9' }}
                    onClick={() => setSelections({...selections, mealType: v})}
                  >
                    {v}
                  </Button>
                </Col>
              ))}
            </Row>
          </>
        )}

        {step === 2 && (
          <>
            <p style={{ fontSize: '16px', marginBottom: '20px' }}>좋아하는 카테고리를 골라주세요.</p>
            <Row gutter={[10, 10]}>
              {['한식', '양식', '일식', '중식'].map(v => (
                <Col span={12} key={v}>
                  <Button 
                    block 
                    style={{ height: '50px', borderRadius: '8px', borderColor: selections.categoryName === v ? '#FF6B00' : '#d9d9d9' }}
                    onClick={() => setSelections({...selections, categoryName: v})}
                  >
                    {v}
                  </Button>
                </Col>
              ))}
            </Row>
          </>
        )}

        {step === 3 && (
          <>
            <p style={{ fontSize: '16px', marginBottom: '20px' }}>조리 시간은 어느 정도가 좋을까요?</p>
            {[
              { label: '빠르게 (15분 이내)', value: 15 },
              { label: '적당히 (30분 이내)', value: 30 },
              { label: '여유롭게 (60분 이내)', value: 60 },
              { label: '상관없음', value: 180 }
            ].map(item => (
              <Button 
                key={item.value} 
                block 
                style={{ height: '45px', marginBottom: '10px', borderRadius: '8px', textAlign: 'left', borderColor: selections.maxTime === item.value ? '#FF6B00' : '#d9d9d9' }}
                onClick={() => setSelections({...selections, maxTime: item.value})}
              >
                {item.label}
              </Button>
            ))}
          </>
        )}

        {step === 4 && (
          <>
            <p style={{ fontSize: '16px', marginBottom: '20px' }}>희망하는 난이도를 선택해 주세요.</p>
            <Row gutter={[10, 10]}>
              {['아무나', '초급', '중급', '고급'].map(v => (
                <Col span={12} key={v}>
                  <Button 
                    block 
                    style={{ height: '80px', borderRadius: '8px', borderColor: selections.difficulty === v ? '#FF6B00' : '#d9d9d9' }}
                    onClick={() => setSelections({...selections, difficulty: v})}
                  >
                    {v}
                  </Button>
                </Col>
              ))}
            </Row>
          </>
        )}
      </div>

      <div style={{ marginTop: '30px', textAlign: 'right' }}>
        {step > 1 && <Button onClick={() => setStep(step - 1)} style={{ marginRight: '8px' }}>이전</Button>}
        <Button 
          type="primary" 
          style={{ backgroundColor: '#FF6B00', borderColor: '#FF6B00' }} 
          onClick={handleNext}
        >
          {step === 4 ? '추천 레시피 보기' : '다음'}
        </Button>
      </div>
    </Modal>
  );
};

export default RecommendModal;