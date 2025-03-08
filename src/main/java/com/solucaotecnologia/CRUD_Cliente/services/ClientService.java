package com.solucaotecnologia.CRUD_Cliente.services;

import com.solucaotecnologia.CRUD_Cliente.dto.ClientDTO;
import com.solucaotecnologia.CRUD_Cliente.entities.Client;
import com.solucaotecnologia.CRUD_Cliente.repositories.ClientRepository;
import com.solucaotecnologia.CRUD_Cliente.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> result = clientRepository.findById(id);
        Client client = result.orElseThrow(()  -> new  ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(client);
    }

}
