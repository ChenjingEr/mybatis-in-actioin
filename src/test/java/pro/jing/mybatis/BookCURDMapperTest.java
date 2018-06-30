package pro.jing.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pro.jing.mybatis.bean.Book;
import pro.jing.mybatis.bean.PublishingCompany;
import pro.jing.mybatis.dao.BookCURDMapper;
import pro.jing.mybatis.dao.PublishingCompanyMappper;

/**
 * @author JING
 * @Date 2018年6月29日
 * @description mybatis 测试
 */
public class BookCURDMapperTest {

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

	// @Test
	// public void testMybatis() throws IOException {
	//
	// SqlSession sqlSession = sqlSessionFactory.openSession();
	// try {
	// Book book =
	// sqlSession.selectOne("pro.jing.mybatis.dao.BookMapper.queryBookById", 1);
	// System.out.println(book);
	// } finally {
	// sqlSession.close();
	// }
	// }
	
	@Test
	public void testSave() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			BookCURDMapper curd = sqlSession.getMapper(BookCURDMapper.class);
			PublishingCompany pc = new PublishingCompany();
			pc.setId(1);
			Book book = new Book(null, "观山海", "杉泽", 126.0, new Date(), pc);
			int row = curd.saveBook(book);
			System.out.println(row);
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSaveBatch() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			BookCURDMapper curd = sqlSession.getMapper(BookCURDMapper.class);
			PublishingCompany pc = new PublishingCompany();
			pc.setId(1);
//			Book book = new Book(null, "时间的玫瑰", "但斌", 56.0, new Date(), pc);
//			Book book = new Book(null, "巴菲特致股东的信", "沃伦", 56.0, new Date(), pc);
			List<Book> books = new ArrayList<>();
			books.add(new Book(null, "时间的玫瑰", "但斌", 56.0, new Date(), pc));
			books.add(new Book(null, "巴菲特致股东的信", "沃伦", 56.0, new Date(), pc));
			int row = curd.saveBookBatch(books);
			System.out.println(row);
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testQuery() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			BookCURDMapper curd = sqlSession.getMapper(BookCURDMapper.class);
			Book book = curd.getBookById(3);
			System.out.println(book);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testQueryBatch() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			BookCURDMapper curd = sqlSession.getMapper(BookCURDMapper.class);
			List<Book> books = curd.getBookList();
			System.out.println(books);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdate() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			BookCURDMapper curd = sqlSession.getMapper(BookCURDMapper.class);
			Book book = curd.getBookById(3);
			book.setAuthor("（美）加·泽文");
			curd.updateBook(book);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testDelete() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			BookCURDMapper curd = sqlSession.getMapper(BookCURDMapper.class);
			curd.deleteBook(3);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testQueryMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			BookCURDMapper curd = sqlSession.getMapper(BookCURDMapper.class);
			Map<Integer, Book> bookMap = curd.getBookMap();
			System.out.println(bookMap);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testQueryCascade() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			BookCURDMapper curd = sqlSession.getMapper(BookCURDMapper.class);
			Book book = curd.getBookCompanyCascade(5);
			System.out.println(book);
			System.out.println();
		}finally {
			sqlSession.close();
		}
	}
	@Test
	public void testQueryCascade02() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			BookCURDMapper curd = sqlSession.getMapper(BookCURDMapper.class);
			Book book = curd.getBookCompanyCascade02(5);
			System.out.println(book);
			System.out.println(book.getPublishingCompany());
		}finally {
			sqlSession.close();
		}
	}
	@Test
	public void testQueryCascade03() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			BookCURDMapper curd = sqlSession.getMapper(BookCURDMapper.class);
			Book book = curd.getBookCompanyCascade03(5);
			System.out.println(book);
			System.out.println(book.getPublishingCompany());
		}finally {
			sqlSession.close();
		}
	}
	

}
