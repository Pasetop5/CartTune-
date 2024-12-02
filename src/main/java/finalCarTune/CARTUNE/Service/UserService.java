package finalCarTune.CARTUNE.Service;

import finalCarTune.CARTUNE.Dto.UserDto;
import finalCarTune.CARTUNE.Model.User;

public interface UserService {

    User save(UserDto userDto);

    User save(UserDto userDto, String roleName);

    User findByEmail(String email);  // to retrieve user by email
}
