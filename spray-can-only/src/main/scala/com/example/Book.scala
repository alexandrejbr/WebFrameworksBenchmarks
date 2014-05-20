package com.example

import com.github.nscala_time.time.Imports._
import spray.json._
import DefaultJsonProtocol._

case class Book(title: String, authors: List[String], publisher: String, isbn13: Long, publishedDate: String)

object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val bookFormat = jsonFormat5(Book.apply)
}

object Book {
  private var books = 
    List(
        Book("Animal Farm", List("George Orwell"), "Penguin", 9780141036137L, DateTimeFormat.forPattern("MMMM d, yyyy").print(DateTime.now)),
        Book("1984", List("George Orwell"), "Penguin", 9780141036144L, DateTimeFormat.forPattern("MMMM d, yyyy").print(DateTime.now)),
        Book("The Razor's Edge", List("William Sommerset Maugham"), "Vintage", 9780099284864L, DateTimeFormat.forPattern("MMMM d, yyyy").print(DateTime.now))
    )
    
    def all = books 
}

