package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class Club(
    uuid: Option[Long],
    name: Option[String]
)

class ClubEntity(tag: Tag) extends Table[Club](tag, "Club") {
    def uuid = column[Long]("uuid", O.AutoInc)
    def name = column[String]("name", O.PrimaryKey)
    def * = (uuid.?, name.?) <> (Club.tupled, Club.unapply)
}