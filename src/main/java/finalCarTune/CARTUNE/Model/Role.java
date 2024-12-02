package finalCarTune.CARTUNE.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public Role() {
        super();
    }

    public Role(String name) {
        this.name = name;
    }
}