package com.thejoa703.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.thejoa703.dto.PostDto;

public class PostDao {

    // 공통 DB 정보
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "scott";
    private static final String PASS = "tiger";

    // 공통 커넥션
    private Connection getConnection() throws Exception {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
    }

    /* 1. 글쓰기 */
    public int insert(PostDto dto) {
        int result = 0; // 0 = 실패, 1 = 성공
        String sql = "INSERT INTO post (id, app_user_id, title, content, pass) "
                   + "VALUES (post_seq.nextval, ?, ?, ?, ?)";

        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        
            pstmt.setInt(1, dto.getAppUserId());
            pstmt.setString(2, dto.getTitle());
            pstmt.setString(3, dto.getContent());
            pstmt.setString(4, dto.getPass());

            int rows = pstmt.executeUpdate();
            if (rows > 0) result = 1;
        } catch (Exception e) {
            e.printStackTrace();
		} finally {
			if( rset  != null ) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( pstmt != null ) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( conn  != null ) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}  
        return result;
    }

    /* 2. 전체보기 */
    public ArrayList<PostDto> selectAll() {
        ArrayList<PostDto> result = new ArrayList<>();
        String sql = "SELECT p.*, u.email email "
                   + "FROM post p JOIN appuser u ON p.app_user_id = u.app_user_id";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rset = pstmt.executeQuery();
        ) {
            while (rset.next()) {
                PostDto dto = new PostDto(
                    rset.getInt("id"),
                    rset.getInt("app_user_id"),
                    rset.getString("title"),
                    rset.getString("content"),
                    rset.getString("pass"),
                    rset.getTimestamp("created_at").toLocalDateTime(),
                    rset.getInt("hit"),
                    rset.getString("email")
                );
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /* 3. 상세보기 (한 건) */
    public PostDto select(int id) {
        PostDto result = null;   // 없으면 null
        String sql = "SELECT * FROM post WHERE id = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    result = new PostDto(
                        rset.getInt("id"),
                        rset.getInt("app_user_id"),
                        rset.getString("title"),
                        rset.getString("content"),
                        rset.getString("pass"),
                        rset.getTimestamp("created_at").toLocalDateTime(),
                        rset.getInt("hit")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /* 조회수 +1 */
    public int update_hit(int id) {
        int result = 0;
        String sql = "UPDATE post SET hit = hit + 1 WHERE id = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) result = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /* 4. 글수정 (비번 맞아야 수정) */
    public int update(PostDto dto) {
        int result = 0;
        String sql = "UPDATE post SET title = ?, content = ? WHERE id = ? AND pass = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getContent());
            pstmt.setInt(3, dto.getId());
            pstmt.setString(4, dto.getPass());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                result = 1;  // 수정 성공
            } else {
                result = 0;  // 조건(id+pass) 안 맞음
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /* 5. 글삭제 (비번 맞아야 삭제) */
    public int delete(PostDto dto) {
        int result = 0; // 1:삭제성공, 0:조건불일치/글없음
        String sql = "DELETE FROM post WHERE id = ? AND pass = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, dto.getId());
            pstmt.setString(2, dto.getPass());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                result = 1;
            } else {
                result = 0; // id 없거나 pass 틀림
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
} // end class
