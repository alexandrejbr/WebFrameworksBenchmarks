package com.twitter.finatra_example

import com.twitter.finatra._
import com.twitter.finatra.ContentType._
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.scala.DefaultScalaModule

object App extends FinatraServer {

  val txt = asString(Book.all)
  
  def asString(obj: Any) = {
    val m = new ObjectMapper()
    m.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
    m.registerModule(DefaultScalaModule)
    m.writeValueAsString(obj)
  }

  class ExampleApp extends Controller {

    get("/json") { req =>
      render.json(Book.all).toFuture
    }

    get("/text") { req =>
      render.plain(txt).toFuture
    }
  }

  register(new ExampleApp())
}
