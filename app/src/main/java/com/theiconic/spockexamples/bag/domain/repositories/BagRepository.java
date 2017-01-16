package com.theiconic.spockexamples.bag.domain.repositories;

import com.theiconic.spockexamples.common.domain.data.ReactiveData;
import com.theiconic.spockexamples.bag.domain.data.BagItems;

import rx.Observable;

public class BagRepository {

  public Observable<Boolean> removeItem(String string) {
    return Observable.never();
  }

  public Observable<ReactiveData<BagItems>> getItems() {
    return Observable.never();
  }
}
