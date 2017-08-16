package ml.jjandxa.db.service;

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional
import tk.mybatis.mapper.common.Mapper
import tk.mybatis.mapper.entity.Example

/** 通用Service
 * Created by aixiaoai on 16/7/18.
 */
open class BaseService<T> {

    @Autowired
    protected lateinit var mapper: Mapper<T>

    /**
     * 查询所有
     */
    fun selectAll(): List<T> {
        return mapper.selectAll()
    }

    /**
     * 根据主键查询
     */
    fun selectByPrimaryKey(key: T): T {
        return mapper.selectByPrimaryKey(key)
    }

    /**
     * 根据条件实例查询
     */
    fun selectByExample(example: Example): List<T> {
        return mapper.selectByExample(example)
    }

    /**
     * 根据条件实例查询一个对象
     */
    fun selectOne(record: T): T {
        return mapper.selectOne(record)
    }

    /**
     * 新增
     */
    fun insert(record: T): Int {
        return mapper.insert(record)
    }

    /**
     * 选择新增
     */
    fun insertSelective(record: T): Int {
        return mapper.insertSelective(record)
    }

    /**
     * 根据主键新增
     */
    fun updateByPrimaryKey(record: T): Int {
        return mapper.updateByPrimaryKey(record)
    }

    /**
     * 根据主键选择新增
     */
    fun updateByPrimaryKeySelective(record: T): Int {
        return mapper.updateByPrimaryKeySelective(record)
    }

    /**
     * 根据属性更新
     */
    fun updateByExample(record: T, example: Example): Int {
        return mapper.updateByExample(record, example)
    }

    /**
     * 根据属性选择更新
     */
    fun updateByExampleSelective(record: T, example: Example): Int {
        return mapper.updateByExampleSelective(record, example)
    }

    /**
     * 删除
     */
    fun delete(record: T): Int {
        return mapper.delete(record)
    }


    /**
     * 根据主键删除
     */
    fun deleteByPrimaryKey(key: Any): Int {
        return mapper.deleteByPrimaryKey(key)
    }

    /**
     * 批量删除
     */
    @Throws(RuntimeException::class)
    @Transactional
    open fun deleteBatchByPrimaryKey(record: List<T>) {
        record.forEach {
            mapper.delete(it)
        }
    }

    /**
     * 根据属性删除
     */
    fun deleteByExample(example: Example): Int {
        return mapper.deleteByExample(example)
    }

    /**
     * 分页查询所有
     */
    fun selectAllByList(pageNum: Int, pageSize: Int): PageInfo<T> {
        PageHelper.startPage<T>(pageNum, pageSize)
        return PageInfo(mapper.selectAll())
    }

    /**
     * 根据属性分页查询
     */
    fun selectByList(record: T, pageNum: Int, pageSize: Int): PageInfo<T> {
        PageHelper.startPage<T>(pageNum, pageSize)
        return PageInfo(mapper.select(record))
    }

    /**
     * 根据example分页查询
     */
    fun selectByExampleList(example: Example, pageNum: Int, pageSize: Int): PageInfo<T> {
        PageHelper.startPage<T>(pageNum, pageSize)
        return PageInfo(mapper.selectByExample(example))
    }

    /**
     * 分页查询所有
     */
    fun selectAllByOffSetList(offset: Int, limit: Int): PageInfo<T> {
        PageHelper.offsetPage<T>(offset, limit)
        return PageInfo(mapper.selectAll())
    }

    /**
     * 根据属性分页查询
     */
    fun selectByOffSetList(record: T, offset: Int, limit: Int): PageInfo<T> {
        PageHelper.offsetPage<T>(offset, limit)
        return PageInfo(mapper.select(record))
    }

    /**
     * 根据example分页查询
     */
    fun selectByExampleOffSetList(example: Example, offset: Int, limit: Int): PageInfo<T> {
        PageHelper.offsetPage<T>(offset, limit)
        return PageInfo(mapper.selectByExample(example))
    }

}
