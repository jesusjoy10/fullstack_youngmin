import { useState, useEffect, useMemo, useCallback } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Spin, message, Tabs, Button, Modal, Form, Input, Upload, Radio } from "antd"; 
import { PlusOutlined, UploadOutlined, FilterOutlined, SettingOutlined } from "@ant-design/icons";
import { useRouter } from 'next/router';
import InfiniteScroll from "react-infinite-scroll-component";

// 컴포넌트 및 액션 임포트
import MaterialList from "../components/MaterialList"; 
import PostList from "../components/PostList";
import EditPostModal from "../components/EditPostModal";

import { LOAD_MATERIALS_REQUEST, ADD_MATERIAL_REQUEST } from "../reducers/material";
import { 
    fetchPostsPagedRequest, 
    fetchCategoryPostsRequest, 
    fetchLikedPostsRequest, 
    fetchMyAndRetweetsRequest, 
    updatePostRequest,
    UPDATE_POST_RESET 
} from "../reducers/postReducer";
import { addLikeRequest, removeLikeRequest, fetchMyLikesRequest } from "../reducers/likeReducer";
import { toggleFollowRequest, loadFollowingsRequest } from "../reducers/followReducer";
import { fetchMyRetweetsRequest } from "../reducers/retweetReducer";

export default function Home() {
    const dispatch = useDispatch();
    const router = useRouter();
    const [form] = Form.useForm();

    //// 1. Reducer 상태 추출
    const { user } = useSelector((state) => state.auth);
    const { posts, likedPosts, myAndRetweets, loading, hasNext, updatePostDone } = useSelector((state) => state.post);
    const { likes = {}, likesCount = {}, loading: likeLoading } = useSelector((state) => state.like);
    const { followingsMap, loading: followLoading } = useSelector((state) => state.follow);
    const { retweets, retweetsCount } = useSelector((state) => state.retweet);
    const { mainMaterials, loadMaterialsLoading } = useSelector((state) => state.material);

    //// 2. UI 제어용 로컬 상태
    const [expandedPostId, setExpandedPostId] = useState(null);
    const [isEditModalVisible, setIsEditModalVisible] = useState(false);
    const [editPost, setEditPost] = useState(null);
    const [uploadFiles, setUploadFiles] = useState([]);
    const [pageAll, setPageAll] = useState(1);
    const [currentCategory, setCurrentCategory] = useState("전체"); 
    
    const [isMaterialModalVisible, setIsMaterialModalVisible] = useState(false);
    const [materialFile, setMaterialFile] = useState(null);

    //// 3. 이벤트 핸들러

    useEffect(() => {
        if (updatePostDone) {
            message.success("레시피가 수정되었습니다.");
            setIsEditModalVisible(false);
            setEditPost(null);
            setUploadFiles([]);
            dispatch({ type: UPDATE_POST_RESET });
        }
    }, [updatePostDone, dispatch]);

    const handleEdit = useCallback((post) => { 
        setEditPost(post); 
        setIsEditModalVisible(true); 
        setUploadFiles([]); 
    }, []);

    const handleEditSubmit = useCallback((values) => {
        if (!editPost) return;
        dispatch(updatePostRequest({
            postId: editPost.id,
            dto: {
                title: values.title,
                category: values.category,
                servingSize: values.servingSize,
                difficulty: values.difficulty,
                description: values.description, 
                instructions: values.instructions, 
                content: values.instructions, 
                ingredients: values.ingredients,
                hashtags: Array.isArray(values.hashtags) ? values.hashtags.join(",") : values.hashtags,
            },
            files: uploadFiles.map(f => f.originFileObj).filter(Boolean), 
        }));
    }, [dispatch, editPost, uploadFiles]);

    const onSaveMaterial = useCallback((values) => {
        const formData = new FormData();
        formData.append("title", values.title);
        formData.append("category", values.category);
        formData.append("allergy", values.allergy || "");
        formData.append("efficacy", values.efficacy || "");
        if (materialFile) formData.append("file", materialFile);

        dispatch({ type: ADD_MATERIAL_REQUEST, data: formData });
        setIsMaterialModalVisible(false);
        form.resetFields();
    }, [dispatch, materialFile, form]);

    const handleToggleLike = useCallback((postId) => {
        if (!user) return message.warning("로그인 후 이용 가능합니다.");
        const key = String(postId);
        likes[key] === true ? dispatch(removeLikeRequest({ postId })) : dispatch(addLikeRequest({ postId }));
    }, [user, likes, dispatch]);

    const handleToggleFollow = useCallback((authorId) => {
        if (!user) return message.warning("로그인 후 이용 가능합니다.");
        dispatch(toggleFollowRequest(authorId));
    }, [user, dispatch]);

    const onCategoryChange = useCallback((e) => {
        const category = e.target.value;
        setCurrentCategory(category);
        setPageAll(1);

        if (category === "전체") {
            dispatch(fetchPostsPagedRequest({ page: 1, size: 10 }));
            setPageAll(2);
        } else {
            dispatch(fetchCategoryPostsRequest({ category }));
        }
    }, [dispatch]);

    useEffect(() => {
        dispatch(fetchPostsPagedRequest({ page: 1, size: 10 }));
        setPageAll(2);

        if (user) {
            dispatch({ type: LOAD_MATERIALS_REQUEST, data: 1 });
            dispatch(fetchLikedPostsRequest({ page: 1, size: 10 }));
            dispatch(fetchMyAndRetweetsRequest({ page: 1, size: 10 }));
            dispatch(fetchMyLikesRequest({ userId: user.id }));
            dispatch(fetchMyRetweetsRequest({ userId: user.id }));
            dispatch(loadFollowingsRequest());
        }
    }, [dispatch, user]);

    const fetchMoreAll = useCallback(() => {
        if (!hasNext || currentCategory !== "전체") return;
        dispatch(fetchPostsPagedRequest({ page: pageAll, size: 10 }));
        setPageAll((prev) => prev + 1);
    }, [hasNext, currentCategory, pageAll, dispatch]);

    //// 5. 탭 구성
    const tabItems = useMemo(() => {
        const items = [];

        items.push({
            key: "all",
            label: "🍳 레시피 피드",
            children: (
                <div style={{ padding: '10px 0' }}>
                    <div style={{ textAlign: 'center', marginBottom: '20px', background: '#fff', padding: '15px', borderRadius: '8px', boxShadow: '0 2px 8px rgba(0,0,0,0.05)' }}>
                        <FilterOutlined style={{ marginRight: 8 }} />
                        <Radio.Group value={currentCategory} onChange={onCategoryChange} buttonStyle="solid">
                            <Radio.Button value="전체">전체</Radio.Button>
                            <Radio.Button value="한식">한식</Radio.Button>
                            <Radio.Button value="일식">일식</Radio.Button>
                            <Radio.Button value="중식">중식</Radio.Button>
                            <Radio.Button value="양식">양식</Radio.Button>
                            <Radio.Button value="디저트">디저트</Radio.Button>
                        </Radio.Group>
                    </div>

                    <InfiniteScroll
                        dataLength={posts.length}
                        next={fetchMoreAll}
                        hasMore={hasNext && currentCategory === "전체"}
                        loader={<Spin tip="더 불러오는 중..." style={{ display: 'block', margin: '20px auto' }} />}
                    >
                        <PostList
                            posts={posts} user={user} likes={likes} likesCount={likesCount}
                            retweetedPosts={retweets} retweetsCount={retweetsCount}
                            expandedPostId={expandedPostId} setExpandedPostId={setExpandedPostId}
                            handleToggleLike={handleToggleLike} 
                            handleToggleFollow={handleToggleFollow}
                            handleEdit={handleEdit} dispatch={dispatch} likeLoading={likeLoading}
                            followingsMap={followingsMap} followLoading={followLoading}
                            title={currentCategory === "전체" ? "모든 레시피" : `${currentCategory} 레시피`}
                        />
                    </InfiniteScroll>
                </div>
            )
        });

        if (user) {
            // ✅ 식재료 추가 버튼 권한 체크도 ROLE_ADMIN으로 변경
            const isAdmin = user.role === 'ROLE_ADMIN' || user.role === 'ADMIN';

            items.push({
                key: "material",
                label: "🍲 추천 식재료",
                children: (
                    <div style={{ padding: '20px' }}>
                        {isAdmin && (
                            <div style={{ marginBottom: 20, textAlign: 'right' }}>
                                <Button type="primary" icon={<PlusOutlined />} onClick={() => setIsMaterialModalVisible(true)}>
                                    식재료 추가 (관리자)
                                </Button>
                            </div>
                        )}
                        {loadMaterialsLoading && <Spin tip="재료 불러오는 중..." />}
                        <MaterialList materials={mainMaterials || []} />
                    </div>
                )
            });

            items.push(
                {
                    key: "liked",
                    label: "❤️ 좋아요",
                    children: <PostList posts={likedPosts} user={user} likes={likes} followingsMap={followingsMap} handleToggleLike={handleToggleLike} handleToggleFollow={handleToggleFollow} dispatch={dispatch} title="내가 찜한 레시피" />
                },
                {
                    key: "myPosts",
                    label: "👤 내 레시피",
                    children: <PostList posts={myAndRetweets.filter(p => p.authorId === user.id)} user={user} likes={likes} followingsMap={followingsMap} handleToggleLike={handleToggleLike} handleToggleFollow={handleToggleFollow} dispatch={dispatch} title="내가 작성한 레시피" />
                },
                {
                    key: "myActivity",
                    label: "📌 내 활동",
                    children: <PostList posts={myAndRetweets} user={user} likes={likes} followingsMap={followingsMap} handleToggleLike={handleToggleLike} handleToggleFollow={handleToggleFollow} dispatch={dispatch} title="내 레시피 & 공유글" />
                }
            );

            // ✅ 관리자 탭 권한 체크 변경 (ROLE_ADMIN)
            if (isAdmin) {
                items.push({
                    key: "admin",
                    label: "⚙️ 유저 관리",
                    children: (
                        <div style={{ padding: '100px 0', textAlign: 'center' }}>
                            <Button 
                                type="primary" 
                                size="large" 
                                icon={<SettingOutlined />} 
                                onClick={() => router.push('/adminPage')}
                                style={{ height: '50px', borderRadius: '8px' }}
                            >
                                관리자 전용 유저 관리 페이지로 이동
                            </Button>
                        </div>
                    )
                });
            }
        }
        return items;
    }, [user, currentCategory, mainMaterials, loadMaterialsLoading, posts, hasNext, likedPosts, myAndRetweets, handleToggleLike, handleToggleFollow, handleEdit, likes, likesCount, retweets, retweetsCount, expandedPostId, followingsMap, followLoading, likeLoading, onCategoryChange, fetchMoreAll, router]);

    return (
        <div style={{ background: '#f5f5f5', minHeight: '100vh' }}>
            <Tabs 
                defaultActiveKey="all" 
                centered 
                items={tabItems} 
                style={{ padding: '0 20px' }}
                onChange={(key) => {
                    if (key === "liked" && user) dispatch(fetchLikedPostsRequest({ page: 1, size: 10 }));
                    if ((key === "myPosts" || key === "myActivity") && user) {
                        dispatch(fetchMyAndRetweetsRequest({ page: 1, size: 10 }));
                    }
                }}
            />

            <Modal title="새 식재료 등록" open={isMaterialModalVisible} onCancel={() => setIsMaterialModalVisible(false)} onOk={() => form.submit()}>
                <Form form={form} layout="vertical" onFinish={onSaveMaterial}>
                    <Form.Item name="title" label="재료명" rules={[{ required: true }]}><Input /></Form.Item>
                    <Form.Item name="category" label="카테고리" rules={[{ required: true }]}><Input /></Form.Item>
                    <Form.Item name="allergy" label="알레르기 정보"><Input /></Form.Item>
                    <Form.Item name="efficacy" label="효능"><Input.TextArea rows={3} /></Form.Item>
                    <Form.Item label="재료 이미지">
                        <Upload beforeUpload={(file) => { setMaterialFile(file); return false; }} maxCount={1}>
                            <Button icon={<UploadOutlined />}>이미지 선택</Button>
                        </Upload>
                    </Form.Item>
                </Form>
            </Modal>

            <EditPostModal
                visible={isEditModalVisible} editPost={editPost} loading={loading}
                onCancel={() => { setIsEditModalVisible(false); setEditPost(null); }} 
                onSubmit={handleEditSubmit} uploadFiles={uploadFiles} setUploadFiles={setUploadFiles}
            /> 
        </div>
    );
}