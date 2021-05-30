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
public class EnderecoDto implements Serializable {

  private Long id;

  @NotBlank
  private UUID uuid;

  @NotBlank
  @Size(max = 100)
  private String endereco;

  @NotBlank
  @Size(max = 100)
  private String bairro;

  @NotBlank
  @Size(max = 100)
  private String cidade;

  @Size(max = 10)
  private String numero;

  @NotBlank
  @Size(max = 2)
  private String uf;

  @NotBlank
  @Size(max = 8)
  private String cep;

  @Size(max = 100)
  private String complemento;

  @Size(max = 300)
  private String referencia;

  @NotBlank
  private ZonedDateTime dataCriacao;

  @NotBlank
  private ZonedDateTime dataAtualizacao;
}
