package ml.jjandxa.db.controller;

import com.github.pagehelper.PageInfo;
import com.ricelink.cloud.base.pojo.ResponseData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单表维护 Controller 模板
 */
abstract class CrudController<T, R> {

    /**
     * 表格查询
     */
    abstract protected Map<String, Object> queryRecord(R query);

    /**
     * 添加记录
     */
    abstract protected ResponseData<T> addRecord(T record);

    /**
     * 批量删除记录
     */
    abstract protected ResponseData<T> deleteRecord(List<T> record);

    /**
     * 更新记录
     */
    abstract protected ResponseData<T> updateRecord(T record);

    /**
     * 返回表格数据
     */
    protected Map<String, Object> getTableData(PageInfo<T> pageInfo)  {
        Map<String, Object> result = new HashMap<>();
        result.put("data", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }
}