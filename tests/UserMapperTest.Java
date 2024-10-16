import org.junit.jupiter.api.Test;
import us.kues.desa.canggih.model.User;
import us.kues.desa.canggih.security.dto.AuthenticatedUserDto;
import us.kues.desa.canggih.security.dto.RegistrationRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

package us.kues.desa.canggih.security.mapper;



public class UserMapperTest {

	private final UserMapper userMapper = UserMapper.INSTANCE;

	@Test
	public void testConvertToUser() {
		RegistrationRequest registrationRequest = new RegistrationRequest();
		registrationRequest.setUsername("testUser");
		registrationRequest.setPassword("testPass");

		User user = userMapper.convertToUser(registrationRequest);

		assertNotNull(user);
		assertEquals("testUser", user.getUsername());
		assertEquals("testPass", user.getPassword());
	}

	@Test
	public void testConvertToAuthenticatedUserDto() {
		User user = new User();
		user.setUsername("testUser");
		user.setPassword("testPass");

		AuthenticatedUserDto authenticatedUserDto = userMapper.convertToAuthenticatedUserDto(user);

		assertNotNull(authenticatedUserDto);
		assertEquals("testUser", authenticatedUserDto.getUsername());
	}

	@Test
	public void testConvertToUserFromAuthenticatedUserDto() {
		AuthenticatedUserDto authenticatedUserDto = new AuthenticatedUserDto();
		authenticatedUserDto.setUsername("testUser");

		User user = userMapper.convertToUser(authenticatedUserDto);

		assertNotNull(user);
		assertEquals("testUser", user.getUsername());
	}
}