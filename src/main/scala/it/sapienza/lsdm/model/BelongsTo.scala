package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class BelongsTo(
    club:   Option[String],
    league: Option[String]
)


class BelongsToEntity(tag: Tag) extends Table[BelongsTo](tag, "BelongsTo") {
    def club    = column[String]("club")
    def league  = column[String]("league")

    def * = (club.?, league.?) <> (BelongsTo.tupled, BelongsTo.unapply)
}