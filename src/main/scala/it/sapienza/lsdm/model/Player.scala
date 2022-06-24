package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class Player(
    name     : Option[String],
    position : Option[String],
    foot     : Option[String],
    height   : Option[Double],
    weight   : Option[Double],
    age      : Option[Int],
    dob      : Option[String],
    cityOb   : Option[String],
    countryOb: Option[String],
    prefFoot : Option[String],
    bestPos  : Option[String],
    bestRole : Option[String],
    value    : Option[Double],
    wage     : Option[Double]
)

class PlayerEntity(tag: Tag) extends Table[Player](tag, "Player") {
    def name      = column[String]("name");
    def position  = column[Option[String]]("position");
    def foot      = column[Option[String]]("foot");
    def height    = column[Option[Double]]("height");
    def weight    = column[Option[Double]]("weight");
    def age       = column[Option[Int]]("age");
    def dob       = column[Option[String]]("dob");
    def cityOb    = column[Option[String]]("city_ob");
    def countryOb = column[Option[String]]("country_ob");
    def prefFoot  = column[Option[String]]("prefFoot");
    def bestPos   = column[Option[String]]("bestPos");
    def bestRole  = column[Option[String]]("bestRole");
    def value     = column[Option[Double]]("value");
    def wage      = column[Option[Double]]("wage");
    // Every table needs a * projection with the same type as the table's type parameter
    def * = (name.?, position, foot, height, weight, age, dob, cityOb, countryOb, prefFoot, bestPos, bestRole, value, wage) <> (Player.tupled, Player.unapply);
}