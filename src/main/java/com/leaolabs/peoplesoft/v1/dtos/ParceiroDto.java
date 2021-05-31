package com.leaolabs.peoplesoft.v1.dtos;

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
public class ParceiroDto implements Serializable {

  private Long id;

  private UUID uuid;

  @NotBlank
  @Size(max = 100)
  private String nome;

  private ZonedDateTime dataCriacao;

  private ZonedDateTime dataAtualizacao;
}
