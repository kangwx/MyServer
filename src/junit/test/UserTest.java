package junit.test;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.kang.bean.Gender;
import cn.kang.bean.QueryResult;
import cn.kang.bean.User;
import cn.kang.service.UserService;


public class UserTest {

	private static UserService userService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		userService = (UserService) act.getBean("userServiceBean");
	}
	

	@Test
	public void save(){
		User user1 = new User();
		user1.setUsername("kangwx192");
		user1.setEmail("kangwx2@163.com");
		user1.setPassword("12345");
		user1.setRealname("康伟雄");
		user1.setVisible(true);
		user1.setGender(Gender.MAN);
		user1.setRegTime(new Date(50,6,8)); 
		
		userService.save(user1);
		//System.out.println(new Date(System.currentTimeMillis()));
	}


	public void delete(){
 
		userService.delete("kangwx2");
	}
	
	public void getCount(){
		long count = userService.getCount();
		System.out.println("user count is:"+count);
	}
 
	public void getScroll(){
		QueryResult<User> qr = userService.getScrollData(3,5);
		System.out.println("user count is:"+qr.getTotalrecord());
		List<User> list = qr.getResultlist();
		for(int i=0;i<list.size();i++){
			User user = list.get(i);
			System.out.println("user "+i+" name "+user.getUsername());
			
		}
		
		LinkedHashMap<String,String> orderby = new LinkedHashMap<String,String>();
		orderby.put("username", "desc");
		qr = userService.getScrollData(0,9,"o.password=?1",new Object[]{"789"},orderby);
		System.out.println("======================="+qr.getTotalrecord());
		list = qr.getResultlist();
		for(int i=0;i<list.size();i++){
			User user = list.get(i);
			System.out.println("user "+i+" name "+user.getUsername()+" pass "+user.getPassword());
			
		}
	}
	 
	public void find(){

		User user1 = new User();
		user1.setUsername("kangwx3"); 
		
		User user2 = userService.find(user1.getUsername());
		System.out.println("user2 password:"+user2.getPassword());
	}

	public void update(){

		User user1 = new User();
		user1.setUsername("kangwx2");
		user1.setEmail("kangwx2@163.com");
		user1.setPassword("456");
		userService.update(user1);

		System.out.println("update" );
	}
}
