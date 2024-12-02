package finalCarTune.CARTUNE.Model;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appointmentID;

    @Column(nullable = false, length = 50)
    private String carName;

    @Column(length = 255)
    private String carProblemDescription;

    @Column(nullable = false, length = 30)
    private String carModel;

    @Column(nullable = false)
    private LocalDate appointmentDate;

    // Many Appointments can belong to one User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // linking to User

    public Appointment() {
        super();
    }

    public Appointment(String carName, String carProblemDescription, String carModel, LocalDate appointmentDate, User user) {
        this.carName = carName;
        this.carProblemDescription = carProblemDescription;
        this.carModel = carModel;
        this.appointmentDate = appointmentDate;
        this.user = user;
    }

}
