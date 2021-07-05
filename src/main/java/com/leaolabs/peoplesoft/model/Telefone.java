package com.leaolabs.peoplesoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "telefone")
public class Telefone {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Type(type = "uuid-char")
  @Column(nullable = false)
  private UUID uuid;

  private String area;

  private String numero;

  private String tipo;

  @JsonIgnore
  @ManyToOne(optional = false)
  @JoinColumn(name = "pessoa_id")
  private Pessoa pessoa;

  @Column(name = "data_criacao")
  private ZonedDateTime dataCriacao;

  @Column(name = "data_atualizacao")
  private ZonedDateTime dataAtualizacao;

  @PrePersist
  protected void prePersist() {
    dataCriacao = dataAtualizacao = ZonedDateTime.now();
    uuid = UUID.randomUUID();
  }

  @PreUpdate
  protected void preUpdate() {
    dataAtualizacao = ZonedDateTime.now();
  }

}
