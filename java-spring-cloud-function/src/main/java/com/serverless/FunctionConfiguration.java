package com.serverless;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.cloud.function.context.catalog.FunctionTypeUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class FunctionConfiguration implements
    ApplicationContextInitializer<GenericApplicationContext> {

  public static void main(String[] args) {
//    SpringApplication.run(FunctionConfiguration.class, args);
  }


  @Override
  public void initialize(GenericApplicationContext context) {
    Function<String, String> function = String::toUpperCase;

    context.registerBean("uppercase", FunctionRegistration.class,
        () -> new FunctionRegistration<>(function).type(
            FunctionType.from(String.class).to(String.class)));
  }
}