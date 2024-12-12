package sensorsApp.controllers.api.rest.impl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sensorsApp.controllers.api.rest.AuthController;
import sensorsApp.dto.JwtAuthenticationResponse;
import sensorsApp.dto.SignInRequest;
import sensorsApp.dto.SignUpRequest;
import sensorsApp.services.AuthenticationService;

/**
 * Authentication endpoint  implementation
 */
@Slf4j
@RestController
@Validated
@AllArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthenticationService authenticationService;

    @Override
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request) {

        log.info("SignUp request: {}", request);
        return authenticationService.signUp(request);
    }

    @Override
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {

        log.info("SignIn request: {}", request);
        return authenticationService.signIn(request);
    }
}