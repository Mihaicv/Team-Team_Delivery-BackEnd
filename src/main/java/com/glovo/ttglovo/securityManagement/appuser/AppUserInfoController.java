package com.glovo.ttglovo.securityManagement.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
public class AppUserInfoController {

    private final AppUserService appUserService;

    @GetMapping("/client")
    public String currentUser() {
        //TODO atentie user e email!!!

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = (AppUser) appUserService.loadUserByUsername((String) authentication.getPrincipal());
        return user.getUsername() + "\n" + user.getAppUserRole();
    }
}

