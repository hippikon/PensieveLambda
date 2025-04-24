package digital.pensieve;

import digital.pensieve.controller.MainController;
import digital.pensieve.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.UUID;


@SpringBootApplication
// We use direct @Import instead of @ComponentScan to speed up cold starts
@ComponentScan(basePackages = "digital.pensieve.controller")
@Import({ HelloController.class, MainController.class })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
