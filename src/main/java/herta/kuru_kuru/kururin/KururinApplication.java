package herta.kuru_kuru.kururin;

import herta.kuru_kuru.kururin.infrastructure.email.EmailConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EntityScan(basePackages = "herta.kuru_kuru.kururin.model")
@Import(EmailConfig.class)
public class KururinApplication {
    public static void main(String[] args) {
        SpringApplication.run(KururinApplication.class, args);
    }
}
