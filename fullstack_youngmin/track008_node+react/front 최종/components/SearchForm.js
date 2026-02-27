import React, { useCallback, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { SEARCH_REQUEST } from '../reducers/search';

const SearchForm = () => {
    const dispatch = useDispatch();
    const { searchHistory } = useSelector((state) => state.search);
    const [category, setCategory] = useState('');
    const [location, setLocation] = useState('');

    const onSubmit = useCallback((e) => {
        e.preventDefault();
        dispatch({
            type: SEARCH_REQUEST,
            data: { category, location, hashtag: '' },
        });
    }, [category, location]);

    return (
        <div>
            <form onSubmit={onSubmit}>
                <input value={location} onChange={(e) => setLocation(e.target.value)} placeholder="지역" />
                <button type="submit">검색</button>
            </form>
            {/* 히스토리 칩들 렌더링... */}
        </div>
    );  
    
};

export default SearchForm; 