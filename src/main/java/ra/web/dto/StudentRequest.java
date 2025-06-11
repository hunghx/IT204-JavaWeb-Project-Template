package ra.web.dto;

import lombok.Getter;
import lombok.Setter;
//import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Getter
@Setter
public class StudentRequest {
    @NotBlank(message = "Không được để trống tên")
    private String name;
    private String email;
    private String phone;
    private String address;
    private MultipartFile file;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
}
