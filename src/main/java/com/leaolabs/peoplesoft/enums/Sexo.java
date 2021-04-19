package com.leaolabs.peoplesoft.enums;

public enum Sexo {
  MASCULINO("M"),
  FEMININO("F");

  private final String sexo;

  Sexo(String valorOpcao) {
    sexo = valorOpcao;
  }

  public String getValor() {
    return sexo;
  }
}
