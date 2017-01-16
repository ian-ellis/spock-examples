package com.theiconic.spockexamples.bag.entities;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BagTotalsEntity {
  public BagTotalsEntity(){
  }

  @SerializedName("discount_total")
  private double discountTotal;

  @SerializedName("tax_total")
  private double tax;

  @SerializedName("credit_total")
  private double creditTotal;

  @SerializedName("sub_total")
  private double subtotal;

  @SerializedName("shipping_total")
  private double shipping;

  @SerializedName("grand_total")
  private double total;
}

