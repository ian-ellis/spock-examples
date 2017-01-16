package com.theiconic.spockexamples.bag.domain.usecases

import com.theiconic.spockexamples.bag.domain.repositories.BagRepository
import com.theiconic.spockexamples.bag.domain.usecases.RemoveProductFromBagUseCase
import rx.Observable
import rx.observers.TestSubscriber
import spock.lang.Specification

class RemoveProductFromBagUseCaseSpec extends Specification{
  protected RemoveProductFromBagUseCase useCase;
  protected TestSubscriber<Boolean> subscriber;

  def setup() {
    useCase = new RemoveProductFromBagUseCase();
    useCase.repository = Mock BagRepository;
    subscriber = new TestSubscriber<>();
  }

  def 'execute() - Removes product from the repository' () {

    given:
    def simpleSku = "ABC123";
    def out = true;

    when:
    useCase.execute(simpleSku).subscribe(subscriber);

    then:
    1 * useCase.repository.removeItem(simpleSku) >> Observable.just(out);
    subscriber.onNextEvents.size() == 1;
    subscriber.onNextEvents[0] == out;
    subscriber.assertNoErrors();

  }
}