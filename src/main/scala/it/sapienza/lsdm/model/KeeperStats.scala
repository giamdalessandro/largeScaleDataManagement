package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class KeeperStats(
	pid : Option[String],
	games_gk : Option[Double],
	games_starts_gk : Option[Double],
	minutes_gk : Option[Double],
	minutes_90s : Option[Double],
	goals_against_gk : Option[Double],
	goals_against_per90_gk : Option[Double],
	shots_on_target_against : Option[Double],
	saves : Option[Double],
	save_pct : Option[Double],
	clean_sheets : Option[Double],
	clean_sheets_pct : Option[Double],
	pens_save_pct : Option[Double],
)


class KeeperStatsEntity(tag: Tag) extends Table[KeeperStats](tag, "KeeperStats") {
	def pid = column[String]("pid")
	def games_gk = column[Option[Double]]("games_gk")
	def games_starts_gk = column[Option[Double]]("games_starts_gk")
	def minutes_gk = column[Option[Double]]("minutes_gk")
	def minutes_90s = column[Option[Double]]("minutes_90s")
	def goals_against_gk = column[Option[Double]]("goals_against_gk")
	def goals_against_per90_gk = column[Option[Double]]("goals_against_per90_gk")
	def shots_on_target_against = column[Option[Double]]("shots_on_target_against")
	def saves = column[Option[Double]]("saves")
	def save_pct = column[Option[Double]]("save_pct")
	def clean_sheets = column[Option[Double]]("clean_sheets")
	def clean_sheets_pct = column[Option[Double]]("clean_sheets_pct")
	def pens_save_pct = column[Option[Double]]("pens_save_pct")

	def * = (pid.?, games_gk, games_starts_gk, minutes_gk, minutes_90s, goals_against_gk, goals_against_per90_gk, shots_on_target_against, saves, save_pct, clean_sheets, clean_sheets_pct, pens_save_pct) <> (KeeperStats.tupled, KeeperStats.unapply)
}
