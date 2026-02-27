import React, { useState, useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { Modal, Button, Steps, Checkbox, Select, Cascader, Spin, Row, Col, Card, Empty, Tag, Divider } from 'antd';
import { AppstoreOutlined, EnvironmentOutlined, TagsOutlined, ReloadOutlined, HistoryOutlined } from '@ant-design/icons';
import { recommendPostsRequest } from '../reducers/postReducer';

const RecommendModal = ({ open, onClose }) => {
    const dispatch = useDispatch();
    const [current, setCurrent] = useState(0);
    const [mounted, setMounted] = useState(false);
    const [showResult, setShowResult] = useState(false);
    
    const { recommendPosts, recommendPostsLoading, recommendHistory } = useSelector((state) => state.post);

    const [selection, setSelection] = useState({
        categories: [],
        location: [],
        tags: [],
    });

    useEffect(() => {
        setMounted(true);
    }, []);

    const onCardClick = (postId) => {
        handleClose(); 
        const element = document.getElementById(`post-${postId}`);
        if (element) {
            element.scrollIntoView({ behavior: 'smooth', block: 'center' });
            element.style.transition = 'background-color 0.5s';
            element.style.backgroundColor = '#fffbe6';
            setTimeout(() => {
                element.style.backgroundColor = 'transparent';
            }, 1500);
        }
    };

    const categoryOptions = ['한식', '일식', '중식', '양식', '디저트'];

    const locationOptions = [
        {
            value: '서울', label: '서울',
            children: [
                { value: '홍대/연남', label: '홍대/연남' }, { value: '강남/역삼', label: '강남/역삼' },
                { value: '성수/건대', label: '성수/건대' }, { value: '이태원/한남', label: '이태원/한남' },
                { value: '을지로/종로', label: '을지로/종로' },
            ],
        },
        {
            value: '인천광역시', label: '인천광역시',
            children: [
                { value: '부평', label: '부평' }, { value: '구월', label: '구월' },
                { value: '송도', label: '송도' }, { value: '주안', label: '주안' },
                { value: '청라', label: '청라' }, { value: '동인천', label: '동인천' },
            ],
        },
        {
            value: '경기도', label: '경기도',
            children: [
                { value: '부천', label: '부천' }, { value: '남양주', label: '남양주' },
                { value: '성남/분당', label: '성남/분당' }, { value: '시흥', label: '시흥' },
                { value: '수원', label: '수원' }, { value: '용인', label: '용인' },
                { value: '고양/일산', label: '고양/일산' }, { value: '안산', label: '안산' },
                { value: '평택', label: '평택' }, { value: '의정부', label: '의정부' },
                { value: '파주', label: '파주' }, { value: '김포', label: '김포' },
                { value: '광명', label: '광명' }, { value: '군포', label: '군포' },
                { value: '화성', label: '화성' },
            ],
        },
        {
            value: '경상도', label: '경상도',
            children: [
                { value: '부산', label: '부산' }, { value: '대구', label: '대구' },
                { value: '울산', label: '울산' }, { value: '창원', label: '창원' },
            ],
        },
        {
            value: '전라도', label: '전라도',
            children: [ { value: '광주', label: '광주' }, { value: '전주', label: '전주' } ],
        },
        {
            value: '충청도', label: '충청도',
            children: [ { value: '대전', label: '대전' }, { value: '세종', label: '세종' } ],
        },
        {
            value: '강원도/제주', label: '강원도/제주',
            children: [ { value: '강릉', label: '강릉' }, { value: '제주', label: '제주' } ],
        },
    ];

    const onFinish = () => {
        dispatch(recommendPostsRequest(selection));
        setShowResult(true);
    };

    const handleClose = () => {
        onClose();
        setTimeout(() => {
            setCurrent(0);
            setShowResult(false);
            setSelection({ categories: [], location: [], tags: [] });
        }, 300);
    };

    if (!mounted) return null;

    return (
        <Modal
            title={showResult ? "🎁 당신을 위한 추천 결과" : "✨ 나에게 딱 맞는 맛집 찾기"}
            open={open}
            onCancel={handleClose}
            width={showResult ? 800 : 600}
            footer={showResult ? [
                <Button key="retry" icon={<ReloadOutlined />} onClick={() => setShowResult(false)}>다시 찾기</Button>,
                <Button key="close" type="primary" onClick={handleClose}>닫기</Button>
            ] : [
                current > 0 && <Button key="back" onClick={() => setCurrent(current - 1)}>이전</Button>,
                current < 2 && (
                    <Button key="next" type="primary" onClick={() => setCurrent(current + 1)} disabled={current === 0 && selection.categories.length === 0}>
                        다음
                    </Button>
                ),
                current === 2 && (
                    <Button key="submit" type="primary" onClick={onFinish} style={{ background: '#ff9f43', borderColor: '#ff9f43' }}>
                        추천받기
                    </Button>
                ),
            ]}
        >
            {!showResult ? (
                <>
                    <Steps 
                        current={current} 
                        size="small" 
                        style={{ marginBottom: 24 }} 
                        items={[{ title: '카테고리', icon: <AppstoreOutlined /> }, { title: '지역', icon: <EnvironmentOutlined /> }, { title: '특징', icon: <TagsOutlined /> }]} 
                    />
                    <div style={{ minHeight: '220px' }}>
                        {current === 0 && (
                            <div>
                                <h3 style={{ marginBottom: 16 }}>어떤 음식을 원하시나요?</h3>
                                <Checkbox.Group 
                                    options={categoryOptions} 
                                    value={selection.categories}
                                    onChange={(list) => setSelection({ ...selection, categories: list })}
                                    style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '12px' }}
                                />
                            </div>
                        )}
                        {current === 1 && (
                            <div>
                                <h3 style={{ marginBottom: 16 }}>어디에서 찾으시나요?</h3>
                                <Cascader
                                    options={locationOptions}
                                    placeholder="지역을 선택하세요"
                                    style={{ width: '100%' }}
                                    value={selection.location}
                                    onChange={(val) => setSelection({ ...selection, location: val })}
                                />
                            </div>
                        )}
                        {current === 2 && (
                            <div>
                                <h3 style={{ marginBottom: 16 }}>원하는 특징이 있나요?</h3>
                                <Select
                                    mode="tags"
                                    placeholder="예: 주차가능, 가성비 (엔터로 구분)"
                                    style={{ width: '100%' }}
                                    value={selection.tags}
                                    onChange={(tags) => setSelection({ ...selection, tags: tags })}
                                />
                            </div>
                        )}
                    </div>
                </>
            ) : (
                <div>
                    <Spin spinning={recommendPostsLoading}>
                        {recommendPosts.length > 0 ? (
                            <Row gutter={[16, 16]} style={{ marginTop: 10 }}>
                                {recommendPosts.map((post) => (
                                    <Col span={8} key={post.id}>
                                        <Card
                                            hoverable
                                            onClick={() => onCardClick(post.id)}
                                            style={{ borderRadius: 12, overflow: 'hidden' }}
                                            cover={<img alt="shop" src={post.Images?.[0]?.src || 'https://via.placeholder.com/150'} style={{ height: 110, objectFit: 'cover' }} />}
                                        >
                                            <Card.Meta 
                                                title={<div style={{ fontSize: 13, overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>{post.title}</div>}
                                                description={<Tag color="orange" style={{ fontSize: 10 }}>{post.category}</Tag>}
                                            />
                                        </Card>
                                    </Col>
                                ))}
                            </Row>
                        ) : (
                            !recommendPostsLoading && <Empty description="추천 결과가 없어요. 조건을 바꿔보세요!" style={{ padding: '40px 0' }} />
                        )}

                        {!recommendPostsLoading && recommendHistory?.length > 0 && (
                            <div style={{ marginTop: 30 }}>
                                <Divider orientation="left" style={{ fontSize: 12, color: '#999' }}>
                                    <HistoryOutlined /> 최근 추천 히스토리
                                </Divider>
                                <div style={{ maxHeight: 150, overflowY: 'auto' }}>
                                    {recommendHistory.map((h) => (
                                        <div key={h.id} style={{ marginBottom: 12, paddingBottom: 8, borderBottom: '1px solid #f0f0f0' }}>
                                            <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 4 }}>
                                                <span style={{ color: '#888', fontSize: 11 }}>
                                                    {h.selection.categories.join(', ')} | {h.selection.location.join(' ') || '지역무관'}
                                                </span>
                                                <span style={{ fontSize: 10, color: '#ccc' }}>{h.date.split(' ')[1]}</span>
                                            </div>
                                            <div style={{ display: 'flex', flexWrap: 'wrap', gap: 4 }}>
                                                <span style={{ color: '#ff9f43', fontSize: 12, fontWeight: 'bold' }}>👉</span>
                                                {h.shopNames?.map((name, i) => (
                                                    <Tag key={i} color="orange" style={{ fontSize: 11, margin: 0 }}>{name}</Tag>
                                                ))}
                                            </div>
                                        </div>
                                    ))}
                                </div>
                            </div>
                        )}
                    </Spin>
                </div>
            )}
        </Modal>
    );
};

export default RecommendModal;