package com.example

import akka.actor.Actor
import spray.http._
import MediaTypes._
import spray.can._
import spray.json._
import HttpMethods._
import MyJsonProtocol._
import spray.http.Uri.Path
import spray.http.Uri.Path.Slash
import spray.http.Uri.Path.Segment

class MyServiceActor extends Actor {
  private val txt = Book.all.toJson.compactPrint

  //realistic
  def receive = {
    case _: Http.Connected => sender ! Http.Register(self)
    case HttpRequest(GET, Uri.Path("/text"), _, _, _) =>
      sender ! HttpResponse(entity = HttpEntity(ContentTypes.`text/plain`, txt))
    case HttpRequest(GET, Uri.Path("/json"), _, _, _) =>
      sender ! HttpResponse(entity = HttpEntity(ContentTypes.`application/json`, Book.all.toJson.compactPrint))
    case HttpRequest(GET, Uri.Path("/actor"), _, _, _) =>
      sender ! HttpResponse(entity = self.toString)
  } 
  
  //non-realistic
//  def fastPath: Http.FastPath = {
//    case HttpRequest(GET, Uri.Path("/text"), _, _, _) =>
//      HttpResponse(entity = HttpEntity(ContentTypes.`text/plain`, txt))
//    case HttpRequest(GET, Uri.Path("/json"), _, _, _) =>
//      HttpResponse(entity = HttpEntity(ContentTypes.`application/json`, Book.all.toJson.compactPrint))
//    case HttpRequest(GET, Uri.Path("/actor"), _, _, _) =>
//      HttpResponse(entity = self.toString)
//  }
//  
//  def receive = {
//    case _: Http.Connected => sender ! Http.Register(self, fastPath = fastPath)    
//  }
}
