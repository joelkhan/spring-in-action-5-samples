package tacos.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Taco;

/*
 * @Slf4j是Lombok所提供的注解，在运行时，它会在这个类中自动生成一个SLF4J de Logger。
 * */
@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

  /*
   * 被@ModelAttribute注解的方法会在Controller每个方法执行之前都执行，
   * 因此对于一个Controller中包含多个URL的情况，要谨慎使用
   * */
  @ModelAttribute
  public void addIngredientsToModel(Model model) {
    List<Ingredient> ingredients = Arrays.asList(
        new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
        new Ingredient("COTO", "Corn Tortilla", Type.WRAP), 
        new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
        new Ingredient("CARN", "Carnitas", Type.PROTEIN), 
        new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
        new Ingredient("LETC", "Lettuce", Type.VEGGIES), 
        new Ingredient("CHED", "Cheddar", Type.CHEESE),
        new Ingredient("JACK", "Monterrey Jack", Type.CHEESE), 
        new Ingredient("SLSA", "Salsa", Type.SAUCE),
        new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
    
    Type[] types = Ingredient.Type.values();
    for (Type type : types) {
      //log.info("oneType: {}", type.toString().toLowerCase());
      model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
    }
  }

  @GetMapping
  public String showDesignForm(Model model) {
    model.addAttribute("design", new Taco());
    log.info("all keys in model: {}", model.asMap().keySet());
    //log.info("all keys in model: {}", JSON.toJSONString(model));
    
    return "design";
  }

  /*
   * 参数前的@ModelAttribute，将表单域封装的结果对象（Taco类），绑定到模型（model）中名称为“design”的key上
   * */
  @PostMapping 
  public String processDesign(@Valid @ModelAttribute("design") Taco design, 
                              Errors errors, 
                              Model model) {
    if (errors.hasErrors()) {
      return "design";
    }
    log.info("all keys in model【processDesign()】: {}", model.asMap().keySet());
    // Save the taco design...
    // We'll do this in chapter 3
    log.info("Processing design: " + design);
    return "redirect:/orders/current";
  }

  private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
    return ingredients.
            stream().
            filter(x -> x.getType().equals(type)).
            collect(Collectors.toList());
  }

}

