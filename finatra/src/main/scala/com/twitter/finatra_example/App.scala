package com.twitter.finatra_example

import com.twitter.finatra._
import com.twitter.finatra.ContentType._

object App extends FinatraServer {

  class CustomerView(val customers: IndexedSeq[Customer]) extends View {
    val template = "customer.mustache"
  }

  class ExampleApp extends Controller {
    private val maxCount = 200
    private val minCount = 20
    get("/") { req =>
      val count = req.params.getInt("count")
      val customers = count match {
        case Some(c) => Customer.values(if (c <= maxCount) c else maxCount)
        case None => Customer.values(minCount)
      }
      //render.view(new CustomerView(customers)).toFuture
      render.json(customers).toFuture
    }
  }

  register(new ExampleApp())
}
