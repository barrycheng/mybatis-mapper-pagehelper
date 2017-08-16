package ml.jjandxa.db.controller

import com.github.pagehelper.PageInfo
import com.ricelink.cloud.base.pojo.ResponseData

/**
 * 单表维护 Controller 模板
 */
open abstract class CrudController<T, in R> {

    /**
     * 表格查询
     */
    abstract fun queryRecord(query: R, pageNum: Int, pageSize:Int): Map<String, Any>

    /**
     * 添加记录
     */
    abstract fun addRecord(record: T): ResponseData<T>

    /**
     * 批量删除记录
     */
    abstract fun deleteRecord(record: List<T>): ResponseData<T>

    /**
     * 更新记录
     */
    abstract fun updateRecord(record: T): ResponseData<T>

    /**
     * 返回表格数据
     */
    protected fun getTableData(pageinfo: PageInfo<T>): Map<String, Any> {
        return mapOf("data" to pageinfo.list, "total" to pageinfo.total)
    }
}