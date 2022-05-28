package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class MiscStats(
	pid : Option[String],
	cards_yellow : Option[Double],
	cards_red : Option[Double],
	fouls : Option[Double],
	fouled : Option[Double],
	offsides : Option[Double],
	crosses : Option[Double],
	aerials_won : Option[Double],
	aerials_won_pct : Option[Double],
)


class MiscStatsEntity(tag: Tag) extends Table[MiscStats](tag, "MiscStats") {
	def pid = column[String]("pid")
	def cards_yellow = column[Option[Double]]("cards_yellow")
	def cards_red = column[Option[Double]]("cards_red")
	def fouls = column[Option[Double]]("fouls")
	def fouled = column[Option[Double]]("fouled")
	def offsides = column[Option[Double]]("offsides")
	def crosses = column[Option[Double]]("crosses")
	def aerials_won = column[Option[Double]]("aerials_won")
	def aerials_won_pct = column[Option[Double]]("aerials_won_pct")

	val pidFK = TableQuery[PlayerEntity]
	def pid_fk = foreignKey("pid_fk", pid, pidFK)(_.pid, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
	def * = (pid.?, cards_yellow, cards_red, fouls, fouled, offsides, crosses, aerials_won, aerials_won_pct) <> (MiscStats.tupled, MiscStats.unapply)
}
