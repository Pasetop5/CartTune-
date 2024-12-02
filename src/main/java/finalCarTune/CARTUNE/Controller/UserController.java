package finalCarTune.CARTUNE.Controller;

import finalCarTune.CARTUNE.Dto.UserDto;
import finalCarTune.CARTUNE.Model.Appointment;
import finalCarTune.CARTUNE.Service.AppointmentService;
import finalCarTune.CARTUNE.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    private UserService userService;


    // for registration
    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
        return "register"; // the name of the registration page

    }

    @GetMapping("/admin/registration")
    public String getAdminRegistrationPage(@ModelAttribute("user") UserDto userDto) {
        return "admin-register"; // the name of the registration page

    }


    @PostMapping("/registration") // to save the registration page
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
        String roleName = "USER"; // Default role for new users
        userService.save(userDto, roleName); // saving the user dto with the default role
        model.addAttribute("message", "You have been registered Successfully!");
        //this will redirect the admin to the login page after successful registration
        return "redirect:/login";
    }


    @PostMapping("/admin/registration")
    public String saveAdmin(@ModelAttribute("user") UserDto userDto, Model model) {
        String roleName = "ADMIN"; // Default role for new users
        userService.save(userDto, roleName); // saving the user dto with the default role
        model.addAttribute("message", "You have been registered Successfully!");
        //this will redirect the admin to the login page after successful registration
        return "redirect:/login";
    }


    @GetMapping("/login") // for log in
    public String login() {
        return "login";
    }


    @GetMapping("/user-page")
    public String userPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);

        // Create a new Appointment object and add it to the model
        Appointment appointment = new Appointment();
        model.addAttribute("appointment", appointment);

        return "user"; // the name of the html
    }


    @GetMapping("/admin")  // Add this method to handle the /admin URL
    public String admin(Model model, Principal principal) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);

        // Fetch appointments if needed
        List<Appointment> appointments = appointmentService.getAllAppointments();
        model.addAttribute("listAppointments", appointments);

        return "admin";
    }


    @GetMapping("/admin-page")
    public String adminPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);

        // Fetch appointments and add them to the model
        List<Appointment> appointments = appointmentService.getAllAppointments();
        model.addAttribute("listAppointments", appointments);

        return "admin";
    }

    // controller  for index page

    @GetMapping("/HomePage")
    public String HomePageView() {
        return "index";// name of page


    }
}






