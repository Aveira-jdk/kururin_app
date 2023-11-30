package herta.kuru_kuru.kururin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "herta.kuru_kuru.kururin.repository")
@EnableTransactionManagement
public class JpaConfig {
    // Additional JPA configurations лif needed
}
