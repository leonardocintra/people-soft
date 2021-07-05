package com.leaolabs.peoplesoft.model;

import com.leaolabs.peoplesoft.enums.EstadoCivil;
import com.leaolabs.peoplesoft.enums.Sexo;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "pessoa")
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Type(type = "uuid-char")
  @Column(nullable = false)
  private UUID uuid;

  private String nome;

  private String cpf;

  @Column(name = "data_nascimento")
  private Date dataNascimento;

  private Sexo sexo;

  private String email;

  @Column(name = "estado_civil")
  private EstadoCivil estadoCivil;

  @Column(name = "data_criacao")
  private ZonedDateTime dataCriacao;

  @Column(name = "data_atualizacao")
  private ZonedDateTime dataAtualizacao;

  @OneToMany(mappedBy = "pessoa")
  private List<Endereco> enderecos;

  @OneToMany(mappedBy = "pessoa")
  private List<Telefone> telefones;


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
