package com.shopping.cart.service

import com.shopping.cart.models.Model.{Apple, Fruit, Orange}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CheckoutServiceSpec extends AnyFlatSpec with Matchers {

  "CheckoutService" should "results 0 given the basket is empty" in {
     CheckoutService.checkout(List.empty[Fruit]) shouldBe BigDecimal(0.00)
  }

  "CheckoutService" should "results 2.05 given basket contains 3 apples and one orange" in {
    val basket = List(Apple, Apple, Orange, Apple)
    CheckoutService.checkout(basket) shouldBe BigDecimal(2.05)
  }

  "CheckoutService" should "results 11.75 given checkbox contains 15 Apples and 11 Oranges" in {
    CheckoutService.checkout(fillBasket(15, 11)) shouldBe BigDecimal(11.75)
  }

  private def fillBasket(apples: Int, oranges: Int): List[Fruit] = {
    List.fill(apples)(Apple) ++ List.fill(oranges)(Orange)
  }
}