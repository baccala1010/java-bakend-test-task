package sensorsApp.controllers.api.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sensorsApp.dto.JwtAuthenticationResponse;
import sensorsApp.dto.SignInRequest;
import sensorsApp.dto.SignUpRequest;

/**
 * Authentication endpoint interface
 */
@RequestMapping("/api/rest/auth")
@Tag(name = "Authentication")
public interface AuthController {

    @Operation(summary = "New user registration")
    @PostMapping("/sign-up")
    JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request);

    @Operation(summary = "User authentication")
    @PostMapping("/sign-in")
    JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request);
}