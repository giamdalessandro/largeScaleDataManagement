package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class Birth(
    id: Option[Long],
    city: Option[String],
    country: Option[String]
)

class BirthEntity(tag: Tag) extends Table[Birth](tag, "BIRTH") {
    def id = column[Option[Long]]("id", O.PrimaryKey);
    def city = column[Option[String]]("city");
    def country = column[Option[String]]("country");
    def * = (id, city, country) <> (Birth.tupled, Birth.unapply);
}
