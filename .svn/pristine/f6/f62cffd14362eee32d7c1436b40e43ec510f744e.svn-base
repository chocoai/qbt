/**
 * Project Name:qbt-persistent
 * File Name:SolrServiceImpl.java
 * Package Name:com.qbt.solr.impl
 * Date:2017年3月9日下午3:59:45
 *
*/

package com.qbt.solr.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.FacetParams;
import org.apache.solr.common.params.GroupParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.qbt.common.entity.search.Facet;
import com.qbt.common.entity.search.Group;
import com.qbt.common.entity.search.GroupRes;
import com.qbt.common.entity.search.SearchPage;
import com.qbt.common.entity.search.Sort;
import com.qbt.common.enums.CollectionType;
import com.qbt.common.enums.SortType;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.solr.SolrService;

/**
 * ClassName:SolrServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月9日 下午3:59:45
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class SolrServiceImpl implements SolrService {
	
//	@Value("{solr_url}")
	private String solr_url = "http://localhost:8983/solr/";
	
	private static final int ERROR_STATUS = -1;
	
	private SolrClient initSolrClient(){
		return new HttpSolrClient(solr_url);
	}
	
	private void closeSolrClient(SolrClient solrClient){
		if(solrClient != null){
			try {
				solrClient.close();
			} catch (IOException e) {
				LogCvt.error("关闭solrclient失败", e);
			}
		}
	}
	
	@Override
	public <T> int addBeans(Collection<T> solrDataList, CollectionType type) {
		if(Checker.isEmpty(solrDataList)){
			throw new BusinessException("索引数据为空！建立索引失败！");
		}
		LogCvt.info("添加索引，solrDataList为 ：" + JSonUtil.toJSonString(solrDataList));
		SolrClient solrClient = null;
		try {
			solrClient = initSolrClient();
			solrClient.addBeans(type.getType(), solrDataList);
			UpdateResponse rs = solrClient.commit();
			return rs.getStatus();
		} catch (Exception e) {
			LogCvt.error("添加索引失败，数据为 ：" + JSonUtil.toJSonString(solrDataList), e);
		} finally {
			closeSolrClient(solrClient);
		}
		return ERROR_STATUS;
	}
	
	
	@Override
	public int addBean(Object solrData, CollectionType type) {
		if(Checker.isEmpty(solrData)){
			throw new BusinessException("索引数据为空！建立索引失败！");
		}
		LogCvt.info("添加索引，solrData为 ：" + JSonUtil.toJSonString(solrData));
		SolrClient solrClient = null;
		try {
			solrClient = initSolrClient();
			solrClient.addBean(type.getType(), solrData);
			UpdateResponse rs = solrClient.commit();
			return rs.getStatus();
		} catch (Exception e) {
			LogCvt.error("添加索引失败，数据为 ：" + JSonUtil.toJSonString(solrData), e);
		} finally {
			closeSolrClient(solrClient);
		}
		return ERROR_STATUS;
	}

	@Override
	public int addDocuments(Collection<SolrInputDocument> solrDatas, CollectionType type) {
		if(Checker.isEmpty(solrDatas)){
			throw new BusinessException("索引数据为空！建立索引失败！");
		}
		LogCvt.info("添加索引，solrDatas为 ：" + JSonUtil.toJSonString(solrDatas));
		SolrClient solrClient = null;
		try {
			solrClient = initSolrClient();
			solrClient.add(type.getType(), solrDatas);
			UpdateResponse rs = solrClient.commit();
			return rs.getStatus();
		} catch (Exception e) {
			LogCvt.error("添加索引失败，数据为 ：" + JSonUtil.toJSonString(solrDatas), e);
		} finally {
			closeSolrClient(solrClient);
		}
		return ERROR_STATUS;
	}

	@Override
	public int addDocument(SolrInputDocument solrData, CollectionType type) {
		if(Checker.isEmpty(solrData)){
			throw new BusinessException("索引数据为空！建立索引失败！");
		}
		LogCvt.info("添加索引，solrData为 ：" + JSonUtil.toJSonString(solrData));
		SolrClient solrClient = null;
		try {
			solrClient = initSolrClient();
			solrClient.add(type.getType(), solrData);
			UpdateResponse rs = solrClient.commit();
			return rs.getStatus();
		} catch (Exception e) {
			LogCvt.error("添加索引失败，数据为 ：" + JSonUtil.toJSonString(solrData), e);
		} finally {
			closeSolrClient(solrClient);
		}
		return ERROR_STATUS;
	}

	@Override
	public int optimizeCollection(CollectionType type) {
		LogCvt.info("优化索引，优化类型为为 ：" + type);
		SolrClient solrClient = null;
		try {
			solrClient = initSolrClient();
			solrClient.optimize(type.getType());
			UpdateResponse rs = solrClient.commit();
			return rs.getStatus();
		} catch (Exception e) {
			LogCvt.error("优化索引失败，collectionName为 ：" + type.getType(), e);
		} finally {
			closeSolrClient(solrClient);
		}
		return ERROR_STATUS;
	}

	@Override
	public int deleteIndexById(String id, CollectionType type) {
		if(Checker.isEmpty(id)){
			throw new BusinessException("id为空！删除索引失败！");
		}
		SolrClient solrClient = null;
		try {
			solrClient = initSolrClient();
			solrClient.deleteById(type.getType(), id);
			UpdateResponse rs = solrClient.commit();
			return rs.getStatus();
		} catch (Exception e) {
			LogCvt.error("通过Id删除索引失败，id为 ：" + id, e);
		} finally {
			closeSolrClient(solrClient);
		}
		return ERROR_STATUS;
	}

	@Override
	public int deleteIndexByQuery(String queryStr, CollectionType type) {
		if(Checker.isEmpty(queryStr)){
			throw new BusinessException("查询信息为空！删除索引失败！");
		}
		SolrClient solrClient = null;
		try {
			solrClient = initSolrClient();
			solrClient.deleteByQuery(type.getType(), queryStr);
			UpdateResponse rs = solrClient.commit();
			return rs.getStatus();
		} catch (Exception e) {
			LogCvt.error("通过查询删除索引失败，query为 ：" + queryStr, e);
		} finally {
			closeSolrClient(solrClient);
		}
		return ERROR_STATUS;
	}

	@Override
	public int deleteIndexByIds(List<String> ids, CollectionType type) {
		if(Checker.isEmpty(ids)){
			throw new BusinessException("ids为空！删除索引失败！");
		}
		SolrClient solrClient = null;
		try {
			solrClient = initSolrClient();
			solrClient.deleteById(type.getType(), ids);
			UpdateResponse rs = solrClient.commit();
			return rs.getStatus();
		} catch (Exception e) {
			LogCvt.error("通过Ids删除索引失败，ids为 ：" + ids, e);
		} finally {
			closeSolrClient(solrClient);
		}
		return ERROR_STATUS;
	}

	@Override
	public <T> SearchPage<T> selectByPage(String queryStr, String filterQueryStr, SearchPage<T> page, Class<T> clazz,
			CollectionType type) {
		if (Checker.isEmpty(queryStr) && Checker.isEmpty(filterQueryStr)) {
            return page;
        }
		SolrClient solrClient = null;
		try {
			solrClient = initSolrClient();
			SolrQuery query = new SolrQuery();
			query.setQuery(queryStr);
			query.addFilterQuery(filterQueryStr);
			query.setIncludeScore(page.isIncludeScore());
			if(Checker.isNotEmpty(page.getSortList())){
				List<SortClause> sortList = convertSortToSortClause(page.getSortList());
                for (SortClause sortClause : sortList) {
                    query.addSort(sortClause);
                }
			}
			int start = (page.getPageNumber() - 1) * page.getPageSize();
            query.setStart(start);
            query.setRows(page.getPageSize());
            QueryResponse response = solrClient.query(type.getType(), query);
            if (response != null) {
            	SolrDocumentList docList = response.getResults();
            	List<T> mlist = BeanUtil.list2list(docList, clazz);
            	page.setDataRes(mlist);
            	if (page.getTotalCount() == 0) {
                    page.setTotalCount(Integer.valueOf(String.valueOf(docList.getNumFound())));
                }
            	// 计算pagecount
            	if (page.getTotalCount() > 0 && page.getPageCount() == 1) {
            		int pageCount = page.getTotalCount() % page.getPageSize() == 0 ? page.getTotalCount() / page.getPageSize()
                            : (page.getTotalCount() / page.getPageSize()) + 1;
                    page.setPageCount(pageCount);
            	}
            	page.setHasNext(page.getPageNumber() < page.getPageCount()); // 设置是否有下一页
            	StringBuffer buffer = new StringBuffer("solr selectByPage: ");
            	buffer.append(queryStr)
            		.append(",sort=[")
            		.append(page.getSortList() != null ? JSonUtil.toJSonString(page.getSortList()) : "")
            		.append("]")
            		.append(",Records=")
            		.append(page.getTotalCount())
            		.append(",Time=")
            		.append(response.getQTime())
            		.append("ms");
            	LogCvt.info(buffer.toString());
            }
		} catch (Exception e) {
			LogCvt.error("分页查询数据失败，queryStr为 ：" + queryStr + "    ***filterQueryStr：" + filterQueryStr + "    ***page：" + JSonUtil.toJSonString(page)
            + "   ***clazz" + clazz, e);
		} finally {
			closeSolrClient(solrClient);
		}
		return page;
	}

	@Override
	public <T> SearchPage<List<GroupRes<T>>> selectGroupArrayByPage(String queryStr, String filterQueryStr, SearchPage<List<GroupRes<T>>> page, Class<T> clazz,
			CollectionType type) {
		if (Checker.isEmpty(queryStr) && Checker.isEmpty(filterQueryStr)) {
            return page;
        }
		SolrClient solrClient = null;
		try {
			solrClient = initSolrClient();
			SolrQuery query = new SolrQuery();
			query.setQuery(queryStr);
			query.addFilterQuery(filterQueryStr);
			// 分组查询
            if (page.getGroup() != null) {
                Group group = page.getGroup();
                query.setIncludeScore(group.isIncludeScore());
                query.setParam(GroupParams.GROUP, true);
                if (Checker.isNotEmpty(group.getGroupField())) {
                    query.setParam(GroupParams.GROUP_FIELD, group.getGroupField());
                }
                if (Checker.isNotEmpty(group.getGroupLimit())) {
                    query.setParam(GroupParams.GROUP_LIMIT, group.getGroupLimit());
                }
                if (group.isNeedCountGroup()) {
                    query.setParam(GroupParams.GROUP_TOTAL_COUNT, true);
                }
            }
            // Facet查询
            if (page.getFacet() != null) {
            	Facet facet = page.getFacet();
            	query.setParam(FacetParams.FACET, true);
            	if (Checker.isNotEmpty(facet.getFacetField())) {
                    query.setParam(FacetParams.FACET_FIELD, facet.getFacetField());
                }
                if (Checker.isNotEmpty(facet.getFacetLimit())) {
                    query.setParam(FacetParams.FACET_LIMIT, facet.getFacetLimit());
                }
                if (Checker.isNotEmpty(facet.getFacetMinCount())) {
                    query.setParam(FacetParams.FACET_MINCOUNT, facet.getFacetMinCount());
                }
            }
            if(Checker.isNotEmpty(page.getSortList())){
				List<SortClause> sortList = convertSortToSortClause(page.getSortList());
                for (SortClause sortClause : sortList) {
                    query.addSort(sortClause);
                }
			}
            int start = (page.getPageNumber() - 1) * page.getPageSize();
            query.setStart(start);
            query.setRows(page.getPageSize());
            QueryResponse response = solrClient.query(type.getType(), query);
            if (response != null) {
            	GroupResponse groupResponse = response.getGroupResponse();
            	if (groupResponse != null) {
            		List<List<GroupRes<T>>> groupDataList = new ArrayList<List<GroupRes<T>>>();
            		List<GroupCommand> groupList = groupResponse.getValues();
            		for (GroupCommand groupCommand : groupList) {
            			List<org.apache.solr.client.solrj.response.Group> groups = groupCommand.getValues();
            			List<GroupRes<T>> dataMap = new ArrayList<GroupRes<T>>();
            			for (org.apache.solr.client.solrj.response.Group group : groups) {
            				SolrDocumentList docList = group.getResult();
                            GroupRes<T> groupData = new GroupRes<T>();
                            groupData.setGroupValue(group.getGroupValue());
                            groupData.setItems(BeanUtil.list2list(docList, clazz));
                            dataMap.add(groupData);
            			}
            			groupDataList.add(dataMap);
            			if (page.getTotalCount() == 0) {
            				page.setTotalCount(Integer.valueOf(String.valueOf(groupCommand.getNGroups())));
            			}
            		}
            		page.setDataRes(groupDataList);
            	}
            	// 由于getNGroups在分片的时候会有bug，则用Facet用于统计数量
                if (page.getFacet() != null) {
                    page.setTotalCount(response.getFacetFields().get(0).getValueCount());
                }
                // 计算pagecount
                if (page.getTotalCount() > 0 && page.getPageCount() == 1) {
                    int pageCount = page.getTotalCount() % page.getPageSize() == 0 ? page.getTotalCount() / page.getPageSize()
                            : (page.getTotalCount() / page.getPageSize()) + 1;
                    page.setPageCount(pageCount);
                }
                page.setHasNext(page.getPageNumber() < page.getPageCount()); // 设置是否有下一页
                StringBuffer buffer = new StringBuffer("solr selectGroupArrayByPage: ");
                buffer.append(queryStr)
                	.append(",sort=[")
                	.append(page.getSortList() != null ? JSonUtil.toJSonString(page.getSortList()) : "")
                	.append("]")
                    .append(",Records=")
                    .append(page.getTotalCount())
                    .append(",Time=")
                    .append(response.getQTime())
                    .append("ms");
                LogCvt.info(buffer.toString());
            }
		} catch (Exception e) {
			LogCvt.error("分页分组查询数据失败，queryStr为 ：" + queryStr + "    ***filterQueryStr：" + filterQueryStr + "    ***page：" + JSonUtil.toJSonString(page)
            + "   ***clazz" + clazz, e);
		} finally {
			closeSolrClient(solrClient);
		}
		return page;
	}
	
	private List<SortClause> convertSortToSortClause(List<Sort> sortList) {
        List<SortClause> sortClauseList = new ArrayList<SortClause>();
        for (Sort sort : sortList) {
            sortClauseList
                    .add(new SortClause(sort.getSortKey(), SortType.ASC.getType() == sort.getSortType().getType() ? SolrQuery.ORDER.asc : SolrQuery.ORDER.desc));
        }
        return sortClauseList;
    }

	@Override
	public <T> T selectById(String id, Class<T> clazz, CollectionType type) {
		if (Checker.isEmpty(id)) {
            return null;
        }
		SolrClient solrClient = null;
		try {
			solrClient = initSolrClient();
			SolrQuery query = new SolrQuery();
			String queryStr = "id:"+id;
			query.setQuery(queryStr);
			QueryResponse response = solrClient.query(type.getType(), query);
			if (response != null) {
            	SolrDocumentList docList = response.getResults();
            	List<T> mlist = BeanUtil.list2list(docList, clazz);
            	if(Checker.isNotEmpty(mlist)){
            		return mlist.get(0);
            	}
			}
		} catch (Exception e) {
			LogCvt.error("分页分组查询数据失败，id为 ：" + id+ "   ***clazz" + clazz, e);
		} finally {
			closeSolrClient(solrClient);
		}
		return null;
	}
	
}
