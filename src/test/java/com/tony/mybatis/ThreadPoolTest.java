package com.tony.mybatis;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tony.mybatis.core.service.IDemoOneServiceInf;

/*@WebAppConfiguration*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:*/spring/appServlet/servlet-context.xml" })
public class ThreadPoolTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private IDemoOneServiceInf demoOneService;
	
	@Test
	public void testJavaThreadPool(){
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
	            1, 3, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(3));
		try {
	        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
	        int numJobs = 50;
	        for (int i = 1; i <= numJobs; i++) {
	            try {
	                executor.submit(new WorkerThread(i));
	                System.out.println("Added#" + (i));
	            } catch (RejectedExecutionException e) {
	                e.printStackTrace();
	            }
	        }
	    } finally {
	        executor.shutdown();
	    }
	}
	
	@Test
	public void testSpringThreadPool(){
		
		String msg = demoOneService.threadPoolDemo();
        
        System.err.println(msg);
	}
	
}

class WorkerThread implements Runnable {
    int jobId;

    public WorkerThread(int jobId) {
        this.jobId = jobId;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        }
        catch (Exception excep) {
        }
    }
}