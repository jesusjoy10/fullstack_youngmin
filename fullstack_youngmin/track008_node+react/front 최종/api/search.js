import axios from 'axios';

// 아까 인터셉터 설정한 파일이 따로 있다면 그 인스턴스를 import 하세요.
// 만약 같은 파일에 다 있다면, 기존에 쓰시던 API 인스턴스를 사용하면 됩니다.
const API = axios.create({
    baseURL: 'http://localhost:8484', 
    withCredentials: true,
});

// 인터셉터 설정 (토큰 주입)
API.interceptors.request.use((config) => {
    const token = localStorage.getItem('accessToken');
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
});

// Saga에서 불러다 쓸 함수들 (이름이 정확히 일치해야 합니다)
export const searchRestaurantsAPI = (data) => {
    return API.post('/api/search/restaurants', data);
};

export const loadHistoryAPI = () => {
    return API.get('/api/search/history/me');
};

export const clearHistoryAPI = () => {
    return API.delete('/api/search/history');
};