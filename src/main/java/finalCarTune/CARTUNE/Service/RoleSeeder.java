package finalCarTune.CARTUNE.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import finalCarTune.CARTUNE.Model.Role;
import finalCarTune.CARTUNE.Repository.RoleRepository;

@Component
public class RoleSeeder implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;


/**
 * This method runs automatically after the Spring application starts up.
 * It checks if the roles "USER" and "ADMIN" exist in the database.
 * If they don’t, it creates and saves them.
 */

    @Override
    public void run(String... args) {


        // Check if a role with the name "USER" exists in the database
        // If it doesn't exist, create and save a new "USER" role
        if (roleRepository.findByName("USER") == null) {
            roleRepository.save(new Role("USER"));
        }



        // Check if a role with the name "ADMIN" exists in the database
        // If it doesn't exist, create and save a new "ADMIN" role


        if (roleRepository.findByName("ADMIN") == null) {
            roleRepository.save(new Role("ADMIN"));
        }
    }
}
