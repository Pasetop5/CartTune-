package finalCarTune.CARTUNE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finalCarTune.CARTUNE.Model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email); //  to find by email
}
