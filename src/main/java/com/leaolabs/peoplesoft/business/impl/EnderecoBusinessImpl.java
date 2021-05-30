package com.leaolabs.peoplesoft.business.impl;

import com.leaolabs.peoplesoft.business.EnderecoBusiness;
import com.leaolabs.peoplesoft.commons.exception.EntityNotFoundException;
import com.leaolabs.peoplesoft.model.Endereco;
import com.leaolabs.peoplesoft.repository.EnderecoRepository;
import com.leaolabs.peoplesoft.repository.PessoaRepository;
import com.leaolabs.peoplesoft.v1.dtos.EnderecoDto;
import com.leaolabs.peoplesoft.v1.mapper.EnderecoMapper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoBusinessImpl implements EnderecoBusiness {

  private PessoaRepository pessoaRepository;
  private EnderecoRepository enderecoRepository;
  private EnderecoMapper enderecoMapper;

  @Autowired
  public EnderecoBusinessImpl(final EnderecoRepository enderecoRepository, final PessoaRepository pessoaRepository, final EnderecoMapper enderecoMapper) {
    this.enderecoRepository = enderecoRepository;
    this.pessoaRepository = pessoaRepository;
    this.enderecoMapper = enderecoMapper;
  }

  @Override
  public List<Endereco> create(Long pessoaId, List<EnderecoDto> enderecoDtos) {
    final var pessoa = pessoaRepository.findById(pessoaId).orElseThrow(() -> new EntityNotFoundException("Pessoa"));

    final var enderecosToSave = this.enderecoMapper.deserialize(enderecoDtos);

    enderecosToSave.forEach(endereco -> endereco.setPessoa(pessoa));

    return this.enderecoRepository.saveAll(enderecosToSave);
  }
}
