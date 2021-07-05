package com.leaolabs.peoplesoft.business.impl;

import com.leaolabs.peoplesoft.business.EnderecoBusiness;
import com.leaolabs.peoplesoft.business.PessoaBusiness;
import com.leaolabs.peoplesoft.business.TelefoneBusiness;
import com.leaolabs.peoplesoft.commons.exception.EntityAlreadyExistsException;
import com.leaolabs.peoplesoft.model.Pessoa;
import com.leaolabs.peoplesoft.repository.PessoaRepository;
import com.leaolabs.peoplesoft.v1.mapper.EnderecoMapper;
import com.leaolabs.peoplesoft.v1.mapper.TelefoneMapper;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaBusinessImpl implements PessoaBusiness {

  private PessoaRepository pessoaRepository;
  private EnderecoBusiness enderecoBusiness;
  private EnderecoMapper enderecoMapper;
  private TelefoneBusiness telefoneBusiness;
  private TelefoneMapper telefoneMapper;

  @Autowired
  public PessoaBusinessImpl(final PessoaRepository pessoaRepository,
                            final EnderecoBusiness enderecoBusiness,
                            final EnderecoMapper enderecoMapper,
                            final TelefoneMapper telefoneMapper,
                            final TelefoneBusiness telefoneBusiness) {
    this.pessoaRepository = pessoaRepository;
    this.enderecoBusiness = enderecoBusiness;
    this.enderecoMapper = enderecoMapper;
    this.telefoneMapper = telefoneMapper;
    this.telefoneBusiness = telefoneBusiness;
  }

  @Override
  public Optional<Pessoa> getByCpf(final String cpf) {
    return this.pessoaRepository.findByCpf(cpf);
  }

  @Override
  public Optional<Pessoa> getById(final Long id) {
    return this.pessoaRepository.findById(id);
  }

  @Override
  public Optional<Pessoa> create(Pessoa pessoa) {
    this.pessoaRepository.findByCpf(pessoa.getCpf()).ifPresent(p -> {
      throw new EntityAlreadyExistsException("CPF");
    });

    pessoa.setEmail(pessoa.getEmail().toLowerCase(Locale.ROOT));
    this.pessoaRepository.findByEmail(pessoa.getEmail()).ifPresent(e -> {
      throw new EntityAlreadyExistsException("Email");
    });

    var optionalPessoa = Optional.of(this.pessoaRepository.save(pessoa));

    Optional.ofNullable(pessoa.getEnderecos())
        .filter(enderecos -> !enderecos.isEmpty())
        .ifPresent(enderecos -> {
          final var enderecoDtos = enderecoMapper.serialize(enderecos);
          final var enderecosSalvos = enderecoBusiness.create(
              optionalPessoa.get().getId(), this.enderecoMapper.deserialize(enderecoDtos));
          optionalPessoa.get().setEnderecos(enderecosSalvos);
        });

    Optional.ofNullable(pessoa.getTelefones())
        .filter(telefones -> !telefones.isEmpty())
        .ifPresent(telefones -> {
          final var telefoneDtos = telefoneMapper.serialize(telefones);
          final var telefoneSalvos = telefoneBusiness.create(
              optionalPessoa.get().getId(), this.telefoneMapper.deserialize(telefoneDtos));
          optionalPessoa.get().setTelefones(telefoneSalvos);
        });

    return optionalPessoa;
  }
}
