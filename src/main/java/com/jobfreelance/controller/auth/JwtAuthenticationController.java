package com.jobfreelance.controller.auth;

import com.jobfreelance.dto.UserCredentialsDto;
import com.jobfreelance.dto.util.JwtRequest;
import com.jobfreelance.dto.util.JwtResponse;
import com.jobfreelance.service.util.JwtUserDetailsService;
import com.jobfreelance.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final JwtUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserCredentialsDto userDetails = userDetailsService.getUserByUserName(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails.getUcdmId());

        return ResponseEntity.ok(new JwtResponse(token));

    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserCredentialsDto userCredentialsDto) {
        return ResponseEntity.ok(jwtTokenUtil.generateToken(userDetailsService.save(userCredentialsDto).getUcdmId()));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password, null));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}