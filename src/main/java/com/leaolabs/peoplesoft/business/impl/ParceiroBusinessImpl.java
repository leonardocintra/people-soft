package com.leaolabs.peoplesoft.business.impl;

import com.leaolabs.peoplesoft.business.EnderecoBusiness;
import com.leaolabs.peoplesoft.business.ParceiroBusiness;
import com.leaolabs.peoplesoft.business.PessoaBusiness;
import com.leaolabs.peoplesoft.commons.exception.EntityAlreadyExistsException;
import com.leaolabs.peoplesoft.model.Parceiro;
import com.leaolabs.peoplesoft.model.Pessoa;
import com.leaolabs.peoplesoft.repository.ParceiroRepository;
import com.leaolabs.peoplesoft.repository.PessoaRepository;
import com.leaolabs.peoplesoft.v1.mapper.EnderecoMapper;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParceiroBusinessImpl implements ParceiroBusiness {

  private ParceiroRepository parceiroRepository;

  @Autowired
  public ParceiroBusinessImpl(final ParceiroRepository parceiroRepository) {
    this.parceiroRepository = parceiroRepository;
  }


  @Override
  public Optional<Parceiro> create(Parceiro parceiro) {
    return Optional.ofNullable(this.parceiroRepository.save(parceiro));
  }
}
