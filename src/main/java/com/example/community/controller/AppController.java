package com.example.community.controller;

import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// import com.example.community.model.User;
// import com.example.community.service.CrudService;

@Controller
public class AppController {

    @Value("${welcome.message:test}")
    private String message = "Hello";

    // @Autowired
    // private CrudService<User> uService;

    @RequestMapping("/")
    String home(ModelMap modal) {
        modal.addAttribute("title", "CRUD Example");
        return "index";
    }

    @RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }

    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }
}
