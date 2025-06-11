package ra.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.web.dao.StudentDaoImpl;
import ra.web.dto.StudentRequest;
import ra.web.entity.Student;
import ra.web.utils.UploadFile;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDaoImpl studentDao;

    @Autowired
    private UploadFile uploadFile;

    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Transactional
    public void addStudent(StudentRequest request) {

        // Xư lí upload
        String avatarUrl = "example.com/avatar.jpg"; // Giả sử bạn đã upload file và có URL
        if (request.getFile() != null && !request.getFile().isEmpty()) {
            avatarUrl = uploadFile.uploadFileToCloudinary(request.getFile());
        }
        Student entity = Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .birthday(request.getBirthday())
                .avatar(avatarUrl) // Sử dụng URL đã upload
                .build();


        studentDao.save(entity);
    }
}
