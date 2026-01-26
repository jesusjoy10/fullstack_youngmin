import 'antd/dist/antd.css';
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Modal, Button, Progress, Checkbox, Card, Spin } from 'antd';
import { ArrowRightOutlined, LoadingOutlined } from '@ant-design/icons';

export default function RecipeSurvey() {
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [allQuestions, setAllQuestions] = useState([]);
  const [currentStep, setCurrentStep] = useState(1);
  const [selectedOptions, setSelectedOptions] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    axios.get('http://localhost:5000/api/recommend/questions')
      .then(res => {
        console.log("받은 데이터:", res.data);
        setAllQuestions(res.data);
        setLoading(false);
      })
      .catch(err => {
        console.error("데이터 로드 실패:", err);
        setLoading(false);
      });
  }, []);

  // 대소문자 방어 로직 (STEP_NO 또는 step_no 모두 체크)
  const currentQuestion = allQuestions.find(q => (q.STEP_NO || q.step_no) === currentStep);
  const totalSteps = 4;

  const showModal = () => setIsModalVisible(true);
  const handleCancel = () => {
    setIsModalVisible(false);
    setCurrentStep(1); // 닫을 때 단계 초기화
  };

  const handleNext = () => {
    if (currentStep < totalSteps) {
      setCurrentStep(currentStep + 1);
      setSelectedOptions([]);
    } else {
      alert("추천 로직으로 넘어갑니다!");
    }
  };

  return (
    <div style={{ padding: '100px', textAlign: 'center', backgroundColor: '#f9f9f9', minHeight: '100vh' }}>
      <Button 
        type="primary" 
        danger 
        size="large" 
        icon={<ArrowRightOutlined />} 
        onClick={showModal} 
        style={{ width: '350px', height: '60px', borderRadius: '30px', fontSize: '18px', fontWeight: 'bold' }}
      >
        나에게 딱 맞는 레시피 찾기
      </Button>

      <Modal 
        title={null} 
        open={isModalVisible} 
        onCancel={handleCancel} 
        footer={null} 
        width={750} 
        centered 
        destroyOnClose={true}
        bodyStyle={{ padding: '40px', borderRadius: '20px' }}
      >
        <div style={{ marginBottom: '20px' }}>
          <h2 style={{ fontSize: '24px', fontWeight: 'bold' }}>🍳 나에게 맞는 레시피 찾기</h2>
          <p style={{ color: '#888' }}>몇 가지 질문에 답하면 맞춤 레시피를 추천해드려요</p>
        </div>

        <div style={{ marginBottom: '40px' }}>
          <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '10px' }}>
            <span style={{ fontWeight: '500' }}>진행 상황</span>
            <span style={{ color: '#888' }}>{currentStep} / {totalSteps}</span>
          </div>
          <Progress percent={(currentStep / totalSteps) * 100} showInfo={false} strokeColor="#333" strokeWidth={10} />
        </div>

        {loading ? (
          <div style={{ textAlign: 'center', padding: '40px' }}><Spin indicator={<LoadingOutlined style={{ fontSize: 24 }} spin />} /></div>
        ) : currentQuestion ? (
          <div style={{ marginTop: '30px' }}>
            <h3 style={{ fontSize: '20px', marginBottom: '10px' }}>{currentQuestion.TITLE || currentQuestion.title}</h3>
            <p style={{ color: '#999', marginBottom: '25px' }}>{currentQuestion.DESCRIPTION || currentQuestion.description} (중복 선택 가능)</p>
            
            <Checkbox.Group style={{ width: '100%' }} value={selectedOptions} onChange={(vals) => setSelectedOptions(vals)}>
              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '15px' }}>
                {/* options 또는 OPTIONS 배열을 찾아 반복문 실행 */}
                {(currentQuestion.options || currentQuestion.OPTIONS || []).map(opt => (
                  <Card 
                    key={opt.OPT_ID || opt.opt_id} 
                    hoverable 
                    bodyStyle={{ padding: '20px' }}
                    style={{ borderRadius: '12px', border: '1.5px solid #f0f0f0' }}
                  >
                    <Checkbox value={opt.OPT_VALUE || opt.opt_value} style={{ fontSize: '16px', width: '100%' }}>
                      {opt.OPT_LABEL || opt.opt_label}
                    </Checkbox>
                  </Card>
                ))}
              </div>
            </Checkbox.Group>
          </div>
        ) : (
          <div style={{ padding: '40px', textAlign: 'center' }}>
            <p>질문 데이터를 찾을 수 없습니다.</p>
            {/* 디버깅용 JSON 출력 (문제 해결 후 삭제) */}
            <pre style={{ textAlign: 'left', fontSize: '10px', background: '#eee', padding: '10px' }}>
              {JSON.stringify(allQuestions, null, 2)}
            </pre>
          </div>
        )}

        <div style={{ marginTop: '50px', textAlign: 'right' }}>
          <Button 
            type="primary" 
            danger 
            size="large" 
            onClick={handleNext} 
            style={{ width: '130px', height: '50px', borderRadius: '10px', backgroundColor: '#ff6b6b', borderColor: '#ff6b6b' }}
          >
            다음 <ArrowRightOutlined />
          </Button>
        </div>
      </Modal>
    </div>
  );
}