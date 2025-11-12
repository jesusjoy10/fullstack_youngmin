
package com.thejoa703.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thejoa703.dto.SerchDto;

public class SerchDao {	 

    // CREATE - 추천 등록
    public int insert(SerchDto dto) { 
    	int result = -1;
    	String sql = "INSERT INTO RECOMMEND_TB (tableId, ID, FOODID, TYPE, CATEGORY, KIND, METHOD, FEEDBACK, CREATEDAT) " +
                "VALUES (RECOMMEND_TB_seq.nextval, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";

        Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
        String driver="oracle.jdbc.driver.OracleDriver";
		String    url="jdbc:oracle:thin:@localhost:1521:xe";
		String   user="scott" , pass="tiger";
		
//				이름        널?       유형            
//				--------- -------- ------------- 
//				tableId     NOT NULL NUMBER(8)     
//				ID        NOT NULL NUMBER(30)  
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
			pstmt.setInt(1, dto.getId());               // 사용자 ID
			pstmt.setInt(2, dto.getFoodId());           // 음식 ID
			pstmt.setString(3, dto.getType());          // 추천 유형
			pstmt.setString(4, dto.getCategory());      // 음식 대분류
			pstmt.setString(5, dto.getKind());          // 음식 종류
			pstmt.setString(6, dto.getMethod());        // 조리 방식
			pstmt.setString(7, dto.getFeedback());      // 피드백

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
    public ArrayList<SerchDto>selectAll(){
    	ArrayList<SerchDto>result = new ArrayList<>();
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
    				//tableId, id, foodId, type, feedback
    				 
    				while (rset.next()) { 
    				    result.add(new SerchDto(
    				        rset.getInt("tableId"),
    				        rset.getInt("ID"),              // 🔹 int → String으로 수정
    				        rset.getInt("FOODID"),
    				        rset.getString("TYPE"),
    				        rset.getString("category"),
    				        rset.getString("kind"),
    				        rset.getString("method"),
    				        rset.getString("FEEDBACK"),
    				        rset.getDate("CREATEDAT")          // 🔹 toLocalDateTime() 제거, DTO가 java.sql.Date 사용 중이므로
    				    ));
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
    public SerchDto selectByTableId(int tableId) {
        SerchDto result = null;

        String sql = "SELECT * FROM RECOMMEND_TB WHERE tableId = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "scott", pass = "tiger";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, tableId);
            rset = pstmt.executeQuery();

            while (rset.next()) { 
			    result=new SerchDto(
			        rset.getInt("tableId"),
			        rset.getInt("ID"),              // 🔹 int → String으로 수정
			        rset.getInt("FOODID"),
			        rset.getString("TYPE"),
			        rset.getString("category"),
			        rset.getString("kind"),
			        rset.getString("method"),
			        rset.getString("FEEDBACK"),
			        rset.getDate("CREATEDAT")          // 🔹 toLocalDateTime() 제거, DTO가 java.sql.Date 사용 중이므로
			    );
			}
		} catch (Exception e) { e.printStackTrace();
		 } finally{
		 	if(rset != null) {try { rset.close(); } catch (Exception e) { e.printStackTrace(); }}
		 	if(pstmt != null) {try { pstmt.close(); } catch (Exception e) { e.printStackTrace(); }}
		 	if(conn != null) {try { conn.close(); } catch (Exception e) { e.printStackTrace(); }}
		 }
		        	return result;

   }
    
 // UPDATE - 추천 수정
    public int update(SerchDto dto) {
        int result = -1;
        String sql = "UPDATE RECOMMEND_TB SET FOODID=?, TYPE=?, CATEGORY=?, KIND=?, METHOD=?, FEEDBACK=? WHERE tableId=?";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "scott", pass = "tiger";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, dto.getFoodId());
            pstmt.setString(2, dto.getType());
            pstmt.setString(3, dto.getCategory());
            pstmt.setString(4, dto.getKind());
            pstmt.setString(5, dto.getMethod());
            pstmt.setString(6, dto.getFeedback());
            pstmt.setInt(7, dto.getTableId()); // WHERE 조건

            if (pstmt.executeUpdate() > 0) {
                result = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return result;
    }

    

    // DELETE - 추천 삭제
    public int delete(SerchDto dto) {
    	int result= -1;
    	String sql = "DELETE FROM Recommend_tb WHERE tableId = ?";
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
			  pstmt.setInt(1, dto.getTableId()); 
			
			
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
		
		
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// CREATE - 음식 등록
		public int insertFood(SerchDto dto) {
		    int result = -1;
		    String sql = "INSERT INTO FOODTB (foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl) " +
		                 "VALUES (FOODSEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";

		    Connection conn = null; PreparedStatement pstmt = null;
		    String driver = "oracle.jdbc.driver.OracleDriver";
		    String url = "jdbc:oracle:thin:@localhost:1521:xe";
		    String user = "scott", pass = "tiger";

		    try {
		        Class.forName(driver);
		        conn = DriverManager.getConnection(url, user, pass);
		        pstmt = conn.prepareStatement(sql);

		        pstmt.setString(1, dto.getName());
		        pstmt.setInt(2, dto.getCategoryId());
		        pstmt.setInt(3, dto.getKcal());
		        pstmt.setDouble(4, dto.getProtein());
		        pstmt.setDouble(5, dto.getCarb());
		        pstmt.setDouble(6, dto.getFat());
		        pstmt.setString(7, dto.getRecipe());
		        pstmt.setString(8, dto.getImageUrl());

		        if (pstmt.executeUpdate() > 0) result = 1;

		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		    }

		    return result;		
		
 }
  
		// READ - 가장 최근 등록된 음식 ID 조회
		public int getLatestFoodId() {
		    int result = -1;
		    String sql = "SELECT MAX(foodId) FROM FOODTB";

		    Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		    String driver = "oracle.jdbc.driver.OracleDriver";
		    String url = "jdbc:oracle:thin:@localhost:1521:xe";
		    String user = "scott", pass = "tiger";

		    try {
		        Class.forName(driver);
		        conn = DriverManager.getConnection(url, user, pass);
		        pstmt = conn.prepareStatement(sql);
		        rset = pstmt.executeQuery();

		        if (rset.next()) {
		            result = rset.getInt(1);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try { if (rset != null) rset.close(); } catch (SQLException e) { e.printStackTrace(); }
		        try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		    }

		    return result;
		}
		
		
		// READ - 음식 ID로 상세 조회
		public SerchDto selectFoodById(int foodId) {
		    SerchDto dto = null;
		    String sql = "SELECT * FROM FOODTB WHERE foodId = ?";

		    Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		    String driver = "oracle.jdbc.driver.OracleDriver";
		    String url = "jdbc:oracle:thin:@localhost:1521:xe";
		    String user = "scott", pass = "tiger";

		    try {
		        Class.forName(driver);
		        conn = DriverManager.getConnection(url, user, pass);
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setInt(1, foodId);
		        rset = pstmt.executeQuery();

		        if (rset.next()) {
		            dto = new SerchDto();
		            dto.setFoodId(rset.getInt("foodId"));
		            dto.setName(rset.getString("name"));
		            dto.setCategoryId(rset.getInt("categoryId"));
		            dto.setKcal(rset.getInt("kcal"));
		            dto.setProtein(rset.getDouble("protein"));
		            dto.setCarb(rset.getDouble("carb"));
		            dto.setFat(rset.getDouble("fat"));
		            dto.setRecipe(rset.getString("recipe"));
		            dto.setImageUrl(rset.getString("imageUrl"));
		            dto.setRegDate(rset.getDate("regDate"));
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try { if (rset != null) rset.close(); } catch (SQLException e) { e.printStackTrace(); }
		        try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		    }

		    return dto;
		}

		
		
		
}   //end class





/* INSERT INTO Recommend_tb (tableId, id, foodId, type, feedback)  
VALUES (RECOMMEND_TB_seq.nextval, 'user01', 100001, 'AI', '단백질부족' );

SELECT * FROM Recommend_tb order BY createdAt desc;

SELECT * FROM Recommend_tb where id = 'user01'  order BY createdAt desc;

DELETE FROM Recommend_tb where tableId = 1;*/
