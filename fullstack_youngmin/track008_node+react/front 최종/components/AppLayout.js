import { Layout, Menu, Input, Row, Col, Drawer, Button, Grid } from "antd";
import { MenuOutlined, SearchOutlined, BulbOutlined } from "@ant-design/icons";
import Link from "next/link";
import { useSelector, useDispatch } from "react-redux";
import axios from "../api/axios";
import { logout, loginSuccess } from "../reducers/authReducer";
import { useRouter } from "next/router";
import { useEffect, useState } from "react";
import SearchForm from "./SearchForm"; 
import RecommendModal from "./RecommendModal"; // 🚀 모달 컴포넌트 연결

const { Header, Content } = Layout;
const { useBreakpoint } = Grid;

function AppLayout({ children, initialUser }) {
    const { user } = useSelector((state) => state.auth);
    const dispatch = useDispatch();
    const router = useRouter();
    const screens = useBreakpoint();

    const [mounted, setMounted] = useState(false);
    const [drawerOpen, setDrawerOpen] = useState(false);
    const [searchValue, setSearchValue] = useState("");
    const [recommendModalOpened, setRecommendModalOpened] = useState(false);

    // 모달 제어 함수
    const onOpenRecommendModal = () => setRecommendModalOpened(true);
    const onCloseRecommendModal = () => setRecommendModalOpened(false);

    useEffect(() => {
        setMounted(true);
        if (initialUser && !user && initialUser.nickname) {
            dispatch(loginSuccess({ user: initialUser }));
        }
    }, [initialUser, user, dispatch]);

    useEffect(() => {
        if (!mounted) return;
        const hasToken = typeof window !== "undefined" && localStorage.getItem("accessToken");
        const protectedRouter = ["/mypage", "/followers", "/followings", "/adminPage"];

        if (!user && !initialUser && protectedRouter.includes(router.pathname)) {
            if (hasToken) {
                axios.get("/auth/me")
                    .then((res) => {
                        if (res.data && res.data.nickname) {
                            dispatch(loginSuccess({ user: res.data }));
                        }
                    })
                    .catch(() => {
                        dispatch(logout());
                        router.replace("/login");
                    });
            } else {
                router.replace("/login");
            }
        }
    }, [user, initialUser, router, mounted, dispatch]);

    const handleLogout = async () => {
        try {
            await axios.post("/auth/logout");
        } catch (err) {
            console.error("로그아웃 API 실패:", err);
        } finally {
            if (typeof window !== "undefined") {
                localStorage.removeItem("accessToken");
                localStorage.removeItem("user");
            }
            dispatch(logout());
            router.replace("/login");
        }
    };

    const onSearch = (value) => {
        if (value) {
            router.push(`/hashtags?tag=${encodeURIComponent(value)}`);
            setSearchValue("");
        }
    };

    const menuItems = [
        ...(user && user.nickname
            ? [
                { key: "new", label: <Link href="/posts/new">✏️ NEW POST</Link> },
                { key: "profile", label: <Link href="/mypage">👤 MYPAGE </Link> },
                {
                    key: "logout",
                    label: <span onClick={handleLogout} style={{ cursor: "pointer" }}>🔓 LOGOUT</span>,
                },
            ]
            : [
                { key: "login", label: <Link href="/login">🔒 Login</Link> },
                { key: "signup", label: <Link href="/signup">👤 Signup</Link> },
            ]
        ),
    ];

    return (
        <Layout>
            <Header style={{ padding: "0 24px", height: 64, display: "flex", alignItems: "center" }}>
                <Row align="middle" justify="space-between" style={{ width: "100%" }}>
                    <Col flex="none">
                        <Link href="/" passHref legacyBehavior>
                            <a style={{ color: "#fff", fontWeight: "bold", fontSize: "18px", marginLeft: "12px", textDecoration: "none" }}>
                                THEJOA703
                            </a>
                        </Link>
                    </Col>
                    <Col flex="auto" xs={0} sm={0} md={16} lg={18}>
                        <Menu theme="dark" mode="horizontal" items={menuItems} overflowedIndicator={null} />
                    </Col>
                    <Col flex="none" xs={2} md={0}>
                        <Button type="text" icon={<MenuOutlined style={{ color: "white", fontSize: 20 }} />} onClick={() => setDrawerOpen(true)} />
                    </Col>
                </Row>
            </Header>

            
            {/* 🚀 해시태그 검색창 */}
            {screens.md && (
                <div style={{ display: "flex", justifyContent: "center", alignItems: "center", padding: "16px", background: "#fafafa" }}>
                    <Input
                        prefix={<SearchOutlined style={{ color: "#999" }} />}
                        placeholder="해시태그 검색"
                        value={searchValue}
                        onChange={(e) => setSearchValue(e.target.value)}
                        onPressEnter={(e) => onSearch(e.target.value)}
                        style={{ maxWidth: 600, width: "100%", borderRadius: "20px", background: "#fff", padding: "6px 12px" }}
                    />
                </div>
            )}

            {/* 🚀 나에게 딱 맞는 맛집 추천 버튼 (해시태그 검색창 바로 밑) */}
            <div style={{ textAlign: "center", padding: "20px 0", background: "#fff", borderBottom: "1px solid #eaeaea" }}>
                <Button 
                    type="primary" 
                    shape="round" 
                    icon={<BulbOutlined />} 
                    size="large"
                    onClick={onOpenRecommendModal}
                    style={{ 
                        background: "#7d74cf", 
                        borderColor: "#25243d", 
                        height: "50px", 
                        padding: "0 40px", 
                        fontSize: "18px", 
                        fontWeight: "bold" 
                    }}
                >
                    나에게 딱 맞는 맛집 추천받기 🍳
                </Button>
            </div>

            {/* 추천 모달 컴포넌트 */}
            {mounted && (
                <RecommendModal 
                    open={recommendModalOpened} 
                    onClose={onCloseRecommendModal} 
                />
            )}

            <Drawer title="MENU" placement="right" onClose={() => setDrawerOpen(false)} open={drawerOpen}>
                <Input.Search
                    placeholder="해시태그 검색"
                    enterButton="검색"
                    value={searchValue}
                    onChange={(e) => setSearchValue(e.target.value)}
                    onSearch={(value) => { setDrawerOpen(false); onSearch(value); }}
                    style={{ marginBottom: 16 }}
                />
                <Menu mode="vertical" items={menuItems} onClick={() => setDrawerOpen(false)} />
            </Drawer>

            <Content style={{ padding: "40px" }}>{children}</Content>
        </Layout>
    );
}

export default AppLayout;