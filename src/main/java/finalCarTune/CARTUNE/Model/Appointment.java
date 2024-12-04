package finalCarTune.CARTUNE.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Appointment") // name of the table 
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appointmentID;

    @Column(nullable = false, length = 50) // length of the column
    private String carName;

    @Column(length = 255) // length of the column
    private String carProblemDescription;

    @Column(nullable = false, length = 30)
    private String carModel;

    @Column(nullable = false) // column is not null
    private LocalDate appointmentDate;

    // Many Appointments can belong to one User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // linking to User

    public Appointment() { // default constructor
        super();
    }

    public Appointment(String carName, String carProblemDescription, String carModel, LocalDate appointmentDate, User user) { // constructor
        this.carName = carName;
        this.carProblemDescription = carProblemDescription;
        this.carModel = carModel;
        this.appointmentDate = appointmentDate;
        this.user = user;
    }

}
