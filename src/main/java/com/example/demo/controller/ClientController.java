package com.example.demo.controller;

import com.example.demo.client.dao.ClientRepository;
import com.example.demo.client.entity.ClientDTO;
import com.example.demo.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<ClientDTO> clientInfo(){
        return ResponseEntity.ok(clientService.getInfo());
    }
}
