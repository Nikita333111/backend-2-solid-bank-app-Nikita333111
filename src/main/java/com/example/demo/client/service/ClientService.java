package com.example.demo.client.service;

import com.example.demo.client.dao.ClientRepository;
import com.example.demo.client.entity.Client;
import com.example.demo.client.entity.ClientDTO;
import com.example.demo.exceptions.AccountNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;

    public ClientDTO getInfo() {
        Long clientID = ((Client) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getClientId();
        Client client = repository.findById(clientID).orElseThrow(()-> new AccountNotFound("not found"));
        return ClientDTO.builder()
                .email(client.getEmail())
                .password(client.getPassword())
                .build();
    }
}
