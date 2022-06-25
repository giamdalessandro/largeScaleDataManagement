package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class GoalStats(
	player 				  : Option[String],
	minutes_90s 		  : Option[Double],
	goals 				  : Option[Double],
	shots_total 		  : Option[Double],
	shots_on_target 	  : Option[Double],
	shots_on_target_pct   : Option[Double],
	shots_total_per90 	  : Option[Double],
	shots_on_target_per90 : Option[Double],
	goals_per_shot 		  : Option[Double],
	average_shot_distance : Option[Double],
	shots_free_kicks      : Option[Double],
	pens_made 			  : Option[Double],
	pens_att			  : Option[Double],
	goals_pens          : Option[Double],
	goals_per90         : Option[Double],
	goals_assists_per90 : Option[Double],
	goals_pens_per90    : Option[Double],
	offsides 			: Option[Double],
)


class GoalStatsEntity(tag: Tag) extends Table[GoalStats](tag, "GoalStats") {
	def player			 	  = column[Option[String]]("player");
	def minutes_90s 		  = column[Option[Double]]("minutes_90s");
	def goals 				  = column[Option[Double]]("goals");
	def shots_total	 		  = column[Option[Double]]("shots_total");
	def shots_on_target 	  = column[Option[Double]]("shots_on_target");
	def shots_on_target_pct   = column[Option[Double]]("shots_on_target_pct");
	def shots_total_per90 	  = column[Option[Double]]("shots_total_per90");
	def shots_on_target_per90 = column[Option[Double]]("shots_on_target_per90");
	def goals_per_shot 		  = column[Option[Double]]("goals_per_shot");
	def average_shot_distance = column[Option[Double]]("average_shot_distance");
	def shots_free_kicks      = column[Option[Double]]("shots_free_kicks");
	def pens_made 			  = column[Option[Double]]("pens_made");
	def pens_att 			  = column[Option[Double]]("pens_att");
	def goals_pens 			  = column[Option[Double]]("goals_pens");
	def goals_per90 		  = column[Option[Double]]("goals_per90");
	def goals_assists_per90   = column[Option[Double]]("goals_assists_per90");
	def goals_pens_per90 	  = column[Option[Double]]("goals_pens_per90");
	def offsides 			  = column[Option[Double]]("offsides");

	def * = (player, minutes_90s, goals, shots_total, shots_on_target, shots_on_target_pct, shots_total_per90, shots_on_target_per90, goals_per_shot, average_shot_distance, shots_free_kicks, pens_made, pens_att, goals_pens, goals_per90, goals_assists_per90, goals_pens_per90, offsides) <> (GoalStats.tupled, GoalStats.unapply)
}
