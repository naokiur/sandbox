package com.naokiur.challenge.generics.mycode.util;

import com.naokiur.challenge.generics.mycode.model.BarCurrency;
import com.naokiur.challenge.generics.thirdparty.model.AnonymousCurrency;

public final class MyExchanger<T extends AnonymousCurrency> {
//  private Exchange exchange = new Exchanger<T>();
public MyExchanger(T currency) {}
}
