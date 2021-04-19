package com.leaolabs.peoplesoft.business.impl;

import com.leaolabs.peoplesoft.business.PessoaBusiness;
import com.leaolabs.peoplesoft.model.Pessoa;
import com.leaolabs.peoplesoft.repository.PessoaRepository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaBusinessImpl implements PessoaBusiness {

  private PessoaRepository pessoaRepository;

  @Autowired
  public PessoaBusinessImpl(final PessoaRepository pessoaRepository) {
    this.pessoaRepository = pessoaRepository;
  }

  @Override
  public Optional<Pessoa> getByCpf(String cpf) {
    return this.pessoaRepository.findByCpf(cpf);
  }

  @Override
  public Optional<Pessoa> create(Pessoa pessoa) {
    //TODO: precisa verificar se CPF ja existe
    return Optional.of(this.pessoaRepository.save(pessoa));
  }
}
