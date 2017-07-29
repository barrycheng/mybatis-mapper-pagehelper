package ml.jjandxa.db.example

import ml.jjandxa.db.utils.MapperGenerator
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class DbSpringBootExampleApplicationTests {

	@Test
	fun contextLoads() {
	}

	@Test
	fun genMapper() {
		// MapperGenerator.genMapper("/generatorConfig.xml")
	}

}
