package controllers

import play.api._
import play.api.mvc._
import models.Customer
import play.api.cache.Cached
import play.api.Play.current
import models.Book
import play.api.libs.json._

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
  
  val txt = Json.stringify(Json.toJson(Book.all))
  
  def json = Action {
    
    Ok(Json.toJson(Book.all))
  }
  
  def sprayjson = Action {
    import spray.json._
    import models.MyJsonProtocol._
    Ok(Book.all.toJson.compactPrint)
  }
  
  def text = Action {
    Ok(txt)
  }

}