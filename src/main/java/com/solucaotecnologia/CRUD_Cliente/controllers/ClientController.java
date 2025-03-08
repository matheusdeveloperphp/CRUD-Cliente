package com.solucaotecnologia.CRUD_Cliente.controllers;

import com.solucaotecnologia.CRUD_Cliente.dto.ClientDTO;
import com.solucaotecnologia.CRUD_Cliente.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        ClientDTO clientDTO = clientService.findById(id);
        return ResponseEntity.ok(clientDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findallPaged(Pageable pageable) {
        Page<ClientDTO> dto = clientService.findallPaged(pageable);
        return ResponseEntity.ok(dto);
    }

}
