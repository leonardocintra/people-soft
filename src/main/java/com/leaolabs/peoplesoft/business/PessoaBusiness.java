package com.leaolabs.peoplesoft.business;

import com.leaolabs.peoplesoft.model.Pessoa;

import java.util.Optional;

public interface PessoaBusiness {
  Optional<Pessoa> getByCpf(String cpf);

  Optional<Pessoa> getById(Long id);

  Optional<Pessoa> create(Pessoa pessoa);
}
