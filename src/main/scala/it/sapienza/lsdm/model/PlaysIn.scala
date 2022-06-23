package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class PlaysIn(
    player: Option[String],
    club:   Option[String]
)


class PlaysInEntity(tag: Tag) extends Table[PlaysIn](tag, "PlaysIn") {
    def player = column[String]("player")
    def club   = column[String]("club")

    def * = (player.?, club.?) <> (PlaysIn.tupled, PlaysIn.unapply)
}