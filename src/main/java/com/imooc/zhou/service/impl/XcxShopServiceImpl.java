package com.imooc.zhou.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.imooc.zhou.dao.XcxShopMapper;
import com.imooc.zhou.entity.XcxShop;
import com.imooc.zhou.service.XcxShopService;

@Service
public class XcxShopServiceImpl implements XcxShopService {
	
	@Resource
	private XcxShopMapper xcxShopMapper;

	@Override
	public List<XcxShop> findAll() {
		// TODO Auto-generated method stub
		return xcxShopMapper.findAll();
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return xcxShopMapper.deleteById(id);
	}

	@Override
	public boolean add(XcxShop xcxShop) {
		// TODO Auto-generated method stub
		return xcxShopMapper.add(xcxShop);
	}

	@Override
	public XcxShop findOneById(Integer id) {
		// TODO Auto-generated method stub
		return xcxShopMapper.findOneById(id);
	}

	@Override
	public boolean modify(XcxShop xcxShop) {
		// TODO Auto-generated method stub
		return xcxShopMapper.modify(xcxShop);
	}

}
