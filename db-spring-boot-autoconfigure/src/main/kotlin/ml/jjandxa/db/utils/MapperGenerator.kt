package ml.jjandxa.db.utils

import org.mybatis.generator.api.MyBatisGenerator
import org.mybatis.generator.config.xml.ConfigurationParser
import org.mybatis.generator.internal.DefaultShellCallback
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.ArrayList

/**
 * Mapper 生成工具
 */
class MapperGenerator {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(MapperGenerator::class.java)

        fun genMapper(configPath: String) {
            logger.info("开始生成代码")
            val warnings = ArrayList<String>()
            val overwrite = true
            val cp = ConfigurationParser(warnings)
            val config = cp.parseConfiguration(
                    MapperGenerator::class.java.getResourceAsStream(configPath))
            val callback = DefaultShellCallback(overwrite)
            val myBatisGenerator = MyBatisGenerator(config, callback, warnings)
            myBatisGenerator.generate(null)
            logger.info("生成代码结束")
        }
    }
}