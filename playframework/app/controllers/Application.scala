package controllers

import play.api._
import play.api.mvc._
import models.Customer
import play.api.cache.Cached
import play.api.Play.current

object Application extends Controller {
  private val maxCount = 200
  private val minCount = 20
  def index(count: Option[Int]) = //Cached(req => req.uri) {
    Action {
      Ok(views.html.index(count match {
        case Some(c) => Customer.values(if (c <= maxCount) c else maxCount)
        case None => Customer.values(minCount)
      }))
    }
  //}

}