package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class PlaysIn(
    pid:  Option[String],
    club: Option[String]
)


class PlaysInEntity(tag: Tag) extends Table[PlaysIn](tag, "PlaysIn") {
    def pid = column[String]("pid")
    def club = column[String]("club")

    def * = (pid.?, club.?) <> (PlaysIn.tupled, PlaysIn.unapply)
}