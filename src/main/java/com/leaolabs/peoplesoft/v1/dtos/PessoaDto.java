package com.leaolabs.peoplesoft.v1.dtos;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;
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

  @NotBlank
  private UUID uuid;

  @NotBlank
  @Size(max = 100)
  private String nome;

  @NotBlank
  @Size(max = 11)
  private String cpf;

  @NotBlank
  private ZonedDateTime dataCriacao;

  @NotBlank
  private ZonedDateTime dataAtualizacao;
}
