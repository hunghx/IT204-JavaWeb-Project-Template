package ra.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ra.web.utils.JavaMailUtils;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@Controller
public class MailController {
    @Autowired
    private JavaMailUtils mailUtils;
    @GetMapping("/sendmail")
    public String sendEmail() throws MessagingException, IOException {
        mailUtils.sendMail("baby10051999@gmail.com","hung18061999hung@gmail.com","abc","demo mail");
        return "home";
    }
}
