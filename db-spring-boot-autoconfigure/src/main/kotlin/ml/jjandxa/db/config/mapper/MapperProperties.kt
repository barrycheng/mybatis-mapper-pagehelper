package ml.jjandxa.db.config.mapper;

import org.springframework.boot.context.properties.ConfigurationProperties
import tk.mybatis.mapper.entity.Config

@ConfigurationProperties(prefix = "mapper")
class MapperProperties(var mappers: List<Class<*>> = arrayListOf()) : Config()