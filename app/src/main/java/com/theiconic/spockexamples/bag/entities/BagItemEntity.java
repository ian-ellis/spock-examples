package com.theiconic.spockexamples.bag.entities;

import com.google.gson.annotations.SerializedName;
import com.theiconic.spockexamples.common.entities.CartPriceRulesEntity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BagItemEntity {

  @SerializedName("sku")
  private String sku;

  @SerializedName("name")
  private String name;

  @SerializedName("paid_price")
  private double paidPrice;

  @SerializedName("special_price")
  private double specialPrice;

  @SerializedName("tax_amount")
  private double taxAmount;

  @SerializedName("unit_price")
  private double unitPrice;

  @SerializedName("original_unit_price")
  private double originalUnitPrice;

  @SerializedName("quantity")
  private int quantity;

  @SerializedName("is_returnable")
  private boolean returnable;

  @SerializedName("tax_percent")
  private double taxPercent;

  @SerializedName("product")
  private BagItemProductEntity product;

  @SerializedName("cart_price_rules")
  private List<CartPriceRulesEntity> cartPriceRules = null;
}

