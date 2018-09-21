package com.imooc.zhou.service;

import java.util.List;

import com.imooc.zhou.entity.XcxShop;

public interface XcxShopService {
	
	//查找所有记录
	public List<XcxShop> findAll();
	
	//查找单个记录
  	public XcxShop findOneById(Integer id);
	
	//根据id删除一条记录
  	public boolean deleteById(Integer id);
  	
  	//新增一条数据
  	public boolean add(XcxShop xcxShop);
  	
  	//修改一条数据
  	public boolean modify(XcxShop xcxShop);
}
