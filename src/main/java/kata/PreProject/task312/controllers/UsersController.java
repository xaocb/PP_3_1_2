package kata.PreProject.task312.controllers;


import jakarta.validation.Valid;
import kata.PreProject.task312.models.User;
import kata.PreProject.task312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String findAllUsers(Model model) {
        model.addAttribute("userlist", userService.findAllUsers());
        return "pages/users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "pages/getUserById";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "pages/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "pages/new";
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "pages/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "pages/edit";
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
