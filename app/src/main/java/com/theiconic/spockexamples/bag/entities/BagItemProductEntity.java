package com.theiconic.spockexamples.bag.entities;


import com.google.gson.annotations.SerializedName;
import com.theiconic.spockexamples.common.entities.BrandEntity;
import com.theiconic.spockexamples.common.entities.GenderEntity;
import com.theiconic.spockexamples.common.entities.ImageEntity;
import com.theiconic.spockexamples.shop.entities.ProductAttributes;
import com.theiconic.spockexamples.common.entities.RibbonEntity;
import com.theiconic.spockexamples.shop.entities.ShopEntity;
import com.theiconic.spockexamples.common.entities.SimpleEntity;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class BagItemProductEntity {
  @NonNull
  @SerializedName("sku")
  private String sku;

  @NonNull
  @SerializedName("name")
  private String name;

  @NonNull
  @SerializedName("short_description")
  private String description;

  @SerializedName("ribbon_details")
  private RibbonEntity ribbon = null;

  @NonNull
  @SerializedName("color_name_brand")
  private String colorNameBrand = null;

  @NonNull
  @SerializedName("shipment_type")
  private String shipmentType = null;

  @SerializedName("price")
  private double price = -1.0;

  @SerializedName("brand")
  private BrandEntity brand;

  @SerializedName("gender")
  private GenderEntity gender;

  @SerializedName("images")
  private List<ImageEntity> images;

  @SerializedName("shops")
  private List<ShopEntity> shops;

  @SerializedName("simples")
  private List<SimpleEntity> simples;

  @SerializedName("attributes")
  private ProductAttributes attributes = null;
}
