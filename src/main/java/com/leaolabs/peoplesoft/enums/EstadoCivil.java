package com.leaolabs.peoplesoft.enums;

public enum EstadoCivil {
  SOLTEIRO("SOL"),
  DIVORCIADO("DIV"),
  VIUVO("VIU"),
  CASADO("CAS");

  private final String estadoCivil;

  EstadoCivil(String valorOpcao) {
    estadoCivil = valorOpcao;
  }

  public String getValor() {
    return estadoCivil;
  }
}
