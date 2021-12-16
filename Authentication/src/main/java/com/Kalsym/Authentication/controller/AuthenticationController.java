package com.Kalsym.Authentication.controller;

import com.Kalsym.Authentication.model.AuthenticationRequest;
import com.Kalsym.Authentication.service.AuthenticationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthenticationController {

    private AuthenticationRequestService service;

    @Autowired
    public AuthenticationController(AuthenticationRequestService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public ResponseEntity<Object> login() {
        return new ResponseEntity<>("Hello ", HttpStatus.OK);
    }

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    public ResponseEntity<Object> loginByDb(@RequestBody AuthenticationRequest request, final HttpServletResponse headerResponse) {
        return service.getUserNameAndPassword(request.getUsername(), request.getPassword(), headerResponse);
    }

}
