package tacos;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
/*
 * @WebMvcTest是Spring Boot所提供的一个特殊测试注解，
 * 它会让这个测试在Spring MVC应用的上下文中执行 */
@WebMvcTest(HomeController.class)   // <1>
public class HomeControllerTest {

  @Autowired
  private MockMvc mockMvc;   // <2>

  @Test
  public void testHomePage() throws Exception {
    mockMvc.perform(get("/"))    // <3>
      .andExpect(status().isOk())  // <4>
      .andExpect(view().name("home"))  // <5>
      .andExpect(content().string(containsString("Welcome to...")));  // <6>
  }

}

