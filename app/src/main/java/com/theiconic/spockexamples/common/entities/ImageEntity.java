package com.theiconic.spockexamples.common.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(suppressConstructorProperties = true)
public class ImageEntity {


  private String url;
}
