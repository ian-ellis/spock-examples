package com.theiconic.spockexamples.common.domain.usecases;

import com.theiconic.spockexamples.common.domain.usecases.UseCase;

import rx.Observable;

public interface ObservableUseCase<T, R> extends UseCase<T, Observable<R>> {
}
