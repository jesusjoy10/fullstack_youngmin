
package com.thejoa703.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thejoa703.dto.PostDto;

public class PostDao {	 
	  
    // CREATE - 추천 등록
    public int insert(PostDto dto) { 
    	int result = -1;
        String sql = " INSERT INTO RECOMMEND_TB (RECID, ID, FOODID, TYPE, FEEDBACK) "
        		+ " VALUES (RECOMMEND_TB_seq.nextval, ?, ?, ?, ?) ";
        Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
        String driver="oracle.jdbc.driver.OracleDriver";
		String    url="jdbc:oracle:thin:@localhost:1521:xe";
		String   user="scott" , pass="tiger";
		
//				이름        널?       유형            
//				--------- -------- ------------- 
//				RECID     NOT NULL NUMBER(8)     
//				ID        NOT NULL VARCHAR2(30)  
//				FOODID             NUMBER(6)     
//				TYPE      NOT NULL VARCHAR2(30)  
//				FEEDBACK           VARCHAR2(200) 
//				CREATEDAT          DATE           

		// 드커프리
		try {
			//1. 드라이버 연동
			Class.forName(driver);
			//2. 커넥션
			conn = DriverManager.getConnection(url,user,pass);
			//3. PSTMT
			pstmt = conn.prepareStatement(sql);
			pstmt.setString( 1, dto.getId()  );
			pstmt.setInt(2, dto.getFoodId()  );
			pstmt.setString(3, dto.getType () );
			pstmt.setString(4, dto.getFeedback () );
			//4. Result 
			if (pstmt.executeUpdate()>0) {result = 1;}  //성공
			
		} catch(Exception e) {e.printStackTrace();			
		}finally {
			if( rset  != null ) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( pstmt != null ) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( conn  != null ) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}  
		return result;
    }		
    
    // READ - 전체 추천 조회
    public ArrayList<PostDto>selectAll(){
    	ArrayList<PostDto>result = new ArrayList<>();
    	String sql = "SELECT * FROM Recommend_tb order BY createdAt desc"; 
    	// 드 커 프 리
    			Connection conn = null; PreparedStatement pstmt = null;  ResultSet rset = null;
    			String driver="oracle.jdbc.driver.OracleDriver";
    			String    url="jdbc:oracle:thin:@localhost:1521:xe";
    			String   user="scott" , pass="tiger";
    			// 드 커 프 리 
    			try {
    				//1. 드라이버연동 
    				Class.forName(driver);
    				//2. 커넥션
    				conn = DriverManager.getConnection(url, user, pass);
    				//3. PSTMT
    				pstmt = conn.prepareStatement(sql);
    				//4. RESULT (  select : executeQuery  / insert,update, delete: executeUpdate)
    				rset = pstmt.executeQuery();  //표
    				//recId, id, foodId, type, feedback
    				//public PostDto(int recId, String userId, int foodId, String type, String feedback, Date createdAt) {
    				while(rset.next()) {
    					result.add(new PostDto(
    							rset.getInt("RECID"), rset.getString("ID"),rset.getInt("FOODID")
    							,rset.getString("TYPE"), rset.getString("FEEDBACK")  , rset.getTimestamp("CREATEDAT").toLocalDateTime()  ));
    				}
    			} catch (Exception e) { e.printStackTrace();
    			} finally {
    				if( rset  != null ) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
    				if( pstmt != null ) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
    				if( conn  != null ) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
    			}  
    			
    	      return result;
    	   }
    												    
    

    // READ - 사용자별 추천 조회    
    public List<PostDto> selectByUser(String userId) {
        List<PostDto> result = new ArrayList<>();
        String sql = "SELECT * FROM Recommend_tb where id = ?";
     // 드 커 프 리
		Connection conn = null; PreparedStatement pstmt = null;  ResultSet rset = null;
		String driver="oracle.jdbc.driver.OracleDriver";
		String    url="jdbc:oracle:thin:@localhost:1521:xe";
		String   user="scott" , pass="tiger";
		// 드 커 프 리 
		try {
			//1. 드라이버연동 
			Class.forName(driver);
			//2. 커넥션
			conn = DriverManager.getConnection(url, user, pass);
			//3. PSTMT
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			//4. RESULT (  select : executeQuery  / insert,update, delete: executeUpdate)
			rset = pstmt.executeQuery();  //표
			//recId, id, foodId, type, feedback
			while(rset.next()) {
				result.add(new PostDto(
						rset.getInt("RECID"), rset.getString("ID"),rset.getInt("FOODID")
						,rset.getString("TYPE"), rset.getString("FEEDBACK")  , rset.getTimestamp("CREATEDAT").toLocalDateTime()  ));
			}
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if( rset  != null ) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( pstmt != null ) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( conn  != null ) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}  
		
      return result;
   }
    
    

    // DELETE - 추천 삭제
    public int delete(PostDto dto) {
    	int result= -1;
        String sql = "delete from Recommend_tb where  recId = ? and Id= ?";
        Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
        String driver="oracle.jdbc.driver.OracleDriver";
		String    url="jdbc:oracle:thin:@localhost:1521:xe";
		String   user="scott" , pass="tiger";
		// 드커프리
		try {
			//1. 드라이버 연동
			Class.forName(driver);
			//2. 커넥션
			conn = DriverManager.getConnection(url,user,pass);
			//3. PSTMT
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt( 1, dto.getRecId()  );
			pstmt.setString( 2, dto.getId()  );
			
			//4. Result 
			if (pstmt.executeUpdate()>0) {result = 1;}  //성공
			
		} catch(Exception e) {e.printStackTrace();			
		}finally {
			if( rset  != null ) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( pstmt != null ) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if( conn  != null ) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}  
		return result;
    }

	public PostDto select(int id) {
		// TODO Auto-generated method stub
		return null;
	}		
}   //end class





/* INSERT INTO Recommend_tb (recId, id, foodId, type, feedback)  
VALUES (RECOMMEND_TB_seq.nextval, 'user01', 100001, 'AI', '단백질부족' );

SELECT * FROM Recommend_tb order BY createdAt desc;

SELECT * FROM Recommend_tb where id = 'user01'  order BY createdAt desc;

DELETE FROM Recommend_tb where recId = 1;*/
