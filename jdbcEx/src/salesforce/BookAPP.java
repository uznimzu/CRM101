package salesforce;
import java.util.ArrayList;
import java.util.List;

public class BookAPP {
	public static void main(String[]args) {
		

		BookDao dao = new BookDaoImpl();
		List<BookVo> list = new ArrayList<BookVo>();
		List<BookVo> list2 = new ArrayList<BookVo>();
				
		list2 = dao.search();
		if(list2.isEmpty()) {
			System.out.println("찾으시는 책이 존재하지 않습니다.");
		}
		else {
			System.out.println("찾으시는 책이 존재합니다.");
				for(BookVo vo4: list2) {
					System.out.println(vo4);
				}
		}
		
		
	}

}

