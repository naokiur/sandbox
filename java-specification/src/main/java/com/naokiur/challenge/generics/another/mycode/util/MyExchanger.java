package com.naokiur.challenge.generics.another.mycode.util;

import com.naokiur.challenge.generics.another.mycode.model.BarCurrency;
import com.naokiur.challenge.generics.another.thirdparty.model.AnonymousCurrency;

public final class MyExchanger<T extends AnonymousCurrency> {
//  private Exchange exchange = new Exchanger<T>();
public MyExchanger(T currency) {}
}
