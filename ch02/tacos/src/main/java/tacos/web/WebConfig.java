package tacos.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * 视图控制器：也就是只将请求转发到视图而不做其他事情的控制器。
 * 对于没有模型数据和逻辑处理的HTTP GET请求，就可以直接使用视图控制器。
 * 
 * WebMvcConfigurer定义了多个方法来配置Spring MVC。
 * 尽管只是一个接口，但是它提供了所有方法的默认实现，只需要覆盖所需的方法即可。
 * */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  /*
   * addViewControllers()方法会接收一个ViewControllerRegistry对象，
   * 我们可以使用它注册一个或多个视图控制器。
   * */
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("home");
  }

}

