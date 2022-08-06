package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class Presence(
    id      : Option[Long],
    games   : Option[Int],
    minutes : Option[Int]
)

class PresenceEntity(tag: Tag) extends Table[Presence](tag, "PRESENCE") {
    def id      = column[Option[Long]]("id", O.PrimaryKey);
    def games   = column[Option[Int]]("games");
    def minutes = column[Option[Int]]("minutes");
    def * = (id, games, minutes) <> (Presence.tupled, Presence.unapply);
}
