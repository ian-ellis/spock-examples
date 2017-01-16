package com.theiconic.spockexamples.common.entities;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NonNull;

@Data
public class RibbonEntity {

  @NonNull
  @SerializedName("type")
  private String type;

  @NonNull
  @SerializedName("name")
  private String name;

  @SerializedName("content")
  private String content;

  @SerializedName("tagline")
  private String tagline;

  @SerializedName("slug")
  private String slug;

  @SerializedName("color")
  private String color;
}

