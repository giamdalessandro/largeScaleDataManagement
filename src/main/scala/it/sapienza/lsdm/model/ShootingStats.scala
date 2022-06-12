package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class ShootingStats(
	pid : Option[String],
	minutes_90s : Option[Double],
	goals : Option[Double],
	shots_total : Option[Double],
	shots_on_target : Option[Double],
	shots_on_target_pct : Option[Double],
	shots_total_per90 : Option[Double],
	shots_on_target_per90 : Option[Double],
	goals_per_shot : Option[Double],
	average_shot_distance : Option[Double],
	shots_free_kicks : Option[Double],
	pens_made : Option[Double],
	pens_att : Option[Double],
)


class ShootingStatsEntity(tag: Tag) extends Table[ShootingStats](tag, "ShootingStats") {
	def pid = column[String]("pid")
	def minutes_90s = column[Option[Double]]("minutes_90s")
	def goals = column[Option[Double]]("goals")
	def shots_total = column[Option[Double]]("shots_total")
	def shots_on_target = column[Option[Double]]("shots_on_target")
	def shots_on_target_pct = column[Option[Double]]("shots_on_target_pct")
	def shots_total_per90 = column[Option[Double]]("shots_total_per90")
	def shots_on_target_per90 = column[Option[Double]]("shots_on_target_per90")
	def goals_per_shot = column[Option[Double]]("goals_per_shot")
	def average_shot_distance = column[Option[Double]]("average_shot_distance")
	def shots_free_kicks = column[Option[Double]]("shots_free_kicks")
	def pens_made = column[Option[Double]]("pens_made")
	def pens_att = column[Option[Double]]("pens_att")

	def * = (pid.?, minutes_90s, goals, shots_total, shots_on_target, shots_on_target_pct, shots_total_per90, shots_on_target_per90, goals_per_shot, average_shot_distance, shots_free_kicks, pens_made, pens_att) <> (ShootingStats.tupled, ShootingStats.unapply)
}
