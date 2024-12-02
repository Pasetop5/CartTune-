package finalCarTune.CARTUNE.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalCarTune.CARTUNE.Model.Appointment;
import finalCarTune.CARTUNE.Model.User;
import finalCarTune.CARTUNE.Repository.AppointmentRepository;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll(); // to find LL 
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment); // to save 
    }

    @Override
    public List<Appointment> getAppointmentsByUser(User user) {
        return appointmentRepository.findByUser(user); // Use findByUser instead of findByUser
    }


    @Override
    public Optional<Appointment> getAppointmentByID(Long appointmentID) {
        return appointmentRepository.findByAppointmentID(appointmentID); //  to find by appointmentID
    }


    @Override
    public void deleteAppointmentByID(Long appointmentID) {
        this.appointmentRepository.deleteById(appointmentID); // to delete by ID
    }
}