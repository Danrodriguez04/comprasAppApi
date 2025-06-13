package com.comprasapp.comprasapp.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.comprasapp.comprasapp.model.User;
import com.comprasapp.comprasapp.service.TokenService;
import com.comprasapp.comprasapp.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final TokenService tokenService;


    UserController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<List<String>> login(@RequestBody String json){
        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject jsonObject1 = jsonObject.get("datos").getAsJsonObject();

        String username = jsonObject1.get("username").getAsString();
        String password = jsonObject1.get("password").getAsString();

        User user = this.userService.getUserByUsername(username);

        if(user != null){
            BCrypt.Result result  = BCrypt.verifyer().verify(password.toCharArray(),user.getPassword());

            if(!result.verified){
                String token = this.tokenService.createToken(username);
                List<String> response = new ArrayList<>();
                response.add(token);
                response.add(user.getId().toString());
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody String json){


        return null;
    }


    @PostMapping("/register/google")
    public ResponseEntity<String> registerGoogle(@RequestBody String json){


        return null;
    }

}
