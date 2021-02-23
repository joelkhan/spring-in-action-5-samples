package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication   // <1>
public class TacoCloudApplication {

  public static void main(String[] args) {
    // 传递给run()的两个参数，一个是配置类，另一个是命令行参数
    SpringApplication.run(TacoCloudApplication.class, args); // <2>
  }

}

