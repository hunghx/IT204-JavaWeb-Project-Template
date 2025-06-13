package ra.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vocabulary {
    @Id
    private Integer id;
    private String english;
    private String japan;
    private String sino;
    private String description;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
}
