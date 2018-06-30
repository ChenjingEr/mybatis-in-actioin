package pro.jing.mybatis.dao;

import pro.jing.mybatis.bean.Book;

public interface BookDynamicMapper {

	Book getBookByCondition(Book book);
	
	Book getBookByCondition02(Book book);
	
}
