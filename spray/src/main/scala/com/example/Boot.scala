package com.example

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http
import akka.routing.RoundRobinPool
import akka.routing.DefaultResizer

object Boot extends App {

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("on-spray-can")

  // create and start our service actor
  //val service = system.actorOf(Props[MyServiceActor], "demo-service")

  val resizer = DefaultResizer(lowerBound = 2, upperBound = 8)
  
  val service = system.actorOf(RoundRobinPool(4, Some(resizer)).props(Props[MyServiceActor]), "router")
  
  val interface = system.settings.config.getString("app.interface")
  val port = system.settings.config.getInt("app.port")
  // start a new HTTP server with our service actor as the handler
  IO(Http) ! Http.Bind(service, interface, port)
}