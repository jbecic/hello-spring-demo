package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hello") //route for all start with localhost:8080/hello
public class HelloController {

    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodBye() {
        return "Goodbye, Spring!";
    }

    // lives at /hello/hello
    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "language")
    @ResponseBody
    public static String createMessage(String name,@RequestParam String language) {
        String greeting = "Hello, ";
        if (language.equals("French")) {
            greeting = "Bonjour, ";
        }
        if (language.equals("Spanish")) {
            greeting = "Hola, ";
        }
        if (language.equals("German")) {
            greeting = "Guten tag, ";
        }
        if (language.equals("Italian")) {
            greeting = "Ciao, ";
        }
        return greeting + name + "!";
    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
