package salesforce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//public class JdbcTest2 {
//	public static void main(String[]args) {
//		// 0. import java.sql.*;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//		  // 1. JDBC 드라이버 (Oracle) 로딩
//			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			  // 2. Connection 얻어오기
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(url, "webdb","1234");
//			  // 3. SQL문 준비 / 바인딩 / 실행
//			//sql 준비문
//			// int count = pstmt.executeQuery() -> insert, update, delete
//			String sql = "UPDATE AUTHOR A\n"
//					+ "SET a.author_Desc = ?\n"
//					+ "WHERE a.AUTHOR_ID = ?";
//			
//			//바인딩 
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1,"기안동에 사는 84년생"); // 첫 번쨰 물음표에다가 새로운 값 넣기(1번에다가 문자열을 넣어주세요)
//			pstmt.setInt(2, 4);
//			
//			//실행
//			int count = pstmt.executeUpdate();
//			
//		  // 4.결과처리
//			
//			System.out.print(count+"건이 반영되었습니다");
//
//			while(rs.next()) {
//				System.out.print(rs.getInt(1)+",");
//				System.out.print(rs.getString(2)+",");
//				System.out.print(rs.getString(3)+"\n");
//			}
//		} catch (ClassNotFoundException e) {
//		  System.out.println("error: 드라이버 로딩 실패 - " + e);
//		} catch (SQLException e) {
//		  System.out.println("error:" + e);
//		} finally {
//		 
//		  // 5. 자원정리
//		  try {
//		    if (rs != null) {
//		      rs.close();
//		    }
//		    if (pstmt != null) {
//		      pstmt.close();
//		    }
//		    if (conn != null) {
//		      conn.close();
//		    }
//		  } catch (SQLException e) {
//		    System.out.println("error:" + e);
//		  }
//		}
//		
//	}
//
//}



//public class JdbcTest2 {
//
//	public static void main(String[] args) {
//		// 0. import java.sql.*;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			// 1. JDBC 드라이버 (Oracle) 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//
//			// 2. Connection 얻어오기
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(url, "webdb", "1234");
//
//			// 3. SQL문 준비 / 바인딩 / 실행
//			// sql 문
//			String sql = " DELETE from author a\r\n"
//					+ "WHERE a.author_id = ? \r\n"
//					+ "AND a.author_name= ?";
//			// 바인딩
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1,2);
//			pstmt.setString(2,"이문열");
//			
//			// 실행
//			int count = pstmt.executeUpdate();
//
//			// 4.결과처리
//			System.out.print(count + "건이 수정 되었습니다.");
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("error: 드라이버 로딩 실패 - " + e);
//		} catch (SQLException e) {
//			System.out.println("error:" + e);
//		} finally {
//
//			// 5. 자원정리
//			try {
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				System.out.println("error:" + e);
//			}
//
//		}
//
//		
//	}
//
//}


//public class JdbcTest2 {
//
//    public static void main(String[] args) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//
//            String url = "jdbc:oracle:thin:@localhost:1521:xe";
//            conn = DriverManager.getConnection(url, "webdb", "1234");
//
//            String sql = "INSERT INTO author (author_id,author_name,author_desc ) VALUES (seq_author_id.nextval, ?, ?)";
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, "몰라용");
//            pstmt.setString(2, "작가됐네용");
//
//            int count = pstmt.executeUpdate();
//
//            System.out.print(count + "건의 데이터가 삽입되었습니다.");
//
//        } catch (ClassNotFoundException e) {
//            System.out.println("error: 드라이버 로딩 실패 - " + e);
//        } catch (SQLException e) {
//            System.out.println("error:" + e);
//        } finally {
//            try {
//                if (pstmt != null) {
//                    pstmt.close();
//                }
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                System.out.println("error:" + e);
//            }
//        }
//    }
//}

//public class JdbcTest2 {
//
//    public static void main(String[] args) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//		ResultSet rs = null;
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//
//            String url = "jdbc:oracle:thin:@localhost:1521:xe";
//            conn = DriverManager.getConnection(url, "webdb", "1234");
//
//            String sql = "SELECT b.BOOK_ID, \r\n"
//                    + "		b.TITLE, \r\n"
//                    + "		b.PUBS, \r\n"
//                    + "		b.PUB_DATE, \r\n"
//                    + "		b.AUTHOR_ID, \r\n"  
//                    + "		a.AUTHOR_NAME, \r\n"
//                    + "		a.AUTHOR_DESC \r\n" 
//                    + "FROM AUTHOR a, BOOK b \r\n"
//                    + "WHERE a.AUTHOR_ID = b.AUTHOR_ID";
//
//            pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			  // 4.결과처리
//			while (rs.next()) {
//				    System.out.print(rs.getInt(1) + ",");
//				    System.out.print(rs.getString(2) + ", ");
//				    System.out.print(rs.getString(3) + ",");
//				    System.out.print(rs.getString(4) + ",");
//				    System.out.print(rs.getString(5) + ",");
//				    System.out.print(rs.getString(6) + ",");
//				    System.out.print(rs.getString(7) + "\n");
//            }
//			} catch (ClassNotFoundException e) {
//			  System.out.println("error: 드라이버 로딩 실패 - " + e);
//			} catch (SQLException e) {
//			  System.out.println("error:" + e);
//			} finally {
//			 
//			  // 5. 자원정리 / 앞에 정의된 거랑 반대로 정의
//			  try {
//			    if (rs != null) { // update, insert, delete는 X
//			      rs.close();
//			    }
//			    if (pstmt != null) {
//			      pstmt.close();
//			    }
//			    if (conn != null) {
//			      conn.close();
//			    }
//			  } catch (SQLException e) {
//			    System.out.println("error:" + e);
//			  }
//			}
//			
//		}

//	}

public class JdbcTest2 {

  public static void main(String[] args) {
      Connection conn = null;
      PreparedStatement pstmt = null;

      try {
          Class.forName("oracle.jdbc.driver.OracleDriver");

          String url = "jdbc:oracle:thin:@localhost:1521:xe";
          conn = DriverManager.getConnection(url, "webdb", "1234");

          String sql = "INSERT INTO book (author_id,author_name,author_desc ) VALUES (seq_author_id.nextval, ?, ?)";
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1, "몰라용");
          pstmt.setString(2, "작가됐네용");

          int count = pstmt.executeUpdate();

          System.out.print(count + "건의 데이터가 삽입되었습니다.");

      } catch (ClassNotFoundException e) {
          System.out.println("error: 드라이버 로딩 실패 - " + e);
      } catch (SQLException e) {
          System.out.println("error:" + e);
      } finally {
          try {
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
