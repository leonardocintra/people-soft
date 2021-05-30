package com.leaolabs.peoplesoft.repository;

import com.leaolabs.peoplesoft.model.Pessoa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

  @Query
  Optional<Pessoa> findByCpf(String cpf);

  @Query
  Optional<Pessoa> findByEmail(String email);
}
