package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class StandardStats(
	pid : Option[String],
	games : Option[Double],
	games_starts : Option[Double],
	mnts : Option[Double],
	goals : Option[Double],
	assists : Option[Double],
	goals_pens : Option[Double],
	pens_made : Option[Double],
	pens_att : Option[Double],
	cards_yellow : Option[Double],
	cards_red : Option[Double],
	goals_per90 : Option[Double],
	assists_per90 : Option[Double],
	goals_assists_per90 : Option[Double],
	goals_pens_per90 : Option[Double],
)


class StandardStatsEntity(tag: Tag) extends Table[StandardStats](tag, "StandardStats") {
	def pid = column[String]("pid")
	def games = column[Option[Double]]("games")
	def games_starts = column[Option[Double]]("games_starts")
	def mnts = column[Option[Double]]("mnts")
	def goals = column[Option[Double]]("goals")
	def assists = column[Option[Double]]("assists")
	def goals_pens = column[Option[Double]]("goals_pens")
	def pens_made = column[Option[Double]]("pens_made")
	def pens_att = column[Option[Double]]("pens_att")
	def cards_yellow = column[Option[Double]]("cards_yellow")
	def cards_red = column[Option[Double]]("cards_red")
	def goals_per90 = column[Option[Double]]("goals_per90")
	def assists_per90 = column[Option[Double]]("assists_per90")
	def goals_assists_per90 = column[Option[Double]]("goals_assists_per90")
	def goals_pens_per90 = column[Option[Double]]("goals_pens_per90")

	val pidFK = TableQuery[PlayerEntity]
	def pid_fk = foreignKey("pid_fk", pid, pidFK)(_.pid, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
	def * = (pid.?, games, games_starts, mnts, goals, assists, goals_pens, pens_made, pens_att, cards_yellow, cards_red, goals_per90, assists_per90, goals_assists_per90, goals_pens_per90) <> (StandardStats.tupled, StandardStats.unapply)
}
