package us.kues.desa.canggih.repository;

import us.kues.desa.canggih.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created on 16 Oktober, 2024
 *
 * @author Coim
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

}
