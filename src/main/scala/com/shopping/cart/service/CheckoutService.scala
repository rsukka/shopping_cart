package com.shopping.cart.service

import com.shopping.cart.models.Model.{Apple, Fruit, Orange}

object CheckoutService {

  type Basket = List[Fruit]

  def checkout(basket: Basket, applyOffers: Boolean = false): BigDecimal = {
    if (applyOffers) {
      ???
    } else {
      basket.map(_.price).sum
    }
  }

}
