package com.solucaotecnologia.CRUD_Cliente.dto;


import com.solucaotecnologia.CRUD_Cliente.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientDTO {


    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String name;

    private String cpf;

    private Double income;

    @PastOrPresent(message = "A data não pode ser futura")
    private LocalDate birthDate;

    private Integer children;

    public ClientDTO() {

    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.birthDate = client.getBirthDate();
        this.children = client.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
