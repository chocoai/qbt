package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.baseNewsCatagory.BaseNewsCatagoryVo;
import com.qbt.web.pojo.baseNewsCatagory.NewsCatagoryPageVo;

public interface BaseNewsCategorySupport {
	
	/**
	 * 
	 * <b>方法名：</b>：add<br>
	 * <b>功能说明：</b>：添加新闻分类<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午2:59:36
	 * @param catagoryVo
	 * @return
	 * @throws BusinessException
	 */
	int doSave(BaseNewsCatagoryVo catagoryVo) throws BusinessException;
	
	/***
	 * 
	 * <b>方法名：</b>：doFindCategoryDetail<br>
	 * <b>功能说明：</b>：查询新闻分类详情<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午4:41:19
	 * @param id
	 * @return
	 */
	BaseNewsCatagoryVo doFindCategoryDetail(Integer id);
	
	/**
	 * 
	 * <b>方法名：</b>：update<br>
	 * <b>功能说明：</b>：修改新闻分类<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午3:00:26
	 * @param catagoryVo
	 * @return
	 * @throws BusinessException
	 */
	boolean doUpdate(BaseNewsCatagoryVo catagoryVo) throws BusinessException;
	
	/**
	 * 
	 * <b>方法名：</b>：doFindNewsCatagortList<br>
	 * <b>功能说明：</b>：查询新闻分类列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午3:02:32
	 * @return
	 */
	List<BaseNewsCatagoryVo> doFindNewsCatagortList();
	
	/**
	 * 
	 * <b>方法名：</b>：doFindNewsCatagoryPage<br>
	 * <b>功能说明：</b>：分页查询新闻分类信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午3:02:47
	 * @param catagoryVo
	 * @return
	 */
	List<BaseNewsCatagoryVo> doFindNewsCatagoryPage(NewsCatagoryPageVo pageVo);
	
	/**
	 * 
	 * <b>方法名：</b>：doDelete<br>
	 * <b>功能说明：</b>：删除新闻分类信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午3:04:33
	 * @param id
	 * @return
	 */
	boolean doDelete(int id);

}
