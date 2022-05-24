package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class PassingStats(
	pid : Option[String],
	minutes_90s : Option[Double],
	passes_completed : Option[Double],
	passes : Option[Double],
	passes_pct : Option[Double],
	passes_completed_short : Option[Double],
	passes_short : Option[Double],
	passes_pct_short : Option[Double],
	passes_completed_medium : Option[Double],
	passes_medium : Option[Double],
	passes_pct_medium : Option[Double],
	passes_completed_long : Option[Double],
	passes_long : Option[Double],
	passes_pct_long : Option[Double],
	assists : Option[Double],
	passes_into_final_third : Option[Double],
	passes_into_penalty_area : Option[Double],
	crosses_into_penalty_area : Option[Double],
)


class PassingStatsEntity(tag: Tag) extends Table[PassingStats](tag, "PassingStats") {
	def pid = column[String]("pid")
	def minutes_90s = column[Option[Double]]("minutes_90s")
	def passes_completed = column[Option[Double]]("passes_completed")
	def passes = column[Option[Double]]("passes")
	def passes_pct = column[Option[Double]]("passes_pct")
	def passes_completed_short = column[Option[Double]]("passes_completed_short")
	def passes_short = column[Option[Double]]("passes_short")
	def passes_pct_short = column[Option[Double]]("passes_pct_short")
	def passes_completed_medium = column[Option[Double]]("passes_completed_medium")
	def passes_medium = column[Option[Double]]("passes_medium")
	def passes_pct_medium = column[Option[Double]]("passes_pct_medium")
	def passes_completed_long = column[Option[Double]]("passes_completed_long")
	def passes_long = column[Option[Double]]("passes_long")
	def passes_pct_long = column[Option[Double]]("passes_pct_long")
	def assists = column[Option[Double]]("assists")
	def passes_into_final_third = column[Option[Double]]("passes_into_final_third")
	def passes_into_penalty_area = column[Option[Double]]("passes_into_penalty_area")
	def crosses_into_penalty_area = column[Option[Double]]("crosses_into_penalty_area")

	val pidFK = TableQuery[PlayerEntity]
	def pid_fk = foreignKey("pid_fk", pid, pidFK)(_.pid, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
	def * = (pid.?, minutes_90s, passes_completed, passes, passes_pct, passes_completed_short, passes_short, passes_pct_short, passes_completed_medium, passes_medium, passes_pct_medium, passes_completed_long, passes_long, passes_pct_long, assists, passes_into_final_third, passes_into_penalty_area, crosses_into_penalty_area) <> (PassingStats.tupled, PassingStats.unapply)
}
