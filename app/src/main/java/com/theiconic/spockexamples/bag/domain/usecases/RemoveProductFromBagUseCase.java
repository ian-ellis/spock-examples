package com.theiconic.spockexamples.bag.domain.usecases;

import com.theiconic.spockexamples.common.domain.usecases.ObservableUseCase;
import com.theiconic.spockexamples.bag.domain.repositories.BagRepository;

import javax.inject.Inject;

import rx.Observable;

public class RemoveProductFromBagUseCase implements ObservableUseCase<String, Boolean> {

  @Inject
  protected BagRepository repository;

  @Inject
  public RemoveProductFromBagUseCase() {
  }

  @Override
  public Observable<Boolean> execute(final String simpleSku) {
    return repository.removeItem(simpleSku);
  }

}

