package com.leaolabs.peoplesoft.v1.mapper;

import com.leaolabs.peoplesoft.model.Endereco;
import com.leaolabs.peoplesoft.v1.dtos.EnderecoDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

  public EnderecoDto serialize(final Endereco endereco) {
    if (Optional.ofNullable(endereco).isEmpty()) {
      return new EnderecoDto();
    }

    return EnderecoDto.builder()
        .id(endereco.getId())
        .uuid(endereco.getUuid())
        .endereco(endereco.getEndereco())
        .bairro(endereco.getBairro())
        .cidade(endereco.getCidade())
        .numero(endereco.getNumero())
        .uf(endereco.getUf())
        .cep(endereco.getCep())
        .complemento(endereco.getComplemento())
        .referencia(endereco.getReferencia())
        .dataCriacao(endereco.getDataCriacao()).dataAtualizacao(endereco.getDataAtualizacao()).build();
  }

  public List<EnderecoDto> serialize(final List<Endereco> enderecos) {
    return Optional.ofNullable(enderecos)
        .map(enderecoList -> enderecos.stream().map(this::serialize).collect(Collectors.toList())).orElse(null);
  }

  public Endereco deserialize(final EnderecoDto dto) {
    if (Optional.ofNullable(dto).isEmpty()) {
      return new Endereco();
    }


    return Endereco.builder()
        .id(dto.getId())
        .uuid(dto.getUuid())
        .endereco(dto.getEndereco())
        .bairro(dto.getBairro())
        .cidade(dto.getCidade())
        .numero(dto.getNumero())
        .uf(dto.getUf())
        .cep(dto.getCep())
        .complemento(dto.getComplemento())
        .referencia(dto.getReferencia())
        .dataCriacao(dto.getDataCriacao()).dataAtualizacao(dto.getDataAtualizacao()).build();
  }

  public List<Endereco> deserialize(final List<EnderecoDto> addressesDto) {
    return Optional.ofNullable(addressesDto).map(
        address -> address.stream()
            .map(this::deserialize).collect(Collectors.toList())
    ).orElse(null);
  }
}
