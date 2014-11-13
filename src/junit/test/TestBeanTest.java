package junit.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.kang.bean.test.TestAnswer;
import cn.kang.bean.test.TestBean;
import cn.kang.service.TestAnswerService;
import cn.kang.service.TestBeanService;

public class TestBeanTest {

	private static TestBeanService testBeanService;
	private static TestAnswerService testAnswerService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		testBeanService = (TestBeanService) act.getBean("testBeanServiceBean");
		testAnswerService = (TestAnswerService) act.getBean("testAnswerServiceBean");
	}
	 
	public void delete() {
		 
	}
	public void save() {
		 TestBean test = new TestBean();
		 test.setTitle("test1");
		 test.setContent("do you like black?");
		 TestAnswer answer1 = new TestAnswer();
		 answer1.setContent("A.yes");
		 TestAnswer answer2 = new TestAnswer();
		 answer2.setContent("A.no");
		 Set<TestAnswer> answers = new HashSet<TestAnswer>();
		 answers.add(answer1);
		 answers.add(answer2);
		 test.setAnswers(answers);
		 answer1.setTest(test);
		 answer2.setTest(test);

		 testBeanService.save(test);
		 testAnswerService.save(answer1);
		 testAnswerService.save(answer2);
	}
	

	public void getCount() {

	}

	public void getScroll() {

	}

	@Test
	public void find() {
		TestBean test = testBeanService.find(4);
		Set<TestAnswer> answers = test.getAnswers();
		Iterator<TestAnswer> ite = answers.iterator();
		while(ite.hasNext()){
			TestAnswer answer = ite.next();
			System.out.print("answer content"+answer.getContent());
			
		}
	}

	public void update() {
		;
	}
}
