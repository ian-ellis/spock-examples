package com.theiconic.spockexamples.shop.entities;

import com.google.gson.annotations.SerializedName;
import com.theiconic.spockexamples.common.entities.BrandEntity;
import com.theiconic.spockexamples.common.entities.GenderEntity;
import com.theiconic.spockexamples.common.entities.ImageEntity;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor(suppressConstructorProperties = true)
public class CatalogProductEntity {

  @NonNull
  @SerializedName("sku")
  private String sku;

  @NonNull
  @SerializedName("name")
  private String name;

  @NonNull
  @SerializedName("short_description")
  private String shortDescription;

  @SerializedName("price")
  private double price;

  @SerializedName("special_price")
  private double specialPrice;

  @SerializedName("_embedded")
  private Embedded embedded;

  public BrandEntity getBrand(){
    return embedded.getBrand();
  }

  public GenderEntity getGender(){
    return embedded.getGender();
  }

  public List<ShopEntity> getShops(){
    if(embedded.getShops() != null){
      return embedded.getShops();
    }else{
      return Collections.emptyList();
    }
  }

  public List<ImageEntity> getImages(){
    if(embedded.getImages() != null){
      return embedded.getImages();
    }else{
      return Collections.emptyList();
    }
  }

  @Getter
  private static class Embedded{

    @SerializedName("brand")
    private BrandEntity brand;

    @SerializedName("gender")
    private GenderEntity gender;

    @SerializedName("shops")
    private List<ShopEntity> shops;

    @SerializedName("images")
    private List<ImageEntity> images;
  }
}
