//pages/oauth2/callback.js
import { useEffect } from "react";  // react - view 상태
import { useRouter } from "next/router"; // 이동
import { useDispatch } from "react-redux"; // store (치킨집) 상태
import { loginSuccess } from "../../reducers/authReducer"; // 액션

export default function oauth2callbackpage(){
    const router = useRouter();
    const dispatch = useDispatch();

    useEffect( ()=>{
        if(!router.isReady) return;
        //http://localhost:3000/oauth2/callback?accessToken=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ0aGVqb2E3MDMiLCJzdWIiOiIzIiwicHJvdmlkZXIiOiJrYWthbyIsImVtYWlsIjoiZHVkYWxzNTI5MnhuQG5hdmVyLmNvbSIsIm5pY2tuYW1lIjoi6rmA7JiB66-8Iiwicm9sZSI6IlJPTEVfVVNFUiIsImlhdCI6MTc2ODk1NzAyNSwiZXhwIjoxNzY4OTU3OTI1fQ.FJg7Bgz8fhkR8-RwK4FmxhyBFBH3Q4YIrKY9ZLiXxZQ
        const {accessToken}= router.query;
        if(accessToken){
        try{
            localStorage.setItem("accessToken", accessToken);
            fetchUser(accessToken); // 사용자 정보를 요청 
            }catch(err){
                console.error("Oauth2 callback error:",err);
                router.push("/login");
            }
        }
    } , [router.isReady , router.query]);

    const fetchUser = async()=>{
            try {
      const res = await fetch("http://localhost:8484/auth/me", { //boot 경로
        headers: { Authorization: `Bearer ${accessToken}` },
        credentials: "include",  //refreshToken 쿠키와 함께 전송 
      });
      if (res.ok) { //auth/me 통과가 됐다면
        const user = await res.json();
        dispatch(loginSuccess({ user, accessToken })); //login 성공
        router.push("/mypage"); 
      } else {
        router.push("/login");
      }
    } catch (err) {
      console.error("User fetch error:", err);
      router.push("/login");
    }

    };
    return <p>소셜 로그인 처리 중입니다...</p>;
}