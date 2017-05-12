package com.tony.mybatis.core.service;

import java.util.List;

import com.tony.mybatis.core.entity.Master;

public interface IDemoOneServiceInf {

	public List<Master> getMasters();
	
	public void insertMaster(Master master);
	
	public String threadPoolDemo();
}
