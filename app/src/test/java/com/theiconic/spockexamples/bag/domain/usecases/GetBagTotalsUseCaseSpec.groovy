package com.theiconic.spockexamples.bag.domain.usecases

import com.theiconic.spockexamples.bag.domain.data.BagTotals
import com.theiconic.spockexamples.common.domain.data.ReactiveData
import rx.Observable
import rx.observers.TestSubscriber
import spock.lang.Specification

class GetBagTotalsUseCaseSpec extends Specification {
  private GetBagTotalsUseCase useCase;

  def setup() {
    useCase = new GetBagTotalsUseCase();
    useCase.bagRepository = Mock(BagRepository)
  }

  def 'execute() - maps BagItems to BagTotals'() {
    given:
    def totals = Mock(BagTotalsEntity) {
      it.getDiscountTotal() >> 0.00d
      it.getTax() >> 34.89d
      it.getCreditTotal() >> 98.08d
      it.getSubtotal() >> 89.0d
      it.getShipping() >> 2355.1d
      it.getTotal() >> 7678953.98d
    }

    def items = Mock(BagItems) {
      it.getTotals() >> totals
    }

    def reactiveItems = new ReactiveData(items)

    useCase.bagRepository.getItems() >> Observable.just(reactiveItems)
    def subscriber = new TestSubscriber<BagTotals>()

    when:
    useCase.execute(null).subscribe(subscriber)

    then:
    subscriber.onNextEvents.size() == 1
    BagTotals bagTotals = subscriber.onNextEvents.first()
    bagTotals.discountTotal == "A\$0.00"
    bagTotals.tax == "A\$34.89"
    bagTotals.creditTotal == "A\$98.08"
    bagTotals.subtotal == "A\$89.00"
    bagTotals.shipping == "A\$2,355.10"
    bagTotals.total == "A\$7,678,953.98"

  }

}