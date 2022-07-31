package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class Presence(
    id      : Long,
    games   : Option[Int],
    minutes : Option[Int]
)

class PresenceEntity(tag: Tag) extends Table[Presence](tag, "PRESENCE") {
    def id      = column[Long]("id", O.PrimaryKey, O.AutoInc);
    def games   = column[Option[Int]]("games");
    def minutes = column[Option[Int]]("minutes");
    def * = (id, games, minutes) <> (Presence.tupled, Presence.unapply);
}
