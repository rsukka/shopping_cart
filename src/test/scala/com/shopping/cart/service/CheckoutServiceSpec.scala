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

  "CheckoutService" should "results 11.75 given basket contains 15 Apples and 11 Oranges" in {
    CheckoutService.checkout(fillBasket(15, 11)) shouldBe BigDecimal(11.75)
  }

  private def fillBasket(apples: Int, oranges: Int): List[Fruit] = {
    List.fill(apples)(Apple) ++ List.fill(oranges)(Orange)
  }

  //CheckoutService with offers
  "CheckoutService with offers" should "results 6.8 given basket contains 15 Apples and 11 Oranges" in {
    CheckoutService.checkout(fillBasket(15, 11), true) shouldBe BigDecimal(4.8 + 2)
  }

  "CheckoutService with offers" should "results 2 given basket contains 0 Apples and 11 Oranges" in {
    CheckoutService.checkout(fillBasket(0, 11), true) shouldBe BigDecimal(2)
  }

  "CheckoutService with offers" should "results 4.8 given basket contains 15 Apples and 0 Oranges" in {
    CheckoutService.checkout(fillBasket(15, 0), true) shouldBe BigDecimal(4.8)
  }

  "CheckoutService with offers" should "results 1.1 given basket contains 2 Apples and 3 Oranges" in {
    CheckoutService.checkout(fillBasket(2, 3), true) shouldBe BigDecimal(0.60 +0.50)
  }

  "CheckoutService with offers" should "results 1.1 given basket contains 1 Apples and 2 Oranges" in {
    CheckoutService.checkout(fillBasket(1, 2), true) shouldBe BigDecimal(0.60 +0.50)
  }
}