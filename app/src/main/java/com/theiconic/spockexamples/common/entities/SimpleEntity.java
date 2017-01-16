package com.theiconic.spockexamples.common.entities;


import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NonNull;

@Data
public class SimpleEntity {

  @NonNull
  @SerializedName("sku")
  private String sku;

  @SerializedName("price")
  private double price = 0.0;

  @SerializedName("tax_percent")
  private double taxPercent = 0.0;

  @SerializedName("quantity")
  private int quantity = 0;

  @SerializedName("quantity_syd1")
  private int quantitySydney = 0;

  @SerializedName("quantity_mel1")
  private int quantityMelbourne = 0;

  @NonNull
  @SerializedName("dispatch_time")
  private String dispatchTime;

  @NonNull
  @SerializedName("dispatch_time_code")
  private String dispatchTimeCode;

  @SerializedName("item_in_cart")
  private boolean itemInCart;

  @SerializedName("item_in_wishlist")
  private boolean itemInWishlist;

  @NonNull
  @SerializedName("size_definition")
  private SizeDefinitionEntity sizeDefinitionEntity;
}
