package com.theiconic.spockexamples.shop.entities;

import java.util.Collections;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.theiconic.spockexamples.common.entities.EmbeddedChildren;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor(suppressConstructorProperties = true)
public class CategoryEntity {

  @NonNull
  @SerializedName("name")
  private String name;

  @NonNull
  @SerializedName("url_key")
  private String urlKey;

  @SerializedName("_embedded")
  private EmbeddedChildren children;

  public List<CategoryEntity> getChildren() {
    if (children != null) {
      return children.getChildren();
    } else {
      return Collections.emptyList();
    }
  }

  public void addChildCategory(int index, CategoryEntity child) {
    if (children == null) {
      children = new EmbeddedChildren();
    }
    children.addCategory(index, child);

  }


}

