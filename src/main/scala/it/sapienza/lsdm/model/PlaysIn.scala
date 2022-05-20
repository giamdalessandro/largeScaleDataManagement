package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class PlaysIn(
    pid:  Option[String],
    club: Option[String]
)


class PlaysInEntity(tag: Tag) extends Table[PlaysIn](tag, "PlaysIn") {
    def pid = column[String]("pid")
    def club = column[String]("club")
	
	lazy val pidFK = TableQuery[PlayerEntity]
	def pid_fk = foreignKey("pid_fk", pid, pidFK)(_.pid, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
	lazy val clubFK = TableQuery[ClubEntity]	
	def club_fk = foreignKey("club_fk", club, clubFK)(_.name, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)

    def * = (pid.?, club.?) <> (PlaysIn.tupled, PlaysIn.unapply)
}