package com.leaolabs.peoplesoft.business;

import com.leaolabs.peoplesoft.model.Parceiro;

import java.util.Optional;

public interface ParceiroBusiness {
  Optional<Parceiro> create(Parceiro parceiro);
}
