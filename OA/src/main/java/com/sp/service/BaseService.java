package com.sp.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

public interface BaseService<T> {
	
	//查询全部信息，支持模糊查询
	List<T> getList(T t);
	
	//分页查询，传入当前页和页面大小，支持模糊查询
	PageInfo getPageInfo(Integer pageNum, Integer pageSize, T t);
	
	//根据id查询信息
	T selectByPrimaryKey(Integer id);
	
	//根据id删除记录
	int deleteByPrimaryKey(Integer id);
	
	//添加操作，如果传入的值为空就不插入那个字段
	int insertSelective(T t);
	
	//根据id更新信息，如果传的值为空的就不更新那个字段
	int updateByPrimaryKeySelective(T t);
	
	//根据id更新信息，并且不管传入的值是否为空，所有字段都进行更新
	int updateByPrimaryKey(T t);

	//批量删除
	int batchDelete(Integer[] ids);
	
}
