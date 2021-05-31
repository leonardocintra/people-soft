package com.leaolabs.peoplesoft.v1.controller;

import com.leaolabs.peoplesoft.business.ParceiroBusiness;
import com.leaolabs.peoplesoft.commons.controller.BaseController;
import com.leaolabs.peoplesoft.commons.controller.ResponseMeta;
import com.leaolabs.peoplesoft.commons.exception.EntityNotFoundException;
import com.leaolabs.peoplesoft.model.Parceiro;
import com.leaolabs.peoplesoft.v1.dtos.ParceiroDto;
import com.leaolabs.peoplesoft.v1.mapper.ParceiroMapper;

import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/peoplesoft/parceiro")
public class ParceiroController extends BaseController {

  private final ParceiroMapper parceiroMapper;
  private final ParceiroBusiness parceiroBusiness;

  @Autowired
  public ParceiroController(final ParceiroBusiness parceiroBusiness, final ParceiroMapper parceiroMapper) {
    super(Parceiro.class);
    this.parceiroBusiness = parceiroBusiness;
    this.parceiroMapper = parceiroMapper;
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<ResponseMeta> post(@RequestBody @Valid final ParceiroDto parceiroDto) {
    var parceiro = this.parceiroBusiness.create(this.parceiroMapper.deserialize(parceiroDto))
        .orElseThrow(() -> new EntityNotFoundException("Parceiro"));

    return super.buildResponse(HttpStatus.CREATED, Optional.of(this.parceiroMapper.serialize(parceiro)));
  }
}
