/** 
 * <pre>项目名称:easyui_project1 
 * 文件名称:ResultPage.java 
 * 包名:com.jk.lyh.util 
 * 创建日期:2018年10月26日下午2:24:04 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.util;

import java.util.List;

/** 
 * <pre>项目名称：easyui_project1    
 * 类名称：ResultPage    
 * 类描述：    
 * 创建人：李银豪  
 * 创建时间：2018年10月26日 下午2:24:04    
 * 修改人：李银豪 
 * 修改时间：2018年10月26日 下午2:24:04    
 * 修改备注：       
 * @version </pre>    
 */
public class ResultPage {

	private Integer total = 0;
	private List<?> rows;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "ResultPage [total=" + total + ", rows=" + rows + "]";
	}
	
	
}
