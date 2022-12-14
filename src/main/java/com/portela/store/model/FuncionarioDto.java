package com.portela.store.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * A DTO for the {@link Funcionario} entity
 */
@Data
public class FuncionarioDto implements Serializable {
    private final String nome;
    private final Double salarioBruto;
    private final Date dataEntrada;
    private final Date dataSaida;
    private final String cargo;
    private final String cidade;
    private final String logradouro;
    private final String numero;
    private final String complemento;
    private final String bairro;
    private final String uf;
    private final String cep;
}