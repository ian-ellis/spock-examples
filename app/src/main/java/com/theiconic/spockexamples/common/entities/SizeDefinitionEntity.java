package com.theiconic.spockexamples.common.entities;


import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public class SizeDefinitionEntity {
  private static final int SIZE_LIMIT = 3;
  @NonNull
  @SerializedName("original")
  private Size original;

  @NonNull
  @SerializedName("universal")
  private Size universal;

  public boolean equalSizes() {
    return universal == null
        || original.getSystem().equals(universal.getSystem())
        && original.getSize().length() > SIZE_LIMIT
        && universal.getSize().length() > SIZE_LIMIT
        && original.getSize().substring(0, SIZE_LIMIT).equals(universal.getSize().substring(0, SIZE_LIMIT));
  }

  @Getter
  @AllArgsConstructor
  public class Size {

    @NonNull
    @SerializedName("size")
    private String size;

    @NonNull
    @SerializedName("system")
    private String system;
  }
}
