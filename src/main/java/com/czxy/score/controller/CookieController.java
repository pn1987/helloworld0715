package com.czxy.score.controller;

import com.czxy.score.entity.Car;
import com.czxy.score.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/cookie")
public class CookieController {

    @GetMapping("/{id}")
    public ResponseEntity<HttpStatus> detail(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        Integer num = 1;
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                if (name.equals("history")) {
                    String[] vals = value.split("#");
                    if (vals[0].equals("" + id)) {
                        num = Integer.parseInt(vals[1]) + 1;
                    }
                    break;
                }
            }
        }
        Cookie history = new Cookie("history", id + "#" + num);
        history.setMaxAge(60*60*24*7);
        response.addCookie(history);

        return new ResponseEntity("ok",HttpStatus.OK);
    }

    @Autowired
    CarService carService;

    @GetMapping
    public ResponseEntity<Car> getCookieMsg(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                if (name.equals("history")) {
                    String[] vals = value.split("#");
                    Integer id = Integer.parseInt(vals[0]);
                    Integer num = Integer.parseInt(vals[1]);
                    Car car = carService.getCarById(id);
                    car.setNum(num);
                    return new ResponseEntity<>(car,HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(new Car(),HttpStatus.NO_CONTENT);
    }

}
