package com.Kalsym.Authentication.controller;

import com.Kalsym.Authentication.model.AuthenticationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.UUID;

@Controller
public class AuthenticationController {

    @GetMapping("/hello")
    public ResponseEntity<Object> HelloWorld() {
        UUID uuid = UUID.randomUUID();
        String access_token = uuid.toString();

        return new ResponseEntity<>("Hello " + access_token, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    public ResponseEntity<Object> HelloWorld(@RequestBody AuthenticationRequest request, final HttpServletResponse headerResponse) {
        HashMap<String, Object> response = new HashMap<>();
        headerResponse.setHeader("Cache-Control", "no-store");
        headerResponse.setHeader("Pragma", "no-cache");

        if (request.getUsername().equals("hasan") && request.getPassword().equals("123")) {

            UUID uuid = UUID.randomUUID();
            String access_token = uuid.toString();
            response.put("access_token", access_token);
            response.put("token_type", "bearer");
            response.put("expires_in", 180);
            response.put("scope", "create");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("error", "invalid request");
            response.put("error_description", "Request was missing the 'password' parameter.");
            response.put("error_uri", "See the full API docs at http://authorization-server.com/docs/access_token");

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
