package finalCarTune.CARTUNE.Service;

import java.util.List;
import java.util.Optional;

import finalCarTune.CARTUNE.Model.Appointment;
import finalCarTune.CARTUNE.Model.User;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    void saveAppointment(Appointment appointment);

    List<Appointment> getAppointmentsByUser(User user);

    Optional<Appointment> getAppointmentByID(Long appointmentID); 

    void deleteAppointmentByID(Long appointmentID);
}
