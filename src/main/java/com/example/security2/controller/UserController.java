package com.example.security2.controller;

import com.example.security2.repository.dto.UserSignupForm;
import com.example.security2.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("signup")
    public String signup(UserSignupForm userSignupForm) {
        System.out.println("---G signup called---");
        return "signup_form";
    }

    @PostMapping("signup")
    public String signup(@Valid UserSignupForm userSignupForm, BindingResult bindingResult) {
        System.out.println("---P signup called---");
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }
        if (!userSignupForm.getPassword1().equals(userSignupForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }

        userService.create(userSignupForm.getUsername(), userSignupForm.getEmail(), userSignupForm.getPassword1());
        return "redirect:/";
    }
}
