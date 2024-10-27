package com.naokiur;

import com.naokiur.challenge.generics.another.mycode.model.BarCurrency;
import com.naokiur.challenge.generics.another.mycode.util.MyExchanger;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello world!");
    final var myExchanger = new MyExchanger<>(new BarCurrency());

  }
}