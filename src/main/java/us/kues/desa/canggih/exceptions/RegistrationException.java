package us.kues.desa.canggih.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


/**
 * Created on 16 Oktober, 2024
 *
 * @author Coim
 */
@Getter
@RequiredArgsConstructor
public class RegistrationException extends RuntimeException {

	private final String errorMessage;

}
