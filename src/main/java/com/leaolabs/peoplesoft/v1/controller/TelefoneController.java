package com.leaolabs.peoplesoft.v1.controller;

import com.leaolabs.peoplesoft.business.TelefoneBusiness;
import com.leaolabs.peoplesoft.commons.controller.BaseController;
import com.leaolabs.peoplesoft.commons.controller.ResponseMeta;
import com.leaolabs.peoplesoft.model.Telefone;
import com.leaolabs.peoplesoft.utils.ValidList;
import com.leaolabs.peoplesoft.v1.dtos.TelefoneDto;
import com.leaolabs.peoplesoft.v1.mapper.TelefoneMapper;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/peoplesoft/telefone")
public class TelefoneController extends BaseController {

  private final TelefoneMapper telefoneMapper;
  private final TelefoneBusiness telefoneBusiness;

  @Autowired
  public TelefoneController(final TelefoneBusiness telefoneBusiness, final TelefoneMapper telefoneMapper) {
    super(Telefone.class);
    this.telefoneBusiness = telefoneBusiness;
    this.telefoneMapper = telefoneMapper;
  }

  @ResponseBody
  @PostMapping(value = "/pessoa/{pessoalId}")
  public ResponseEntity<ResponseMeta> post(@PathVariable final Long pessoalId, @RequestBody @Valid final ValidList<TelefoneDto> telefonesDto) {
    var telefones = this.telefoneBusiness.create(pessoalId, this.telefoneMapper.deserialize(telefonesDto));

    return super.buildResponse(HttpStatus.CREATED, Optional.of(this.telefoneMapper.serialize(telefones)));
  }
}
