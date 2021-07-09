package com.leaolabs.peoplesoft.v1.dtos;

import com.leaolabs.peoplesoft.model.Telefone;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto implements Serializable {

  private Long id;

  private UUID uuid;

  @NotBlank
  @Size(max = 100)
  private String nome;
  
  @Size(max = 100)
  private String sobrenome;

  @NotBlank
  @Size(max = 11)
  private String cpf;

  @Size(max = 1)
  private String sexo;

  @Email
  @NotBlank
  private String email;

  @Valid
  private List<EnderecoDto> enderecos;

  @Valid
  private List<TelefoneDto> telefones;

  private ZonedDateTime dataCriacao;

  private ZonedDateTime dataAtualizacao;
}
