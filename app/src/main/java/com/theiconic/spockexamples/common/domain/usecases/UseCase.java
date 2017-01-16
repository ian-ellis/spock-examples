package com.theiconic.spockexamples.common.domain.usecases;


public interface UseCase<T, R> {
  R execute(T commandArgument);
}
