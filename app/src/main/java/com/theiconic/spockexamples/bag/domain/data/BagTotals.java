package com.theiconic.spockexamples.bag.domain.data;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BagTotals {
  private String discountTotal;
  private String tax;
  private String creditTotal;
  private String subtotal;
  private String shipping;
  private String total;
  private int numItems;
}
