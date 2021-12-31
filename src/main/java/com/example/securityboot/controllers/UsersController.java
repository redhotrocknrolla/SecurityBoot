package com.example.securityboot.controllers;//package web.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import web.Service.UserService;
//import web.models.User;
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Controller
//@RequestMapping("/users")
//public class UsersController {
//
//    private final UserService userService;
//
//    @Autowired
//    public UsersController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping()
//    public String index(Model model) {
//        model.addAttribute("users", userService.index());
//        return "users/index";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.show(id));
//        return "users/show";
//    }
//    @GetMapping("/new")
//    public String newUser(@ModelAttribute("user") User user) {
//        return "users/new";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("user")@Valid User user,
//                         BindingResult bindingResult) {
//        if (bindingResult.hasErrors()){
//            return "users/new";
//        }
//        userService.save(user);
//        return "redirect:/users";
//    }
//    @GetMapping("/{id}/edit")
//    public String edit(Model model,@PathVariable("id")int id) {
//        model.addAttribute("user", userService.show(id));
//        return "users/edit";
//    }
//
//@PatchMapping("/{id}")
//public String update(@ModelAttribute("user")@Valid User user, BindingResult bindingResult,
//                     @PathVariable("id") int id) {
//    if (bindingResult.hasErrors())
//        return "users/edit";
//
//    userService.update(id,user);
//    return "redirect:/users";
//}
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id")int id) {
//        userService.delete(id);
//        return "redirect:/users";
//    }
//
//}
