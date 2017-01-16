package com.theiconic.spockexamples.bag.domain.usecases;

import com.theiconic.spockexamples.bag.domain.repositories.BagRepository;
import com.theiconic.spockexamples.bag.domain.usecases.RemoveProductFromBagUseCase;
import com.theiconic.spockexamples.common.entities.BrandEntity;
import com.theiconic.spockexamples.common.entities.ImageEntity;
import com.theiconic.spockexamples.shop.entities.CatalogProductEntity;
import com.theiconic.spockexamples.shop.entities.CategoryEntity;

import org.junit.Before;
import org.junit.Test;

import rx.Observable;
import rx.observers.TestSubscriber;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class RemoveProductFromBagUseCaseTest {


  private RemoveProductFromBagUseCase usecase;

  @Before
  public void setup(){
    usecase = new RemoveProductFromBagUseCase();
    usecase.repository = mock(BagRepository.class);
  }

  @Test
  public void execute_removesGivenProductFromTheRepository(){
    String simple = "ABC123";
    TestSubscriber<Boolean> subscriber = new TestSubscriber<>();

    Observable<Boolean> out = Observable.just(true);
    when(usecase.repository.removeItem(simple)).thenReturn(out);

    usecase.execute(simple).subscribe(subscriber);

    verify(usecase.repository,times(1)).removeItem(simple);
    assertEquals(subscriber.getOnNextEvents().size(),1);
    assertTrue(subscriber.getOnNextEvents().get(0));
    subscriber.assertNoErrors();

  }

  private CategoryEntity mockCategory(String name, String urlKey){
    CategoryEntity category = mock(CategoryEntity.class);
    when(category.getName()).thenReturn(name);
    when(category.getUrlKey()).thenReturn(urlKey);
    return category;
  }


  private CatalogProductEntity mockProduct(String sku, String name, String brandName, Double price, Double specialPrice, List<String> imageUrls){

    BrandEntity brand = mock(BrandEntity.class);
    when(brand.getName()).thenReturn(brandName);

    ArrayList<ImageEntity> images = new ArrayList<>();
    for(String imageUrl : imageUrls){
      ImageEntity imageEntity = mock(ImageEntity.class);
      when(imageEntity.getUrl()).thenReturn(imageUrl);
      images.add(imageEntity);
    }

    CatalogProductEntity product = mock(CatalogProductEntity.class);
    when(product.getImages()).thenReturn(images);
    when(product.getBrand()).thenReturn(brand);
    when(product.getSku()).thenReturn(sku);
    when(product.getName()).thenReturn(name);
    when(product.getPrice()).thenReturn(price);
    when(product.getSpecialPrice()).thenReturn(specialPrice);

    return product;
  }
}
