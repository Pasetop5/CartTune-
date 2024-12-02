package finalCarTune.CARTUNE.Controller;

import finalCarTune.CARTUNE.Model.Appointment;
import finalCarTune.CARTUNE.Model.User;
import finalCarTune.CARTUNE.Service.AppointmentService;
import finalCarTune.CARTUNE.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService; // Autowire the UserService

    @GetMapping("/appointment")
    public String viewAppointmentPage(Model model, Principal principal) {
        String userEmail = principal.getName();
        User user = userService.findByEmail(userEmail); // Fetch the logged-in user
        model.addAttribute("user", user); // Correctly set the user
        List<Appointment> appointments = appointmentService.getAllAppointments();
        model.addAttribute("listAppointments", appointments);
        return "admin"; // The name of the Thymeleaf template for admin
    }

    @GetMapping("/showNewAppointmentForm")
    public String showNewAppointmentForm(Model model) {
        Appointment appointment = new Appointment();
        model.addAttribute("appointment", appointment);
        model.addAttribute("user", userService);
        return "user";
    }

    @PostMapping("/saveAppointment")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment, RedirectAttributes redirectAttributes, Principal principal) {
        String userEmail = principal.getName();
        User user = userService.findByEmail(userEmail);  // Fetch User object from the database
        appointment.setUser(user);
        appointmentService.saveAppointment(appointment);

        redirectAttributes.addFlashAttribute("message", "Your appointment has been created Successfully");
        return "redirect:/appointment-success";
    }

    @GetMapping("/appointment-success")
    public String appointmentSuccessPage() {
        return "appointment-success"; // Appointment successful page
    }

    @GetMapping("/user/appointments")
    public String viewUserAppointments(Model model, Principal principal) {
        String userEmail = principal.getName();
        User user = userService.findByEmail(userEmail);
        List<Appointment> userAppointments = appointmentService.getAppointmentsByUser(user);

        model.addAttribute("listAppointments", userAppointments);
        model.addAttribute("user", user); // Ensure the user is set
        model.addAttribute("message", "Welcome back!");
        return "user-appointments";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long appointmentID, Model model) {
        Optional<Appointment> optionalAppointment = appointmentService.getAppointmentByID(appointmentID);

        if (optionalAppointment.isPresent()) {
            model.addAttribute("appointment", optionalAppointment.get());
            return "update_appointment";
        } else {
            model.addAttribute("errorMessage", "Appointment not found for ID: " + appointmentID);
            return "error_page"; // Redirect to an error page or display an error message
        }
    }

    @GetMapping("/deleteAppointment/{id}")
    public String deleteAppointment(@PathVariable(value = "id") Long appointmentID, Model model) {
        appointmentService.deleteAppointmentByID(appointmentID);
        return "redirect:/user-page";
    }

    // Get request for searching appointments
    @GetMapping("/search/appointment")
    public String getSearchAppointment(@RequestParam("appointmentID") String appointmentID, Model model) {
        try {
            Long id = Long.parseLong(appointmentID);
            Optional<Appointment> optionalAppointment = appointmentService.getAppointmentByID(id);
            if (optionalAppointment.isPresent()) {
                model.addAttribute("appointment", optionalAppointment.get());
                model.addAttribute("isSearchMade", true); // Indicate a search was made
            } else {
                model.addAttribute("errorMessage", "Appointment not found");
                model.addAttribute("isSearchMade", true); // Still indicate a search was made
            }
        } catch (NumberFormatException e) {
            // Handle invalid input
            model.addAttribute("errorMessage", "Invalid appointment ID. Please enter a valid number.");
            model.addAttribute("isSearchMade", true); // Indicate a search was made, even with an invalid ID
        }
        return "admin"; // Return the admin view
    }

    // Post request for searching appointments
    @PostMapping("/search/appointment")
    public String searchAppointment(@RequestParam("appointmentID") String appointmentID, Model model) {
        return getSearchAppointment(appointmentID, model); // to reuse the logic from the GET method
    }
}
