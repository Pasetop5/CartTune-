package finalCarTune.CARTUNE.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import finalCarTune.CARTUNE.Model.Appointment;
import finalCarTune.CARTUNE.Model.User;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByAppointmentID(Long appointmentID); //   to find by appointmentID
    List<Appointment> findByUser(User user); // to find by user

}
