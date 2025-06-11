package ra.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.web.dto.ModelRequest;
import ra.web.service.UserServiceImpl;
import ra.web.utils.UploadFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class HomeController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UploadFile uploadFile;
    @GetMapping("/home")
    public String home() {
        return "home"; // This will resolve to /WEB-INF/views/home.jsp
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam("file") MultipartFile file, Model model) throws IOException {
       model.addAttribute("fileName", uploadFile.uploadFileToCloudinary(file));
        return "success"; // Redirect to home after submission
    }
}
