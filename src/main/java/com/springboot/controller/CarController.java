package com.springboot.controller;

import com.springboot.domain.Car;
import com.springboot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes(types = {String.class},names = {"car"})
public class CarController {
    @Autowired
    private CarService carService;

    // rest风格
    @RequestMapping(value = "carlist",method = RequestMethod.GET)
//    @GetMapping("carlist")      跳转版
    public ModelAndView list(){
        List<Car> cars = carService.list();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("carlist");
        mv.addObject("cars",cars);

        Car car = new Car();
        car.setId(6);
        car.setName("宝马");
        car.setCreateDate(new Date());
        car.setPrice(600d);
        mv.addObject("car",car);
        return mv;
    }

    @RequestMapping(value = "hithymeleaf",method = RequestMethod.GET)
    public String hiThymeleaf(
            @RequestParam(value = "name",required = false,defaultValue = "world") String name,
            Model model
    ){
        // 模型数据
        model.addAttribute("name","平仔仔");
        // 视图名（resources 下的模板中的 html:hello.html）
        return "hello";
    }
}
