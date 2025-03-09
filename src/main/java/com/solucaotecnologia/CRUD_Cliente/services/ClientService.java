package com.solucaotecnologia.CRUD_Cliente.services;

import com.solucaotecnologia.CRUD_Cliente.dto.ClientDTO;
import com.solucaotecnologia.CRUD_Cliente.entities.Client;
import com.solucaotecnologia.CRUD_Cliente.repositories.ClientRepository;
import com.solucaotecnologia.CRUD_Cliente.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        Client client = result.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findallPaged(Pageable pageable) {
        Page<Client> list = clientRepository.findAll(pageable);
        return list.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client client = new Client(dto);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client client = clientRepository.getReferenceById(id);
            client.setName(dto.getName());
            client.setCpf(dto.getCpf());
            client.setIncome(dto.getIncome());
            client.setBirthDate(dto.getBirthDate());
            client.setChildren(dto.getChildren());
            client = clientRepository.save(client);
            return new ClientDTO(client);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

}
