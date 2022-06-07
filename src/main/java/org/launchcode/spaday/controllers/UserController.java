package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(Model model){
        model.addAttribute(new User());
        return "user/add";
    }
    @PostMapping("add")
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors, Model model, String verify){

        if(errors.hasErrors()){
            return "user/add";
        } else if(user.getPassword().equals(verify)){
            UserData.add(user);
            return "user/index";
        } else {
            model.addAttribute("error", "Passwords must match");
            model.addAttribute("user", user);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
//
            return "user/add";
        }
//        if(user.getPassword().equals(verify)){
//            UserData.add(user);
//           return "user/index";
//       }else{
//            model.addAttribute("user", user);
//            model.addAttribute("username", user.getUsername());
//            model.addAttribute("email", user.getEmail());
//
//            return "user/add";
//        }
    }

    @GetMapping
    public String displayUsers(Model model){
        model.addAttribute("title", "Users");
        model.addAttribute("users", UserData.getAll());
        return "user/index";
    }
    @GetMapping("detail/{userId}")
    public String displayDetail(Model model, @PathVariable int userId){
        User userDetail = UserData.getById(userId);
        model.addAttribute("user", userDetail);
        String title = "Detail: " + userDetail.getUsername();
        model.addAttribute("title", title);
        return "user/detail";
    }
}
