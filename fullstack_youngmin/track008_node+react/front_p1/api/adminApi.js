import axios from 'axios';

// 백엔드 포트가 8080이라면 아래와 같이 설정합니다.
const api = axios.create({
    baseURL: 'http://localhost:8484/admin/users',
    headers: {
        'Content-Type': 'application/json'
    }
});

// 모든 유저 조회
export const fetchAllUsers = () => api.get('');

// 유저 상태 토글 (정지/활성)
export const toggleUserStatus = (userId) => api.patch(`/${userId}/status`);

// 유저 강제 탈퇴
export const forceDeleteUser = (userId) => api.delete(`/${userId}`);