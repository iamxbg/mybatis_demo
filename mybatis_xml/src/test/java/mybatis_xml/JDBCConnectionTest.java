package mybatis_xml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import mybatis_xml.dao.UserMapper;
import mybatis_xml.entity.User;
import mybatis_xml.entity.UserExample;

@RunWith(JUnit4.class)
public class JDBCConnectionTest {

	
	private static SqlSessionFactory ssf;

	
	@BeforeClass
	public static void initSqlSessionFactory() throws FileNotFoundException, IOException {
		ssf=new SqlSessionFactoryBuilder().build(new FileReader(Resources.getResourceAsFile("mybatis-config.xml")));
	}
	
	@Test
	public void getDatabaseIdProvider() {
		 //
	}
	
	@Test
	public void testConnection() throws IOException {
		Assert.assertNotNull(ssf.openSession());
		
	}
	
	@Test
	public void testGetUser() {
		ssf.openSession().select("selectByExample",new UserExample(), new ResultHandler<User>() {

			@Override
			public void handleResult(ResultContext<? extends User> resultContext) {
				// TODO Auto-generated method stub
				User user=resultContext.getResultObject();
				System.out.println(user.getName());
			}
		});
		
	}
	
	@Test
	public void testGetUser2() {
		List<User> uList=ssf.openSession().getMapper(UserMapper.class).selectByExample(new UserExample());
		System.out.println(uList.get(0).getAge());
	}
	
}
