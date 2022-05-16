package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class Player(
    id:        Option[Long] = None,
    name:      Option[String],
    position:  Option[String],
    foot:      Option[String],
    height:    Option[Double],
    age:       Option[Int],
    dob:       Option[String],
    cityOb:    Option[String],
    countryOb: Option[String]
)

class PlayerEntity(tag: Tag) extends Table[(Player)](tag, "Player") {
    def id        = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name      = column[Option[String]]("name")
    def position  = column[Option[String]]("position")
    def foot      = column[Option[String]]("foot")
    def height    = column[Option[Double]]("height")
    def age       = column[Option[Int]]("age")
    def dob       = column[Option[String]]("dob")
    def cityOb    = column[Option[String]]("city_ob")
    def countryOb = column[Option[String]]("country_ob")
    // Every table needs a * projection with the same type as the table's type parameter
    def * = (id.?, name, position, foot, height, age, dob, cityOb, countryOb) <> (Player.tupled, Player.unapply)
}