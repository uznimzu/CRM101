package salesforce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BookDaoImpl implements BookDao{
	
	private Connection getConnection() {
		Connection conn = null;
	
	
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return conn;
	}
	public List<BookVo> search(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookVo> list = new ArrayList<BookVo>();
		
		try {
			System.out.println("글자를 입력해주세요.");
			Scanner sc = new Scanner(System.in);
			String findbook = sc.nextLine();
			conn = getConnection();
			
			String sql = "SELECT B.BOOK_ID , B.TITLE , B.PUBS, to_char(b.pub_date,'yyyy-mm-dd')PUB_DATE, A.AUTHOR_NAME "
			        + "FROM BOOK B "
			        + "FULL OUTER JOIN AUTHOR A ON A.AUTHOR_ID = B.AUTHOR_ID "
			        + "WHERE TITLE LIKE ? OR PUBS LIKE ? OR AUTHOR_NAME LIKE ?";


			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + findbook + "%");
			pstmt.setString(2, "%" + findbook + "%");
			pstmt.setString(3, "%" + findbook + "%");

			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int book_id = rs.getInt(1);
				String title = rs.getString(2);
				String pubs = rs.getString(3);
				String pub_date= rs.getString(4);
				String author_name = rs.getString(5);
				
//			    System.out.println("Book ID: " + book_id);
//			    System.out.println("Title: " + title);
//			    System.out.println("Pubs: " + pubs);
//			    System.out.println("Pub Date: " + pub_date);
//			    System.out.println("Author Name: " + author_name);
				
				BookVo vo = new BookVo(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5));
				list.add(vo);
			} 
			
			
			sc.close();
		}
		catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
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
		return list;
	}


	@Override
	public int insert(BookVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<BookVo> getList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int delete(Long authorId) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int update(BookVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
	






	

	

	
