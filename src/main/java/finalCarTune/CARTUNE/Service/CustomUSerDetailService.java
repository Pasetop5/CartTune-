package finalCarTune.CARTUNE.Service;


import finalCarTune.CARTUNE.Model.Role;
import finalCarTune.CARTUNE.Model.User;
import finalCarTune.CARTUNE.Repository.RoleRepository;
import finalCarTune.CARTUNE.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUSerDetailService implements UserDetailsService {

    @Autowired
  private UserRepository userRepository;

    @Autowired
    RoleRepository rolerepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null){
            throw  new UsernameNotFoundException("The User cannot be found"); // if the user is not found

        }

return new CustomUserDetail(user);
    }
}
