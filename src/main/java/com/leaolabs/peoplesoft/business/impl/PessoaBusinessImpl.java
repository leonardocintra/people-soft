package com.leaolabs.peoplesoft.business.impl;

import com.leaolabs.peoplesoft.business.EnderecoBusiness;
import com.leaolabs.peoplesoft.business.PessoaBusiness;
import com.leaolabs.peoplesoft.commons.exception.EntityAlreadyExistsException;
import com.leaolabs.peoplesoft.model.Pessoa;
import com.leaolabs.peoplesoft.repository.PessoaRepository;
import com.leaolabs.peoplesoft.v1.mapper.EnderecoMapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaBusinessImpl implements PessoaBusiness {

  private PessoaRepository pessoaRepository;
  private EnderecoBusiness enderecoBusiness;
  private EnderecoMapper enderecoMapper;

  @Autowired
  public PessoaBusinessImpl(final PessoaRepository pessoaRepository,
                            final EnderecoBusiness enderecoBusiness,
                            final EnderecoMapper enderecoMapper) {
    this.pessoaRepository = pessoaRepository;
    this.enderecoBusiness = enderecoBusiness;
    this.enderecoMapper = enderecoMapper;
  }

  @Override
  public Optional<Pessoa> getByCpf(String cpf) {
    return this.pessoaRepository.findByCpf(cpf);
  }

  @Override
  public Optional<Pessoa> create(Pessoa pessoa) {
    this.pessoaRepository.findByCpf(pessoa.getCpf()).ifPresent(p -> {
      throw new EntityAlreadyExistsException("CPF");
    });

    var optionalPessoa = Optional.of(this.pessoaRepository.save(pessoa));

    Optional.ofNullable(pessoa.getEnderecos())
        .filter(enderecos -> !enderecos.isEmpty())
        .ifPresent(enderecos -> {
          final var enderecoDtos = enderecoMapper.serialize(enderecos);
          final var enderecosSalvos = enderecoBusiness.create(optionalPessoa.get().getId(), enderecoDtos);
          optionalPessoa.get().setEnderecos(enderecosSalvos);
        });

    return optionalPessoa;
  }
}
