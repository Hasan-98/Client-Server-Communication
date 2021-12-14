/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Kalsym.Authentication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hasan
 */
@RestController
public class UserController {

    @RequestMapping("/userlogin")
    public String userValidation() {
        return "User, Login Successfully";
    }

    @RequestMapping("/adminlogin")
    public String adminValidation() {
        return "Admin, Login Successfully";
    }
}
