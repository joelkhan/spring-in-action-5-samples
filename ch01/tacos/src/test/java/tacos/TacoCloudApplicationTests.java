package tacos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * @RunWith是JUnit的注解，它会提供一个测试运行器（runner）来指导JUnit如何运行测试。
 * 可以将其想象为给JUnit应用一个插件，以提供自定义的测试行为。在本例中，为JUnit提供的是SpringRunner，
 * 这是一个Spring提供的测试运行器，它会创建测试运行所需的Spring应用上下文。
 * 
 * @SpringBootTest会告诉JUnit在启动测试的时候要添加上Spring Boot的功能。
 * 可以将这个测试类视同为在main()方法中调用SpringApplication.run()。
 * */
@RunWith(SpringRunner.class)    // <1>
@SpringBootTest                 // <2>
public class TacoCloudApplicationTests {

  @Test                         // <3>
  public void contextLoads() {
  }

}
