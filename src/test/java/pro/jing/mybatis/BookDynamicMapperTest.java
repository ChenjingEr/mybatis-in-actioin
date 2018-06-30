package pro.jing.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import pro.jing.mybatis.bean.Book;
import pro.jing.mybatis.dao.BookDynamicMapper;


public class BookDynamicMapperTest {

	private SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void setUp() {

		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testQueryWithCondition() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			BookDynamicMapper dynamicMapper = sqlSession.getMapper(BookDynamicMapper.class);
			Book book = dynamicMapper.getBookByCondition(new Book(null, "山", "泽文", null, null, null));
			System.out.println(book);
		} finally {
			sqlSession.close();
		}
	}
	@Test
	public void testQueryWithCondition02() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			BookDynamicMapper dynamicMapper = sqlSession.getMapper(BookDynamicMapper.class);
			Book book = dynamicMapper.getBookByCondition02(new Book(null, "山", "泽文", null, null, null));
			System.out.println(book);
		} finally {
			sqlSession.close();
		}
	}
}
