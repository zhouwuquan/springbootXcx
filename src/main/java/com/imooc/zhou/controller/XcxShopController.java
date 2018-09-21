package com.imooc.zhou.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.zhou.entity.XcxShop;
import com.imooc.zhou.service.XcxShopService;

@RestController
public class XcxShopController {
	
	@Autowired
	private XcxShopService xcxShopService;
	
	/**
	 * 查询All
	 * @return
	 */
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public List<XcxShop> findAll() {
		return  xcxShopService.findAll();
	}
	
	/**
	 * 单个查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/findOneById",method=RequestMethod.GET)
	public XcxShop findOneById(@RequestParam("id") Integer id) {
		return xcxShopService.findOneById(id);
	}
	
	/**
	 * 删除    by  id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public Map<String,Object> deleteById(@RequestParam("id") Integer id) {
		boolean flag = xcxShopService.deleteById(id);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("success", flag);
		return map;
	}
	
	/**
	 * 新增
	 * @param params
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> add(@RequestBody Map<String,Object> params) {
		XcxShop xs = new XcxShop();
		xs.setName((String) params.get("name"));
		xs.setLocation((String)params.get("location"));
		boolean flag = xcxShopService.add(xs);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("success", flag);
		return map;
	}
	
	/**
	 * 修改
	 * @param params
	 * @return
	 */
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public Map<String,Object> modify(@RequestBody Map<String,Object> params) {
		XcxShop xs = new XcxShop();
		xs.setId(Long.parseLong((String)params.get("id")));
		xs.setName((String) params.get("name"));
		xs.setLocation((String)params.get("location"));
		boolean flag = xcxShopService.modify(xs);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("success", flag);
		return map;
	}
	
}
