package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseNewsCategory;

/**
 * 
 * <b>类名：</b>BaseNewsCatagoryService.java<br>
 * <p><b>标题：</b>球包通</p>
 * <p><b>描述：</b>新闻类型处理</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @date  2017年3月24日 下午2:32:08
 */
public interface BaseNewsCategoryService {
	
	/***
	 * 
	 * <b>方法名：</b>：insert<br>
	 * <b>功能说明：</b>：添加新闻份分类<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午2:32:50
	 * @param record
	 * @return
	 */
	int insert(BaseNewsCategory record);

	/***
	 * 
	 * <b>方法名：</b>：selectById<br>
	 * <b>功能说明：</b>：根据ID 查询单个新闻分类信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午2:33:07
	 * @param id
	 * @return
	 */
    BaseNewsCategory selectById(Integer id);
    
    /***
     * 
     * <b>方法名：</b>：findByPage<br>
     * <b>功能说明：</b>：分页查询新闻分类<br>
     * @author <font color='blue'>张祥</font> 
     * @date  2017年3月24日 下午2:38:50
     * @param pageEntity
     * @return
     */
    List<BaseNewsCategory> findByPage(PageEntity<BaseNewsCategory> pageEntity);
    
    /**
     * 
     * <b>方法名：</b>：findList<br>
     * <b>功能说明：</b>：查询所有新闻分类列表<br>
     * @author <font color='blue'>张祥</font> 
     * @date  2017年3月24日 下午2:39:17
     * @return
     */
    List<BaseNewsCategory> findList();
    
    /**
     * 
     * <b>方法名：</b>：findByName<br>
     * <b>功能说明：</b>：根据分类名称查询新闻分类<br>
     * @author <font color='blue'>张祥</font> 
     * @date  2017年3月24日 下午3:18:12
     * @param record
     * @return
     */
    List<BaseNewsCategory> findByName(BaseNewsCategory record);
    
    /***
     * 
     * <b>方法名：</b>：findByNameExceptSelf<br>
     * <b>功能说明：</b>：根据分类名称查询新闻分类，去除自身<br>
     * @author <font color='blue'>张祥</font> 
     * @date  2017年3月27日 上午10:06:49
     * @param id
     * @return
     */
    List<BaseNewsCategory> findByNameExceptSelf(BaseNewsCategory record);
    
    /***
     * 
     * <b>方法名：</b>：updateById<br>
     * <b>功能说明：</b>：根据Id修改新闻分类<br>
     * @author <font color='blue'>张祥</font> 
     * @date  2017年3月24日 下午2:33:42
     * @param record
     * @return
     */
    int updateById(BaseNewsCategory record);
    
    /***
     * 
     * <b>方法名：</b>：deleteById<br>
     * <b>功能说明：</b>：根据Id删除新闻分类<br>
     * @author <font color='blue'>张祥</font> 
     * @date  2017年3月24日 下午2:33:53
     * @param id
     * @return
     */
    int deleteById(Integer id);

}
