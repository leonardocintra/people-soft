package com.leaolabs.peoplesoft.business.impl;

import com.leaolabs.peoplesoft.business.TelefoneBusiness;
import com.leaolabs.peoplesoft.commons.exception.EntityNotFoundException;
import com.leaolabs.peoplesoft.model.Telefone;
import com.leaolabs.peoplesoft.repository.PessoaRepository;
import com.leaolabs.peoplesoft.repository.TelefoneRepository;
import com.leaolabs.peoplesoft.v1.dtos.TelefoneDto;
import com.leaolabs.peoplesoft.v1.mapper.TelefoneMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneBusinessImpl implements TelefoneBusiness {

  private PessoaRepository pessoaRepository;
  private TelefoneRepository telefoneRepository;
  private TelefoneMapper telefoneMapper;

  @Autowired
  public TelefoneBusinessImpl(final TelefoneRepository telefoneRepository,
                              final PessoaRepository pessoaRepository,
                              final TelefoneMapper telefoneMapper) {
    this.telefoneRepository = telefoneRepository;
    this.pessoaRepository = pessoaRepository;
    this.telefoneMapper = telefoneMapper;
  }

  @Override
  public List<Telefone> create(Long pessoaId, List<Telefone> telefones) {
    final var pessoa = pessoaRepository.findById(pessoaId)
        .orElseThrow(() -> new EntityNotFoundException("Pessoa"));

    telefones.forEach(tel -> tel.setPessoa(pessoa));

    return this.telefoneRepository.saveAll(telefones);
  }
}
