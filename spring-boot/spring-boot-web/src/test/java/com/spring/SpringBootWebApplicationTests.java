package com.spring;

import com.spring.bean.Student;
import com.spring.bean.User;
import com.spring.service.StudentService;
import com.spring.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(locations = { "classpath*:spring-database.xml", "classpath*:spring-sharding.xml" })
public class SpringBootWebApplicationTests {

	@Resource
	public UserService userService;

	@Resource
	public StudentService studentService;

	@Test
	public void testUserInsert() {
		User u = new User();
		u.setUserId(11);
		u.setAge(25);
		u.setName("github");
		Assert.assertEquals(userService.insert(u), true);
	}

	@Test
	public void testStudentInsert() {
		Student student = new Student();
		student.setStudentId(21);
		student.setAge(21);
		student.setName("hehe");
		Assert.assertEquals(studentService.insert(student), true);
	}

	@Test
	public void testFindAll(){
		List<User> users = userService.findAll();
		if(null != users && !users.isEmpty()){
			for(User u :users){
				System.out.println(u);
			}
		}
	}

	@Test
	public void testSQLIN(){
		List<User> users = userService.findByUserIds(Arrays.asList(1));
		if(null != users && !users.isEmpty()){
			for(User u :users){
				System.out.println(u);
			}
		}
	}

	@Test
	public void testTransactionTestSucess(){
		userService.transactionTestSucess();
	}

	@Test(expected = IllegalAccessException.class)
	public void testTransactionTestFailure() throws IllegalAccessException{
		userService.transactionTestFailure();
	}

	@Test
	public void contextLoads() {
	}

}
