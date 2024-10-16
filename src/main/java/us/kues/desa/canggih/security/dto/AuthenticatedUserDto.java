package us.kues.desa.canggih.security.dto;

import us.kues.desa.canggih.model.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Created on 16 Oktober, 2024
 *
 * @author Coim
 */
@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto {

	private String name;

	private String username;

	private String password;

	private UserRole userRole;

}
