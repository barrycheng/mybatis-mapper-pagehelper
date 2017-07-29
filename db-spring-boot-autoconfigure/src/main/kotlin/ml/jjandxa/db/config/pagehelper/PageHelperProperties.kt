package ml.jjandxa.db.config.pagehelper

import org.springframework.boot.context.properties.ConfigurationProperties
import java.util.*

@ConfigurationProperties(prefix = PageHelperProperties.PAGEHELPER_PREFIX)
class PageHelperProperties {

    companion object {
        const val PAGEHELPER_PREFIX = "pagehelper"
    }

    private val properties = Properties()

    fun getProperties(): Properties {
        return properties
    }

    fun getOffsetAsPageNum(): String {
        return properties.getProperty("offsetAsPageNum")
    }

    fun setOffsetAsPageNum(offsetAsPageNum: String) {
        properties.setProperty("offsetAsPageNum", offsetAsPageNum)
    }

    fun getRowBoundsWithCount(): String {
        return properties.getProperty("rowBoundsWithCount")
    }

    fun setRowBoundsWithCount(rowBoundsWithCount: String) {
        properties.setProperty("rowBoundsWithCount", rowBoundsWithCount)
    }

    fun getPageSizeZero(): String {
        return properties.getProperty("pageSizeZero")
    }

    fun setPageSizeZero(pageSizeZero: String) {
        properties.setProperty("pageSizeZero", pageSizeZero)
    }

    fun getReasonable(): String {
        return properties.getProperty("reasonable")
    }

    fun setReasonable(reasonable: String) {
        properties.setProperty("reasonable", reasonable)
    }

    fun getSupportMethodsArguments(): String {
        return properties.getProperty("supportMethodsArguments")
    }

    fun setSupportMethodsArguments(supportMethodsArguments: String) {
        properties.setProperty("supportMethodsArguments", supportMethodsArguments)
    }

    fun getDialect(): String {
        return properties.getProperty("dialect")
    }

    fun setDialect(dialect: String) {
        properties.setProperty("dialect", dialect)
    }

    fun getHelperDialect(): String {
        return properties.getProperty("helperDialect")
    }

    fun setHelperDialect(helperDialect: String) {
        properties.setProperty("helperDialect", helperDialect)
    }

    fun getAutoRuntimeDialect(): String {
        return properties.getProperty("autoRuntimeDialect")
    }

    fun setAutoRuntimeDialect(autoRuntimeDialect: String) {
        properties.setProperty("autoRuntimeDialect", autoRuntimeDialect)
    }

    fun getAutoDialect(): String {
        return properties.getProperty("autoDialect")
    }

    fun setAutoDialect(autoDialect: String) {
        properties.setProperty("autoDialect", autoDialect)
    }

    fun getCloseConn(): String {
        return properties.getProperty("closeConn")
    }

    fun setCloseConn(closeConn: String) {
        properties.setProperty("closeConn", closeConn)
    }

    fun getParams(): String {
        return properties.getProperty("params")
    }

    fun setParams(params: String) {
        properties.setProperty("params", params)
    }
}