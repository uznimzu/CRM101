package salesforce;

import java.util.List;

public interface BookDao {
	public int insert(BookVo vo);
	public List<BookVo> getList();
	public int delete(Long authorId);
	public int update(BookVo vo);
	public List<BookVo> search();

}
