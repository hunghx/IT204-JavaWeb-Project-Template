package ra.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.web.entity.User;
import ra.web.model.ModelRequest;
import ra.web.model.UserRequest;
import ra.web.service.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/home")
    public String home(Model model, @CookieValue(value = "count",defaultValue = "0") int count, HttpServletResponse response) {
//        count++;
//        response.addCookie(new Cookie("count", String.valueOf(count)));
//        model.addAttribute("count", count);
//        UserRequest userRequest = new UserRequest("abc","123", "a@gmail.com", "Nguyen Van A", "0123456789");
//        userService.add(userRequest);

//        List<User> users = userService.findAll();

//        User user =new User(1, "abc", "123", "hung@gmail.com","Nguyen Van Hung", "0123484394");
//        userService.update(user);
        userService.delete(1);

        model.addAttribute("request", new ModelRequest());
        return "home"; // This will resolve to /WEB-INF/views/home.jsp
    }

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("request") ModelRequest request, BindingResult result, Model model) {
        // Handle form submission logic here
        if (result.hasErrors()) {
            // If there are validation errors, return to the form view
            model.addAttribute("request",request);
            return "home"; // This will resolve to /WEB-INF/views/home.jsp
        }
        return "success"; // Redirect to home after submission
    }
}
