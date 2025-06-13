package ra.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Topic {
    @Id
    private Integer id;
    private String name;
}
