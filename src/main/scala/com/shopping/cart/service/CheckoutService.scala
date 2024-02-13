package com.shopping.cart.service

import com.shopping.cart.models.Model.{Apple, Fruit, Orange}

object CheckoutService {

  type Basket = List[Fruit]

  def checkout(basket: Basket, applyOffers: Boolean = false): BigDecimal = {
    if (applyOffers) {
      val appleCount = basket.count(_ == Apple)
      val orangeCount = basket.count(_ == Orange)

      val applesPrice = (appleCount/2 + appleCount%2) * Apple.price

      val orangesPrice = ((2 * (orangeCount/3)) + orangeCount%3) * Orange.price

      applesPrice + orangesPrice
    } else {
      basket.map(_.price).sum
    }
  }

}
