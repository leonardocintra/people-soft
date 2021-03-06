package com.leaolabs.peoplesoft.v1.mapper;

import com.leaolabs.peoplesoft.enums.Sexo;
import com.leaolabs.peoplesoft.model.Pessoa;
import com.leaolabs.peoplesoft.v1.dtos.PessoaDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

  private EnderecoMapper enderecoMapper;
  private TelefoneMapper telefoneMapper;

  @Autowired
  public PessoaMapper(EnderecoMapper enderecoMapper, TelefoneMapper telefoneMapper) {
    this.enderecoMapper = enderecoMapper;
    this.telefoneMapper = telefoneMapper;
  }

  public PessoaDto serialize(final Pessoa pessoa) {
    if (Optional.ofNullable(pessoa).isEmpty()) {
      return new PessoaDto();
    }

    return PessoaDto.builder()
        .id(pessoa.getId())
        .uuid(pessoa.getUuid())
        .nome(pessoa.getNome())
        .sobrenome((pessoa.getSobrenome()))
        .cpf(pessoa.getCpf())
        .email(pessoa.getEmail())
        .sexo(pessoa.getSexo().getValor())
        .enderecos(enderecoMapper.serialize(pessoa.getEnderecos()))
        .telefones(telefoneMapper.serialize(pessoa.getTelefones()))
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
        .sobrenome(dto.getSobrenome())
        .cpf(dto.getCpf())
        .email(dto.getEmail())
        .sexo(dto.getSexo().equals("M") ? Sexo.MASCULINO : Sexo.FEMININO)
        .enderecos(enderecoMapper.deserialize(dto.getEnderecos()))
        .telefones(telefoneMapper.deserialize(dto.getTelefones()))
        .dataCriacao(dto.getDataCriacao()).dataAtualizacao(dto.getDataAtualizacao()).build();
  }

  public List<Pessoa> deserialize(final List<PessoaDto> pessoaDtos) {
    return Optional.ofNullable(pessoaDtos)
        .map(pes -> pes.stream().map(this::deserialize).collect(Collectors.toList())).orElse(null);
  }
}
