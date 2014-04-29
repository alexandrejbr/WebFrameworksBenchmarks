package com.example

import scala.util.Random
import com.github.nscala_time.time.Imports._


case class Customer(val id: Int, val firstName: String, val lastName: String, val state: String, val birthDate: DateTime){
  val formatedDate: String = DateTimeFormat.forPattern("MMMM d, yyyy").print(birthDate)
}

object Customer{
  val random: Random = new Random(DateTime.now.millis)
  val firstNames = IndexedSeq("Emily", "Jacob", "Michael", "Emma", "Joshua", "Madison", "Matthew", "Hannah", "Andrew", "Olivia", "Cletus", "Warner", "Sarah", "Billy", "Brittany", "Daniel", "David", "Cristman", "Colin", "Royalle")
  val lastNames = IndexedSeq("Aaron", "Bolingbroke", "Crounse", "Duff", "Drake", "Downs", "Driver", "Jasper", "Jetter", "O'Leary", "O'Malley", "Neville", "Towers", "Tripp", "Trull", "Wakefield", "Waller", "Badger", "Bagley", "Baker")
  val states = IndexedSeq("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming")

  def values(c: Int): IndexedSeq[Customer] =
    (0 until c).map(i => Customer(i, randomString(firstNames), randomString(lastNames), randomString(states), randomDay))

  def randomString(items: IndexedSeq[String]) = items(random.nextInt(items.length))

  def randomDay = {
    val daysAgo = random.nextInt(18250) + 4745
    DateTime.now - daysAgo.days
  }
}
