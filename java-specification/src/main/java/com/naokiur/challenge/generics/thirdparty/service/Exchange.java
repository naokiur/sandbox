package com.naokiur.challenge.generics.thirdparty.service;

import com.naokiur.challenge.generics.thirdparty.model.AnonymousCurrency;

public interface Exchange<T extends AnonymousCurrency> {
  Integer execute(T current, Integer sumAmount);
}
