package com.naokiur.challenge.generics.thirdparty.service;

import com.naokiur.challenge.generics.thirdparty.model.AnonymousCurrency;

public class Exchanger implements Exchange<AnonymousCurrency> {

  @Override
  public Integer execute(AnonymousCurrency current, Integer sumAmount) {
    return 0;
  }
}
