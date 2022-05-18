package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class League(
    name:    Option[String],
    country: Option[String]
)

class LeagueEntity(tag: Tag) extends Table[League](tag, "League") {
    def name    = column[String]("name", O.PrimaryKey)
    def country = column[Option[String]]("country")
    def * = (name.?, country) <> (League.tupled, League.unapply)
}