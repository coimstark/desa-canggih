package us.kues.desa.canggih.security.service;

import us.kues.desa.canggih.model.User;
import us.kues.desa.canggih.security.dto.AuthenticatedUserDto;
import us.kues.desa.canggih.security.dto.RegistrationRequest;
import us.kues.desa.canggih.security.dto.RegistrationResponse;


/**
 * Created on 16 Oktober, 2024
 *
 * @author Coim
 */
public interface UserService {



	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
