/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Kalsym.Authentication.service;

import com.Kalsym.Authentication.model.AuthenticationRequest;
import com.Kalsym.Authentication.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

/**
 * @author hasan
 */
@Service
public class AuthenticationRequestService {

    private final AuthenticationRepository repo;

    @Autowired
    public AuthenticationRequestService(AuthenticationRepository repo) {
        this.repo = repo;
    }

    public ResponseEntity<Object> getUserNameAndPassword(String username, String password, final HttpServletResponse headerResponse) {
        HashMap<String, Object> response = new HashMap<>();
        headerResponse.setHeader("Cache-Control", "no-store");
        headerResponse.setHeader("Pragma", "no-cache");
        Optional<AuthenticationRequest> user = repo.findAuthenticationRequestByUsernameAndPassword(username, password);
        if (user.isPresent()) {
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
