package com.leaolabs.peoplesoft.business;

import com.leaolabs.peoplesoft.model.Endereco;
import com.leaolabs.peoplesoft.v1.dtos.EnderecoDto;

import java.util.List;
import java.util.Optional;

public interface EnderecoBusiness {
  List<Endereco> create(Long pessoaId, List<Endereco> enderecoDtos);
}
