package ml.jjandxa.db.config.mapper

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.context.annotation.Configuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ApplicationContext
import tk.mybatis.mapper.common.Mapper
import tk.mybatis.mapper.mapperhelper.MapperHelper
import javax.annotation.PostConstruct

@Configuration
@EnableConfigurationProperties(MapperProperties::class)
@AutoConfigureAfter(MybatisAutoConfiguration::class)
open class MapperConfiguration {

    @Autowired
    private lateinit var sqlSessionFactoryList: List<SqlSessionFactory>
    @Autowired
    private lateinit var applicationContext: ApplicationContext
    @Autowired
    private lateinit var properties: MapperProperties

    @PostConstruct
    fun addPageInterceptor() {
        val mapperHelper = MapperHelper()
        mapperHelper.config = properties
        if (properties.mappers.isNotEmpty()) {
            properties.mappers.forEach {
                //提前初始化MapperFactoryBean,注册mappedStatements
                applicationContext.getBeansOfType(it)
                mapperHelper.registerMapper(it)
            }
        } else {
            //提前初始化MapperFactoryBean,注册mappedStatements
            applicationContext.getBeansOfType(Mapper::class.java)
            mapperHelper.registerMapper(Mapper::class.java)
        }
        for (sqlSessionFactory in sqlSessionFactoryList) {
            mapperHelper.processConfiguration(sqlSessionFactory.configuration)
        }
    }
}