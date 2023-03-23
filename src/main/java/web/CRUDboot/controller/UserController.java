package web.CRUDboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.CRUDboot.service.UserService;
import web.CRUDboot.model.User;
import web.CRUDboot.controller.UserController;





@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userServiceList;

    @Autowired
    public UserController(UserService userServiceList) {
        this.userServiceList = userServiceList;
    }

    @GetMapping("")
    public String users(Model model) {
        model.addAttribute("users", userServiceList.findAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServiceList.findOne(id));
        return "show";
    }

    @GetMapping("/new")
    public String newCar(Model model){
        model.addAttribute("user", new User());
        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "new";
        userServiceList.save(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){;
        model.addAttribute("user",userServiceList.findOne(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "edit";
        userServiceList.update(id, user);
        return "redirect:/users";

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userServiceList.delete(id);

        return "redirect:/users";
    }
}