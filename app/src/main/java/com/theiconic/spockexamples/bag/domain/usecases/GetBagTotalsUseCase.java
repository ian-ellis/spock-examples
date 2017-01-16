package com.theiconic.spockexamples.bag.domain.usecases;

import com.theiconic.spockexamples.bag.domain.data.BagItems;
import com.theiconic.spockexamples.bag.domain.data.BagTotals;
import com.theiconic.spockexamples.bag.domain.repositories.BagRepository;
import com.theiconic.spockexamples.bag.entities.BagTotalsEntity;
import com.theiconic.spockexamples.common.domain.data.ReactiveData;
import com.theiconic.spockexamples.common.domain.usecases.ObservableUseCase;

import java.text.NumberFormat;
import java.util.Locale;

import javax.inject.Inject;

import rx.Observable;

public class GetBagTotalsUseCase implements ObservableUseCase<Void, BagTotals> {

  @Inject
  protected BagRepository bagRepository;

  @Inject
  public GetBagTotalsUseCase() {
  }

  @Override
  public Observable<BagTotals> execute(Void commandArgument) {
    return bagRepository.getItems().map(this::mapTotals);
  }

  protected BagTotals mapTotals(ReactiveData<BagItems> items) {
    BagTotalsEntity entity = items.getValue().get().getTotals();
    if (entity == null) {
      entity = new BagTotalsEntity();
    }
    String discount = "A"+ NumberFormat.getCurrencyInstance(Locale.US).format(entity.getDiscountTotal());
    String tax = "A"+NumberFormat.getCurrencyInstance(Locale.US).format(entity.getTax());
    String creditTotal = "A"+NumberFormat.getCurrencyInstance(Locale.US).format(entity.getCreditTotal());
    String subTotal = "A"+NumberFormat.getCurrencyInstance(Locale.US).format(entity.getSubtotal());
    String shipping = "A"+NumberFormat.getCurrencyInstance(Locale.US).format(entity.getShipping());
    String total = "A"+NumberFormat.getCurrencyInstance(Locale.US).format(entity.getTotal());

    int numItems = items.getValue().get().getNumItems();

    return new BagTotals(discount, tax, creditTotal, subTotal, shipping, total, numItems);


  }
}
