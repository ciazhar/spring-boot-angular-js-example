package com.ciazhar.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ciazhar on 5/22/17.
 */

@RestController
@RequestMapping("api/user")
public class UserCotroller {

    @RequestMapping("/me")
    public Authentication currentUser(Authentication authentication){
        return authentication;
    }
}
