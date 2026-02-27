import React from "react";
import { Button, message } from "antd";
import { UserAddOutlined, UserDeleteOutlined } from "@ant-design/icons";

export default function FollowButton({
  authorId,
  user,
  isFollowing,
  onToggleFollow,
  loading,
}) {
  // 클릭 이벤트 핸들러 정의
  const handleClick = () => {
    if (!authorId) {
      message.error("팔로우 대상 ID가 없습니다.");
      return;
    }
    // 내 아이디와 글 작성자 아이디 비교 (로그인 안 한 경우 예외처리 추가)
    if (user && authorId === user.id) {
      return; // 자기 자신은 버튼이 동작하지 않게 함 (또는 PostCard에서 숨김 처리)
    }
    
    if (typeof onToggleFollow === "function") {
      onToggleFollow(authorId);
    }
  };

  // 로그인하지 않은 경우 버튼을 숨기거나 비활성화
  if (!user) return null;
  // 내 글인 경우 팔로우 버튼을 보여주지 않음
  if (authorId === user.id) return null;

  return (
    <Button
      type={isFollowing ? "default" : "primary"}
      danger={isFollowing}
      icon={isFollowing ? <UserDeleteOutlined /> : <UserAddOutlined />}
      loading={loading}
      onClick={handleClick} // 이제 정의된 handleClick을 사용함
      style={{ borderRadius: "6px" }}
    >
      {isFollowing ? "언팔로우" : "팔로우"}
    </Button>
  );
}