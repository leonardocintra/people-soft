package com.leaolabs.peoplesoft.v1.mapper;

import com.leaolabs.peoplesoft.model.Telefone;
import com.leaolabs.peoplesoft.v1.dtos.TelefoneDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class TelefoneMapper {

  public TelefoneDto serialize(final Telefone telefone) {
    if (Optional.ofNullable(telefone).isEmpty()) {
      return new TelefoneDto();
    }

    return TelefoneDto.builder()
        .id(telefone.getId())
        .uuid(telefone.getUuid())
        .area(telefone.getArea())
        .numero(telefone.getNumero())
        .tipo(telefone.getTipo())
        .dataCriacao(telefone.getDataCriacao()).dataAtualizacao(telefone.getDataAtualizacao()).build();
  }

  public List<TelefoneDto> serialize(final List<Telefone> telefones) {
    return Optional.ofNullable(telefones)
        .map(tels -> telefones.stream().map(this::serialize).collect(Collectors.toList())).orElse(null);
  }

  public Telefone deserialize(final TelefoneDto dto) {
    if (Optional.ofNullable(dto).isEmpty()) {
      return new Telefone();
    }


    return Telefone.builder()
        .id(dto.getId())
        .uuid(dto.getUuid())
        .area(dto.getArea())
        .numero(dto.getNumero())
        .tipo(dto.getTipo())
        .dataCriacao(dto.getDataCriacao()).dataAtualizacao(dto.getDataAtualizacao()).build();
  }

  public List<Telefone> deserialize(final List<TelefoneDto> telefoneDtos) {
    return Optional.ofNullable(telefoneDtos).map(
        tels -> tels.stream()
            .map(this::deserialize).collect(Collectors.toList())
    ).orElse(null);
  }
}
