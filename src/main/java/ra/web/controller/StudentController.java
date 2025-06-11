package ra.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.web.dto.StudentRequest;
import ra.web.service.StudentService;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students/list";
    }
    @GetMapping("/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student",new StudentRequest());
        return "students/new";
    }
    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") StudentRequest studentRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("student", studentRequest);
            return "students/new"; // Return to the form with validation errors
        }
        studentService.addStudent(studentRequest);
        return "redirect:/students"; // Redirect to the list of students after adding
    }

    @GetMapping("/edit")
    public String editStudentForm() {
        return "students/edit";
    }
}
