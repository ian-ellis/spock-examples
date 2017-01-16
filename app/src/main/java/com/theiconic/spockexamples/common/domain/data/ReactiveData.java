package com.theiconic.spockexamples.common.domain.data;


import com.annimon.stream.Optional;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class ReactiveData<T> {

  @Getter
  private final Optional<T> value;

  @Getter
  private final Throwable error;

  public ReactiveData(T value) {
    this.value = Optional.ofNullable(value);
    this.error = null;
  }

  public ReactiveData(Throwable error) {
    this.value = Optional.empty();
    this.error = error;
  }

  public ReactiveData(T value, Throwable error) {
    this.value = Optional.ofNullable(value);
    this.error = error;
  }

  public boolean hasError() {
    return error != null;
  }

  public boolean noError() {
    return error == null;
  }
}
