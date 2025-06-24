package com.naokiur.challenge.generics.another.thirdparty.service;

import com.naokiur.challenge.generics.another.thirdparty.model.AnonymousCurrency;

public interface Exchange<T extends AnonymousCurrency> {
  Integer execute(T current, Integer sumAmount);
}
