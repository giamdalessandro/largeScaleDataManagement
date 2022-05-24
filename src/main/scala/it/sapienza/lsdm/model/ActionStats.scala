package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class ActionStats(
    pid    : Option[String],
    min90s : Option[Double],
    sca    : Option[Double],
    sca90  : Option[Double],
    gca    : Option[Double],
    gca90  : Option[Double]
)


class ActionStatsEntity(tag: Tag) extends Table[ActionStats](tag, "ActionStats") {
	def pid    = column[String]("pid")
    def min90s = column[Option[Double]]("min90s")
    def sca    = column[Option[Double]]("sca")
    def sca90  = column[Option[Double]]("sca90")
    def gca    = column[Option[Double]]("gca")
    def gca90  = column[Option[Double]]("gca90")
	
	val pidFK = TableQuery[PlayerEntity]	
	def pid_fk = foreignKey("pid_fk", pid, pidFK)(_.pid, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
    def * = (pid.?, min90s, sca, sca90, gca, gca90) <> (ActionStats.tupled, ActionStats.unapply)
}