package com.example

import akka.actor.Actor
import spray.routing._
import spray.util
import spray.http._
import MediaTypes._
import spray.httpx.marshalling.Marshaller
import spray.httpx.TwirlSupport._
import spray.can._
import spray.json._

import MyJsonProtocol._

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class MyServiceActor extends Actor with MyService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  //  import context.dispatcher
  //  import Uri._
  //  import Uri.Path._
  //  def fastPath: Http.FastPath = {
  //    case _ => HttpResponse(entity = HttpEntity(ContentType(MediaType.custom("text/html")), html.index(Customer.values(20)).toString))
  //  }
  //  
  //  def receive = {
  //    case _: Http.Connected => sender ! Http.Register(self, fastPath = fastPath)
  //  }

  def receive = runRoute(myRoute)
}

// this trait defines our service behavior independently from the service actor
trait MyService extends HttpService {
  private val maxCount = 200
  private val minCount = 20
  private val txt = Book.all.toJson.compactPrint
  val myRoute =
    path("") {
      parameters('count.as[Option[Int]]) { count =>
        get {
          complete(html.index(count match {
            case Some(c) => Customer.values(if (c <= maxCount) c else maxCount)
            case None => Customer.values(minCount)
          }))
        }
      }
    } ~
      path("text") {
        get {
          complete(txt)
        }
      } ~
      path("json") {
        get {
          respondWithMediaType(`application/json`) {
            complete(Book.all.toJson.compactPrint)
          }
        }
      }
}