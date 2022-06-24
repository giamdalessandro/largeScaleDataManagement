package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class GoalkeeperStats(
	player                  : Option[String],
	goals_against_gk        : Option[Double],
	goals_against_per90_gk  : Option[Double],
	shots_on_target_against : Option[Double],
	saves 				    : Option[Double],
	save_pct 				: Option[Double],
	clean_sheets 			: Option[Double],
	clean_sheets_pct 		: Option[Double],
	pens_save_pct 			: Option[Double]
)


class GoalkeeperStatsEntity(tag: Tag) extends Table[GoalkeeperStats](tag, "GoalkeeperStats") {
	def player                  = column[Option[String]]("pid");
	def goals_against_gk 		= column[Option[Double]]("goals_against_gk");
	def goals_against_per90_gk 	= column[Option[Double]]("goals_against_per90_gk");
	def shots_on_target_against = column[Option[Double]]("shots_on_target_against");
	def saves 					= column[Option[Double]]("saves");
	def save_pct 				= column[Option[Double]]("save_pct");
	def clean_sheets 			= column[Option[Double]]("clean_sheets");
	def clean_sheets_pct 		= column[Option[Double]]("clean_sheets_pct");
	def pens_save_pct 			= column[Option[Double]]("pens_save_pct");

	def * = (player, goals_against_gk, goals_against_per90_gk, shots_on_target_against, saves, save_pct, clean_sheets, clean_sheets_pct, pens_save_pct) <> (GoalkeeperStats.tupled, GoalkeeperStats.unapply);
}
