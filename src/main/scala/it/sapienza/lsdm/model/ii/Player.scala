package it.sapienza.lsdm.model.relational

import slick.jdbc.PostgresProfile.api._


case class Player(
    name       : Option[String],
    position   : Option[String],
    foot       : Option[String],
    height     : Option[Double],
    weight     : Option[Double],
    age        : Option[Int],
    dob        : Option[String],
    cityOb     : Option[String],
    countryOb  : Option[String],
    value      : Option[Double],
    wage       : Option[Double],
    ca         : Option[Double],
    pa         : Option[Double]
)

class PlayerEntity(tag: Tag) extends Table[Player](tag, "Player") {
    def name       = column[String]("name");
    def position   = column[Option[String]]("position");
    def foot       = column[Option[String]]("foot");
    def height     = column[Option[Double]]("height");
    def weight     = column[Option[Double]]("weight");
    def age        = column[Option[Int]]("age");
    def dob        = column[Option[String]]("dob");
    def cityOb     = column[Option[String]]("city_ob");
    def countryOb  = column[Option[String]]("country_ob");
    def value      = column[Option[Double]]("value");
    def wage       = column[Option[Double]]("wage");
    def ca         = column[Option[Double]]("ca");
    def pa         = column[Option[Double]]("pa");
    def * = (name.?, position, foot, height, weight, age, dob, cityOb, countryOb, value, wage, ca, pa) <> (Player.tupled, Player.unapply);
}