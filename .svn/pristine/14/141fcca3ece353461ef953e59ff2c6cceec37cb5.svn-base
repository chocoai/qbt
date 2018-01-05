/**
 * Project Name:qbt-persistent
 * File Name:SolrService.java
 * Package Name:com.qbt.solr
 * Date:2017年3月9日下午3:46:45
 *
*/

package com.qbt.solr;

import java.util.Collection;
import java.util.List;

import org.apache.solr.common.SolrInputDocument;

import com.qbt.common.entity.search.GroupRes;
import com.qbt.common.entity.search.SearchPage;
import com.qbt.common.entity.search.Sort;
import com.qbt.common.enums.CollectionType;

/**
 * ClassName:SolrService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月9日 下午3:46:45
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface SolrService {
	
	/**
     * 添加索引,多个bean对象,这个bean对象字段需要通过注释field对应schema.xml里面的字段
	 * @param <T>
     */
    public <T> int addBeans(Collection<T> solrDataList, CollectionType type);

    /**
     * 添加索引,一个bean对象,这个bean对象字段需要通过注释field对应schema.xml里面的字段
     */
    public int addBean(Object solrData, CollectionType type);

    /**
     * 添加索引,多个SolrInputDocument对象，其中SolrInputDocument是solrj自带的，外面其实应该传入map才需要调用此方法
     */
    public int addDocuments(Collection<SolrInputDocument> solrDatas, CollectionType type);

    /**
     * 添加索引,单个SolrInputDocument对象，其中SolrInputDocument是solrj自带的，外面其实应该传入map才需要调用此方法
     */
    public abstract int addDocument(SolrInputDocument solrData, CollectionType type);

    /**
     * 优化索引
     */
    public int optimizeCollection(CollectionType type);

    /**
     * 通过Id删除索引
     */
    public int deleteIndexById(String id, CollectionType type);

    /**
     * 通过查询条件删除索引
     */
    public int deleteIndexByQuery(String queryStr, CollectionType type);

    /**
     * 通过Ids删除索引
     */
    public int deleteIndexByIds(List<String> ids, CollectionType type);
    
    /**
     * 分页查询数据
     * @param <T>
     * 
     * @param queryStr:
     *            查询字符串
     * @param filterQueryStr:
     *            过虑查询，作用：在q查询符合结果中同时是fq查询符合的
     * @param page
     * @param clazz
     * 
     */
    public <T> SearchPage<T> selectByPage(String queryStr, String filterQueryStr, SearchPage<T> page, Class<T> clazz, CollectionType type);

    /**
     * 分页分组查询数据 (目前仅支持一个group分页查询)
     * 
     * @param queryStr:
     *            查询字符串
     * @param filterQueryStr:
     *            过虑查询，作用：在q查询符合结果中同时是fq查询符合的
     * @param page
     * 
     * @param clazz
     * 
     * @return page 返回的结果item会是 list，里面放入map，map的key为group的分组值，value是分组出来的记录
     * 
     */
    public <T> SearchPage<List<GroupRes<T>>> selectGroupArrayByPage(String queryStr, String filterQueryStr, SearchPage<List<GroupRes<T>>> page, Class<T> clazz, CollectionType type);
    
    /**
     * 
     * selectById:(根据id查询).
     *
     * @author huangyihao
     * 2017年3月31日 上午10:59:56
     * @param id
     * @param clazz
     * @param type
     * @return
     *
     */
    public <T> T selectById(String id, Class<T> clazz, CollectionType type);
}
