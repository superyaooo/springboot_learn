package com.springbootlearn.oauth2.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ClientController
{
    @RequestMapping("/")
    public String home(Principal user)
    {
        return "Hello " + user.getName();
    }
}
