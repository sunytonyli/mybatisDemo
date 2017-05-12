package com.tony.mybatis.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tony.mybatis.core.dao.DemoOneDao;
import com.tony.mybatis.core.entity.Master;
import com.tony.mybatis.core.util.CallableWorker;

@Service
public class DemoOneService implements IDemoOneServiceInf{

	@Autowired
	private DemoOneDao demoOneDao;
	
	@Autowired
	private ThreadPoolTaskExecutor threadPool;
	
	@Override
	public List<Master> getMasters() {
		return demoOneDao.getMasters();
	}

	public String threadPoolDemo(){
		String msg = "";
        List<Future<String>> futureList = new ArrayList<Future<String>>();
        for(int threadNumber = 0; threadNumber < 5; threadNumber ++){
            CallableWorker callableTask = new CallableWorker(String.valueOf(threadNumber));
            Future<String> result = threadPool.submit(callableTask);
            futureList.add(result);
        }
          
        for(Future<String> future: futureList){
            try {
                msg += future.get() + "#####";
            } catch (Exception e){}
        }
        return msg;
	}
	
	
	@Override
	@Transactional
	public void insertMaster(Master master) {
		
		List<String> list = new ArrayList<String>();
		for(int i=0;i<100;i++){
			list.add("test--"+i);
		}
		
		List<Future<Boolean>> futureList = new ArrayList<Future<Boolean>>();
		
		int size = list.size();
		int sunSum = 10;
		int listStart,listEnd;
		if(sunSum > size){
			sunSum = size;
		}
		
		demoOneDao.insertMaster(master);
	}
	
}
