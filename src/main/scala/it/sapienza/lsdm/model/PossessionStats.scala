package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class PossessionStats(
	pid : Option[String],
	touches : Option[Double],
	touches_def_3rd : Option[Double],
	touches_mid_3rd : Option[Double],
	touches_att_3rd : Option[Double],
	touches_att_pen_area : Option[Double],
	dribbles_completed : Option[Double],
	dribbles : Option[Double],
	dribbles_completed_pct : Option[Double],
	miscontrols : Option[Double],
	dispossessed : Option[Double],
	pass_targets : Option[Double],
)


class PossessionStatsEntity(tag: Tag) extends Table[PossessionStats](tag, "PossessionStats") {
	def pid = column[String]("pid")
	def touches = column[Option[Double]]("touches")
	def touches_def_3rd = column[Option[Double]]("touches_def_3rd")
	def touches_mid_3rd = column[Option[Double]]("touches_mid_3rd")
	def touches_att_3rd = column[Option[Double]]("touches_att_3rd")
	def touches_att_pen_area = column[Option[Double]]("touches_att_pen_area")
	def dribbles_completed = column[Option[Double]]("dribbles_completed")
	def dribbles = column[Option[Double]]("dribbles")
	def dribbles_completed_pct = column[Option[Double]]("dribbles_completed_pct")
	def miscontrols = column[Option[Double]]("miscontrols")
	def dispossessed = column[Option[Double]]("dispossessed")
	def pass_targets = column[Option[Double]]("pass_targets")

	def * = (pid.?, touches, touches_def_3rd, touches_mid_3rd, touches_att_3rd, touches_att_pen_area, dribbles_completed, dribbles, dribbles_completed_pct, miscontrols, dispossessed, pass_targets) <> (PossessionStats.tupled, PossessionStats.unapply)
}
