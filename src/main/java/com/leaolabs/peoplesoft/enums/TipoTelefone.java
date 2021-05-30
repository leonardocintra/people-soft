package com.leaolabs.peoplesoft.enums;

public enum TipoTelefone {
  MOBILE("MOBILE"),
  RESIDENCIAL("RESIDENCIAL"),
  COMERCIAL("COMERCIAL");

  private final String tipoTelefone;

  TipoTelefone(String valorOpcao) {
    tipoTelefone = valorOpcao;
  }

  public String getValor() {
    return tipoTelefone;
  }
}
