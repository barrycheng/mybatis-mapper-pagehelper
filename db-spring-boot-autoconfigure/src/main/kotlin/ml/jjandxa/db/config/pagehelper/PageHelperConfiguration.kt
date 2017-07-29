package ml.jjandxa.db.config.pagehelper

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.EnvironmentAware
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.boot.bind.RelaxedPropertyResolver
import org.springframework.beans.factory.annotation.Autowired
import org.apache.ibatis.session.SqlSessionFactory
import com.github.pagehelper.PageInterceptor
import javax.annotation.PostConstruct

@Configuration
@EnableConfigurationProperties(PageHelperProperties::class)
@AutoConfigureAfter(MybatisAutoConfiguration::class)
open class PageHelperConfiguration : EnvironmentAware {

    @Autowired
    private lateinit var sqlSessionFactoryList: List<SqlSessionFactory>

    @Autowired
    private lateinit var pageHelperProperties: PageHelperProperties

    private var resolver: RelaxedPropertyResolver? = null

    override fun setEnvironment(environment: Environment?) {
        resolver = RelaxedPropertyResolver(environment, "pagehelper.")
    }

    @PostConstruct
    fun addPageInterceptor() {
        val interceptor = PageInterceptor()
        val properties = pageHelperProperties.getProperties()
        val subProperties = resolver?.getSubProperties("")
        subProperties!!.keys.forEach {
            if (!properties.containsKey(it)) {
                properties.setProperty(it, resolver?.getProperty(it))
            }
        }
        interceptor.setProperties(properties)
        for (sqlSessionFactory in sqlSessionFactoryList) {
            sqlSessionFactory.configuration.addInterceptor(interceptor)
        }
    }
}