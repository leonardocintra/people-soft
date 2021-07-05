package com.leaolabs.peoplesoft.business;

import com.leaolabs.peoplesoft.model.Telefone;
import com.leaolabs.peoplesoft.v1.dtos.TelefoneDto;

import java.util.List;

public interface TelefoneBusiness {
  List<Telefone> create(Long pessoaId, List<Telefone> telefones);
}
