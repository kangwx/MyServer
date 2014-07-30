package junit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.kang.bean.Cuisine;
import cn.kang.service.CuisineService;

public class CuisineTest {

	private static CuisineService cuisineService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		cuisineService = (CuisineService) act.getBean("cuisineServiceBean");
	}
	 
	public void delete() {
		for(int i=1;i<20;i++)
			cuisineService.delete(i);
	}
	@Test
	public void save() {
		Cuisine cuisine = new Cuisine();
		for (int i = 1; i < 20; i++) {
			cuisine.setId(i);
			cuisine.setAuthor("kangwx"+i);
			cuisine.setCategoryId(1);
			cuisine.setZhaiyao("this is zhaiyao"+i);
			cuisine.setImgUrl("images/ad/jundao1.gif");
			cuisineService.save(cuisine);
		}
	}
	

	public void getCount() {

	}

	public void getScroll() {

	}

	public void find() {

	}

	public void update() {
		;
	}
}
