package us.kues.desa.canggih.security.mapper;

import us.kues.desa.canggih.model.User;
import us.kues.desa.canggih.security.dto.AuthenticatedUserDto;
import us.kues.desa.canggih.security.dto.RegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


/**
 * Created on 16 Oktober, 2024
 *
 * @author Coim
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User convertToUser(RegistrationRequest registrationRequest);

	AuthenticatedUserDto convertToAuthenticatedUserDto(User user);

	User convertToUser(AuthenticatedUserDto authenticatedUserDto);

}
