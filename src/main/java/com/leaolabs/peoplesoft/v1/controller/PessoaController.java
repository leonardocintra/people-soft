package com.leaolabs.peoplesoft.v1.controller;

import com.leaolabs.peoplesoft.business.PessoaBusiness;
import com.leaolabs.peoplesoft.commons.controller.BaseController;
import com.leaolabs.peoplesoft.commons.controller.ResponseMeta;
import com.leaolabs.peoplesoft.commons.exception.EntityNotFoundException;
import com.leaolabs.peoplesoft.model.Pessoa;
import com.leaolabs.peoplesoft.v1.dtos.PessoaDto;
import com.leaolabs.peoplesoft.v1.mapper.PessoaMapper;

import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/peoplesoft/pessoa")
public class PessoaController extends BaseController {

  private final PessoaMapper pessoaMapper;
  private final PessoaBusiness pessoaBusiness;

  @Autowired
  public PessoaController(final PessoaBusiness pessoaBusiness, final PessoaMapper pessoaMapper) {
    super(Pessoa.class);
    this.pessoaBusiness = pessoaBusiness;
    this.pessoaMapper = pessoaMapper;
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping(value = "/{cpf}")
  @ResponseBody
  public ResponseEntity<ResponseMeta> getPessoaByCPF(@PathVariable final String cpf) {
    var pessoa = this.pessoaBusiness.getByCpf(cpf)
        .orElseThrow(() -> new EntityNotFoundException("Pessoa"));

    return super.buildResponse(HttpStatus.OK, Optional.of(this.pessoaMapper.serialize(pessoa)));
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<ResponseMeta> post(@RequestBody @Valid final PessoaDto pessoaDto) {
    var pessoa = this.pessoaBusiness.create(this.pessoaMapper.deserialize(pessoaDto))
        .orElseThrow(() -> new EntityNotFoundException("Pessoa"));

    return super.buildResponse(HttpStatus.CREATED, Optional.of(this.pessoaMapper.serialize(pessoa)));
  }
}
