export default function UsersPage(){
    // 코드 




    // 렌더링
    return (
        <div className="container mt-4">
            <h1 class="mb-3">사용자 목록</h1>

            {/*  로딩/에러 상태 표시  */}
            <div class="alert alert-info">로딩 중...</div>
            <div class="alert alert-danger">에러 메시지</div>

             {/*  사용자 목록 테이블 */}
            <table class="table table-striped table-bordered table-hover">
            <thead>
                <tr> <th>이메일</th>  <th>닉네임</th> <th>액션</th>  </tr>
            </thead>
            <tbody>
                <tr>
                <td>user1@example.com</td>
                <td>닉네임1</td>
                <td>
                    <button class="btn btn-primary btn-sm me-2">닉네임 수정</button>
                    <button class="btn btn-danger btn-sm">삭제</button>
                </td>
                </tr>
                <tr>
                <td>user2@example.com</td>
                <td>
                     {/*  닉네임 수정 모드일 때 */}
                    <input class="form-control" placeholder="새 닉네임" />
                </td>
                <td>
                    <button class="btn btn-success btn-sm me-2">수정 완료</button>
                    <button class="btn btn-danger btn-sm">삭제</button>
                </td>
                </tr>
            </tbody>
            </table>

             {/*  로그아웃 버튼 */}
            <div class="mt-3">
            <button class="btn btn-secondary">로그아웃</button>
            </div>
        </div>
    );
}
// 1. `useSelector`  → Redux store에서 사용자 상태 가져오기
// 2. `useEffect`    → 로그인 여부 확인 및 사용자 목록 불러오기
// 3. `dispatch`     → 액션발생 (로그인, 사용자 삭제,,,)