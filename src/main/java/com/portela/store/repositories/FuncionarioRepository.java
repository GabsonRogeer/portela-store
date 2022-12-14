package com.portela.store.repositories;

import com.portela.store.model.Funcionario;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
