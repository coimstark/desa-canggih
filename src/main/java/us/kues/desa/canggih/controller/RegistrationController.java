package us.kues.desa.canggih.controller;

import us.kues.desa.canggih.security.dto.RegistrationRequest;
import us.kues.desa.canggih.security.dto.RegistrationResponse;
import us.kues.desa.canggih.security.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * Created on 16 Oktober, 2024
 *
 * @author Coim
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

	private final UserService userService;

	@PostMapping
	@Operation(tags = "Register Service", description = "You can register to the system by sending information in the appropriate format.")
	public ResponseEntity<RegistrationResponse> registrationRequest(@Valid @RequestBody RegistrationRequest registrationRequest) {

		final RegistrationResponse registrationResponse = userService.registration(registrationRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
	}

}
