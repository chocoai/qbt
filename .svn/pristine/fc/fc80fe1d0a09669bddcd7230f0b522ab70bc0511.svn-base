package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseNewsCategory;

public interface BaseNewsCategoryMapper {
	
    int insert(BaseNewsCategory record);

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
    
    /***
     * 
     * <b>方法名：</b>：findByName<br>
     * <b>功能说明：</b>：根据分类名称查询分类信息<br>
     * @author <font color='blue'>张祥</font> 
     * @date  2017年3月24日 下午3:16:54
     * @param record
     * @return
     */
    List<BaseNewsCategory> findByName(BaseNewsCategory record);
    
    /**
     * 
     * <b>方法名：</b>：findByName<br>
     * <b>功能说明：</b>：根据分类名称查询分类信息 去除自身<br>
     * @author <font color='blue'>张祥</font> 
     * @date  2017年3月27日 上午10:05:28
     * @param record
     * @return
     */
    List<BaseNewsCategory> findByNameExceptSelf(BaseNewsCategory record);
    
    /**
     * 
     * <b>方法名：</b>：updateById<br>
     * <b>功能说明：</b>：根据Id修改新闻分类<br>
     * @author <font color='blue'>张祥</font> 
     * @date  2017年3月24日 下午2:30:10
     * @param record
     * @return
     */
    int updateById(BaseNewsCategory record);
    
    /****
     * 
     * <b>方法名：</b>：deleteById<br>
     * <b>功能说明：</b>：根据Id删除新闻分类<br>
     * @author <font color='blue'>张祥</font> 
     * @date  2017年3月24日 下午2:31:03
     * @param id
     * @return
     */
    int deleteById(Integer id);
    
    

}