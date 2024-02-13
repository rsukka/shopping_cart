package com.shopping.cart.service

import com.shopping.cart.models.Model.Fruit

object CheckoutService {

  def checkout(fruits: List[Fruit]): BigDecimal = fruits.map(_.price).sum
}
