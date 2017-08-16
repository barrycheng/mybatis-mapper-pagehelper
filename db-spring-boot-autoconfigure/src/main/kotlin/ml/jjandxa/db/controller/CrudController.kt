package ml.jjandxa.db.controller

/**
 * 单表维护 Controller 模板
 */
open abstract class CrudController<T, in R> {

    /**
     * 表格查询
     */
    abstract fun queryRecord(query: R, pageNum: Int, pageSize:Int)

    /**
     * 添加记录
     */
    abstract fun addRecord(record: T)

    /**
     * 批量删除记录
     */
    abstract fun deleteRecord(record: List<T>)

    /**
     * 更新记录
     */
    abstract fun updateRecord(record: T)
}