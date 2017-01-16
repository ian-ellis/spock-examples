package com.theiconic.spockexamples.common.domain.usecases

import com.theiconic.spockexamples.common.domain.usecases.ValidateEmailUseCase
import spock.lang.Specification
import spock.lang.Unroll

class ValidEmailUseCaseSpec extends Specification {

  ValidateEmailUseCase useCase;

  def setup() {
    useCase = new ValidateEmailUseCase();
  }

  @Unroll
  def 'execute() - validates email: #email returns #valid'() {
    when:
    def result = useCase.execute(email);
    then:
    result == valid
    where:
    email                                     | valid
    'ian.ellis@theiconic.com.au'              | true
    '1s__%+2a-3@Azd-0io.aa'                   | true
    'ian.ellis @theiconic.com.au'             | false
    'ian@theiconic'                           | false
    'ian.theinonic.com.au'                    | false
    'ad091283bqd09bjask9813hs@asdlka.asldka'  | true
    'ad091283bqd09bjask9813hs@asdlka.a%ldka'  | false
    'ad091283bqd09bjask9813hs@asdlka.a_sldka' | false
    'ad091283bqd09bjask9813hs@asdlka.asldkaa' | false
    'ad091283bqd09bjask9813hs@asdlka.a'       | false
  }
}