package ml.jjandxa.db

import ml.jjandxa.db.config.mapper.MapperConfiguration
import ml.jjandxa.db.config.pagehelper.PageHelperConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(MapperConfiguration::class, PageHelperConfiguration::class)
open class DataBaseAutoConfigure