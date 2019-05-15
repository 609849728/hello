package com.sp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sp.mapper.BaseMapper;
import com.sp.service.BaseService;

import java.util.List;


public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	protected abstract BaseMapper<T> getBaseMapper();  //需要子类实例化
	

	@Override
	public List<T> getList(T t) {
		// TODO Auto-generated method stub
		return getBaseMapper().getList(t);
	}

	
	
	@Override
	public PageInfo getPageInfo(Integer pageNum,Integer pageSize, T t) {
		if(pageSize==null) {
			pageSize = 4;
		}
		
        if(pageNum==null || pageNum==0) {
            PageHelper.offsetPage(0,pageSize);
        } else {
            PageHelper.offsetPage((pageNum-1)*pageSize,pageSize);
        }

        List<T> list = getBaseMapper().getList(t);

        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
	}



	@Override
	public T selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return getBaseMapper().selectByPrimaryKey(id);
	}



	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return getBaseMapper().deleteByPrimaryKey(id);
	}



	@Override
	public int insertSelective(T t) {
		// TODO Auto-generated method stub
		return getBaseMapper().insertSelective(t);
	}



	@Override
	public int updateByPrimaryKeySelective(T t) {
		// TODO Auto-generated method stub
		return getBaseMapper().updateByPrimaryKeySelective(t);
	}



	@Override
	public int updateByPrimaryKey(T t) {
		// TODO Auto-generated method stub
		return getBaseMapper().updateByPrimaryKey(t);
	}


	@Override
	public int batchDelete(Integer[] ids) {
		return getBaseMapper().batchDelete(ids);
	}

}
