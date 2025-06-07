package com.comprasapp.comprasapp.controller;

import com.comprasapp.comprasapp.model.User;
import com.comprasapp.comprasapp.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody String json){
        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject jsonObject1 = jsonObject.get("datos").getAsJsonObject();

        String username = jsonObject1.get("username").getAsString();
        String password = jsonObject1.get("password").getAsString();


        User user = this.userService.getUserByUsername(username);



    }

}
