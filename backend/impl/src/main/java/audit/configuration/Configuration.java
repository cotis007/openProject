package audit.configuration;

import audit.com.fabric.MercedesFabric;
import audit.com.processor.AuditBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan(basePackages = "audit")
@PropertySource(value = "classpath:application-local.properties")
public class Configuration {

    @Bean
    public Object postProcessBeforeInitialization() {
        return new AuditBeanPostProcessor();
    }


    @Bean
    public MercedesFabric mercedesFabric() {
        return new MercedesFabric();
    }

}
