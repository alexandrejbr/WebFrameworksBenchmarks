package models

import play.api.libs.json.Json
import com.github.nscala_time.time.Imports._
import spray.json._

case class Book(title: String, authors: Seq[String], publisher: String, isbn13: Long, publishedDate: String)
//{
//	val formatedDate: String = DateTimeFormat.forPattern("MMMM d, yyyy").print(publishedDate)
//}

object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val bookFormat = jsonFormat5(Book.apply)
}

object Book {
  implicit val bookFmt = Json.format[Book]
  private var books = 
    Array(
        Book("Animal Farm", Seq("George Orwell"), "Penguin", 9780141036137L, DateTimeFormat.forPattern("MMMM d, yyyy").print(DateTime.now)),
        Book("1984", Seq("George Orwell"), "Penguin", 9780141036144L, DateTimeFormat.forPattern("MMMM d, yyyy").print(DateTime.now)),
        Book("The Razor's Edge", Seq("William Sommerset Maugham"), "Vintage", 9780099284864L, DateTimeFormat.forPattern("MMMM d, yyyy").print(DateTime.now))
    )
    
    def all = books 
}