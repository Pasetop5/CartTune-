package finalCarTune.CARTUNE.Repository;

import finalCarTune.CARTUNE.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import finalCarTune.CARTUNE.Model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByAppointmentID(Long appointmentID);
    List<Appointment> findByUser(User user);

}
