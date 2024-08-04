package com.example.demo.auth;

import com.example.demo.client.dao.ClientRepository;
import com.example.demo.client.entity.Client;
import com.example.demo.client.entity.Role;
import com.example.demo.config.JwtService;
import com.example.demo.exceptions.EmailAlreadyExist;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final ClientRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(AuthenticationRequest request) {
        if(repository.findClientByEmail(request.getEmail()).isPresent())
            throw new EmailAlreadyExist(request.getEmail() + " already registered");

        Client client = Client.builder()
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(client);

        final String jwtToken = jwtService.generateToken(Map.of("scope", Role.USER.name()),client);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword())
        );

        Client client = repository.findClientByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("email not found"));
        final String jwtToken = jwtService.generateToken(Map.of("scope", Role.USER.name()), client);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
