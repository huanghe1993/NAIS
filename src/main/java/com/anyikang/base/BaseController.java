/**
 * 
 */
package com.anyikang.base;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author wangwei
 * @date 2017年6月15日
 */
public class BaseController {
	
	protected static final int pageSize=5;
	
	public <T> PageInfo page(List<T> listObj){
    	Page<T> list=(Page<T>) listObj;
    	return new PageInfo(list);
	}

}
