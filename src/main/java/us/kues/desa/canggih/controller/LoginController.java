package us.kues.desa.canggih.controller;

import us.kues.desa.canggih.security.dto.LoginRequest;
import us.kues.desa.canggih.security.dto.LoginResponse;
import us.kues.desa.canggih.security.jwt.JwtTokenService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created on 16 Oktober, 2024
 *
 * @author Coim
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

	private final JwtTokenService jwtTokenService;

	@PostMapping
	@Operation(tags = "Login Service", description = "You must log in with the correct information to successfully obtain the token information.")
	public ResponseEntity<LoginResponse> loginRequest(@Valid @RequestBody LoginRequest loginRequest) {

		final LoginResponse loginResponse = jwtTokenService.getLoginResponse(loginRequest);

		return ResponseEntity.ok(loginResponse);
	}

}
