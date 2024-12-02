package finalCarTune.CARTUNE.Service;

import finalCarTune.CARTUNE.Dto.UserDto;
import finalCarTune.CARTUNE.Model.Role;
import finalCarTune.CARTUNE.Model.User;
import finalCarTune.CARTUNE.Repository.RoleRepository;
import finalCarTune.CARTUNE.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public User save(UserDto userDto, String roleName) {
        User user = new User(userDto.getFirstName(), userDto.getLastName(),
                userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));

        // Assign role based on the roleName provided
        Role userRole = roleRepository.findByName(roleName);
        if (userRole != null) {
            user.addRole(userRole);
        }

        return userRepository.save(user);
    }


    @Override
    public User save(UserDto userDto) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email); // Fetch user by email
    }
}
