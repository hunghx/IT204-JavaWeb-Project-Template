package ra.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class VocabbularyDto {
    private Integer id;
    private String english;
    private String japan;
    private String sino;
    private String description;
    private String topicName;
}
