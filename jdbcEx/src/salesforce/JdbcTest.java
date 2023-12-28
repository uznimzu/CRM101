package salesforce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcTest {
	public static void main(String[]args) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		  // 1. JDBC 드라이버 (Oracle) 로딩
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			  // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr","hr");
			  // 3. SQL문 준비 / 바인딩 / 실행
			//sql 준비문
			// int count = pstmt.executeQuery() -> insert, update, delete(데이터에 변형이 가해지는 경우)
			String sql = "SELECT * \r\n" // 공백을 안 두면 sql 문을 해석할 수 없게 됨. 
					+ "FROM EMPLOYEES e ";
			
		// "SELECT author_id, author_name, author_desc From employee order by 1";
			
			//바인딩 
			pstmt = conn.prepareStatement(sql);
			//실행
			rs = pstmt.executeQuery();
			
		  // 4.결과처리
			while(rs.next()) {
				System.out.print(rs.getInt(1)+",");
				System.out.print(rs.getString(2)+",");
				System.out.print(rs.getInt(3)+"\n");
			}
		} catch (ClassNotFoundException e) {
		  System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		  System.out.println("error:" + e);
		} finally {
		 
		  // 5. 자원정리 / 앞에 정의된 거랑 반대로 정의
		  try {
		    if (rs != null) { // update, insert, delete는 X
		      rs.close();
		    }
		    if (pstmt != null) {
		      pstmt.close();
		    }
		    if (conn != null) {
		      conn.close();
		    }
		  } catch (SQLException e) {
		    System.out.println("error:" + e);
		  }
		}
		
	}

}
