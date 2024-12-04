package finalCarTune.CARTUNE.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


// Role Entity
@Entity
@Data
@Table(name = "Roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto generated
    private Long id;

    @Column(nullable = false, unique = true) // column is not null
    private String name;

    public Role() { // default constructor
        super();
    }

    public Role(String name) { // constructor
        this.name = name;
    }
}