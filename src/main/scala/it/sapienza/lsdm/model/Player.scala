package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class Player(
    id: Option[Long] = None,
    name: Option[String],
    position: Option[String],
    foot: Option[String],
    height: Option[Double],
    age: Option[Int],
    dob: Option[String],
    cityOb: Option[String],
    countryOb: Option[String]
)

class PlayerEntity(tag: Tag) extends Table[(Player)](tag, "Player") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def position = column[String]("position")
    def foot = column[String]("foot")
    def height = column[Double]("height")
    def age = column[Int]("age")
    def dob = column[String]("dob")
    def cityOb = column[String]("city_ob")
    def countryOb = column[String]("country_ob")
    // Every table needs a * projection with the same type as the table's type parameter
    def * = (id.?, name.?, position.?, foot.?, height.?, age.?, dob.?, cityOb.?, countryOb.?) <> (Player.tupled, Player.unapply)
}