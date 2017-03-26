package com.tony.mybatis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tony.mybatis.core.entity.Master;
import com.tony.mybatis.core.service.IDemoOneServiceInf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:*/spring/appServlet/servlet-context.xml" })
public class DemoOneServiceTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private IDemoOneServiceInf demoOneService;
	
	@Test
	public void testDemoOne(){
		List<Master> masterList = demoOneService.getMasters();
		System.out.println(masterList);
	}
	
}
