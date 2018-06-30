package pro.jing.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import pro.jing.mybatis.bean.PublishingCompany;
import pro.jing.mybatis.dao.PublishingCompanyMappper;

public class PublishingCompanyMapperTest {

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
	public void testQueryWithBooks() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			PublishingCompanyMappper pcm = sqlSession.getMapper(PublishingCompanyMappper.class);
			PublishingCompany pc = pcm.getCompanyByIdWithBookList(1);
			System.out.println(pc);
			System.out.println(pc.getBooks());
		} finally {
			sqlSession.close();
		}
	}
}
