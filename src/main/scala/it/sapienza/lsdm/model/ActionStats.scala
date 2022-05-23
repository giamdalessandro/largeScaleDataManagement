package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class ActionStats(
    pid    : Option[String],
    min90s : Option[String],
    sca    : Option[String],
    sca90  : Option[String],
    gca    : Option[String],
    gca90  : Option[String]
)


class ActionStatsEntity(tag: Tag) extends Table[ActionStats](tag, "ActionStats") {
	def pid    = column[String]("pid")
    def min90s = column[Option[String]]("min90s")
    def sca    = column[Option[String]]("sca")
    def sca90  = column[Option[String]]("sca90")
    def gca    = column[Option[String]]("gca")
    def gca90  = column[Option[String]]("gca90")
	
	val pidFK = TableQuery[PlayerEntity]	
	def pid_fk = foreignKey("pid_fk", pid, pidFK)(_.pid, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
    def * = (pid.?, min90s, sca, sca90, gca, gca90) <> (ActionStats.tupled, ActionStats.unapply)
}