package com.solucaotecnologia.CRUD_Cliente.repositories;

import com.solucaotecnologia.CRUD_Cliente.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
