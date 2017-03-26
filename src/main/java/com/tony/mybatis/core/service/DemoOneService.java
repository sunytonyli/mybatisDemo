package com.tony.mybatis.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tony.mybatis.core.dao.DemoOneDao;
import com.tony.mybatis.core.entity.Master;

@Service
public class DemoOneService implements IDemoOneServiceInf{

	@Autowired
	private DemoOneDao demoOneDao;
	
	@Override
	public List<Master> getMasters() {
		return demoOneDao.getMasters();
	}

}
