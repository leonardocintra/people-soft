package com.leaolabs.peoplesoft.v1.dtos;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class TelefoneDto implements Serializable {

  private Long id;

  private UUID uuid;

  @NotBlank
  @Min(value = 1)
  @Max(value = 99)
  @Size(max = 3)
  private String area;

  @NotBlank
  @Size(max = 10)
  @Min(value = 1000000)
  @Max(value = 999999999)
  private String numero;

  @NotBlank
  @Size(max = 10)
  private String tipo;

  private ZonedDateTime dataCriacao;

  private ZonedDateTime dataAtualizacao;
}
