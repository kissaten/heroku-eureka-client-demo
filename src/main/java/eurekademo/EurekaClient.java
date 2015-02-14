package eurekademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
public class EurekaClient {

  @RequestMapping("/")
  public String home() {
    return "This is a trivial service that demonstrates how a Eureka Client can register with a Eureka Server";
  }

  public static void main(String[] args) {
    SpringApplication.run(EurekaClient.class, args);
  }
}