package com.leaolabs.peoplesoft.v1.mapper;

import com.leaolabs.peoplesoft.model.Parceiro;
import com.leaolabs.peoplesoft.v1.dtos.ParceiroDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParceiroMapper {

  private EnderecoMapper enderecoMapper;

  @Autowired
  public ParceiroMapper(EnderecoMapper enderecoMapper) {
    this.enderecoMapper = enderecoMapper;
  }

  public ParceiroDto serialize(final Parceiro parceiro) {
    if (Optional.ofNullable(parceiro).isEmpty()) {
      return new ParceiroDto();
    }

    return ParceiroDto.builder()
        .id(parceiro.getId())
        .uuid(parceiro.getUuid())
        .nome(parceiro.getNome())
        .dataCriacao(parceiro.getDataCriacao()).dataAtualizacao(parceiro.getDataAtualizacao()).build();
  }

  public List<ParceiroDto> serialize(final List<Parceiro> parceiros) {
    return Optional.ofNullable(parceiros)
        .map(pessoaList -> parceiros.stream().map(this::serialize).collect(Collectors.toList())).orElse(null);
  }

  public Parceiro deserialize(final ParceiroDto dto) {
    if (Optional.ofNullable(dto).isEmpty()) {
      return new Parceiro();
    }

    return Parceiro.builder()
        .id(dto.getId())
        .uuid(dto.getUuid())
        .nome(dto.getNome())
        .dataCriacao(dto.getDataCriacao()).dataAtualizacao(dto.getDataAtualizacao()).build();
  }

  public List<Parceiro> deserialize(final List<ParceiroDto> pessoaDtos) {
    return Optional.ofNullable(pessoaDtos)
        .map(pes -> pes.stream().map(this::deserialize).collect(Collectors.toList())).orElse(null);
  }
}
