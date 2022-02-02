package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
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
    public String goodBye() {
        return "Goodbye, Spring!";
    }

    // lives at /hello/hello
    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "language")
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
        return "<html>" +
                "<body>" +
                "<form action='language' method='post'>" + //submit a request to hello/ language
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                    "<option value='English'>English</option>" +
                    "<option value='French'>French</option>" +
                    "<option value='Spanish'>Spanish</option>" +
                    "<option value='German'>German</option>" +
                    "<option value='Italian'>Italian</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
