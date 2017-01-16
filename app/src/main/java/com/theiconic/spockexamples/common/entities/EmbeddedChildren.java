package com.theiconic.spockexamples.common.entities;

import com.google.gson.annotations.SerializedName;
import com.theiconic.spockexamples.shop.entities.CategoryEntity;

import java.util.ArrayList;
import lombok.Data;

@Data
public class EmbeddedChildren {

  @SerializedName("children")
  private ArrayList<CategoryEntity> children;

  public void addCategory(int index, CategoryEntity child) {
    if (children == null) {
      children = new ArrayList<>();
    }
    children.add(index, child);
  }
}
