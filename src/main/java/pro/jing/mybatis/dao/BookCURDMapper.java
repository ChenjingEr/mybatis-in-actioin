package pro.jing.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import pro.jing.mybatis.bean.Book;

/**
 * @author JING
 * @Date 2018年6月30日
 * @description 简单增删改查
 */
public interface BookCURDMapper {

		
	int saveBook(Book book);

	int saveBookBatch(List<Book> books);

	int deleteBook(Integer id);

	int updateBook(Book book);
	
	Book getBookById(Integer id);
	
	List<Book> getBookList();
	
	@MapKey("id")
	Map<Integer, Book> getBookMap();
	
	Book getBookCompanyCascade(Integer id);
	
	Book getBookCompanyCascade02(Integer id);
	
	Book getBookCompanyCascade03(Integer id);
}
