package com.theiconic.spockexamples

import spock.lang.Specification

class SimpleAdditionSpec extends Specification {
  def 'addition'() {
    given: 'two integers'
    def a = 1
    def b = 2

    when: 'we add them together'
    def c = a + b

    then: 'the result is the sum of the two'
    c == 3

    when: 'we increment the result'
    c ++

    then: 'it is incremented'
    c == 4
  }
}