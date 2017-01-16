package com.theiconic.spockexamples.bag.domain.data;

import com.theiconic.spockexamples.bag.entities.BagItemEntity;
import com.theiconic.spockexamples.bag.entities.BagTotalsEntity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class BagItems {

  public BagItems(){
  }

  protected List<BagItemEntity> items = new ArrayList<>();
  @Setter
  protected BagTotalsEntity totals = new BagTotalsEntity();

  protected int numItems;
}

