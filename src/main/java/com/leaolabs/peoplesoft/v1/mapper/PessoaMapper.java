package com.leaolabs.peoplesoft.v1.mapper;

import com.leaolabs.peoplesoft.enums.Sexo;
import com.leaolabs.peoplesoft.model.Pessoa;
import com.leaolabs.peoplesoft.v1.dtos.PessoaDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

  public PessoaDto serialize(final Pessoa pessoa) {
    if (Optional.ofNullable(pessoa).isEmpty()) {
      return new PessoaDto();
    }

    return PessoaDto.builder()
        .id(pessoa.getId())
        .uuid(pessoa.getUuid())
        .nome(pessoa.getNome())
        .cpf(pessoa.getCpf())
        .sexo(pessoa.getSexo().getValor())
        .dataCriacao(pessoa.getDataCriacao()).dataAtualizacao(pessoa.getDataAtualizacao()).build();
  }

  public List<PessoaDto> serialize(final List<Pessoa> pessoas) {
    return Optional.ofNullable(pessoas)
        .map(pessoaList -> pessoas.stream().map(this::serialize).collect(Collectors.toList())).orElse(null);
  }

  public Pessoa deserialize(final PessoaDto dto) {
    if (Optional.ofNullable(dto).isEmpty()) {
      return new Pessoa();
    }

    // Por padrao o sexo será Masculino
    if(Optional.ofNullable(dto.getSexo()).isEmpty()) {
      dto.setSexo("M");
    }

    return Pessoa.builder()
        .id(dto.getId())
        .uuid(dto.getUuid())
        .nome(dto.getNome())
        .cpf(dto.getCpf())
        .sexo(dto.getSexo().equals("M") ? Sexo.MASCULINO : Sexo.FEMININO)
        .dataCriacao(dto.getDataCriacao()).dataAtualizacao(dto.getDataAtualizacao()).build();
  }

  public List<Pessoa> deserialize(final List<PessoaDto> pessoaDtos) {
    return Optional.ofNullable(pessoaDtos)
        .map(pes -> pes.stream().map(this::deserialize).collect(Collectors.toList())).orElse(null);
  }
}
