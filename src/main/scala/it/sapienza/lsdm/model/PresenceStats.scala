package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class PresenceStats(
	player           : Option[String],
	games            : Option[Double],
	mnts             : Option[Double],
	minutes_per_game : Option[Double],
	minutes_pct      : Option[Double],
	minutes_90s      : Option[Double],
	games_starts     : Option[Double],
	games_complete   : Option[Double],
	games_subs       : Option[Double],
	unused_subs      : Option[Double],
	points_per_match : Option[Double],
	on_goals_for     : Option[Double],
	on_goals_against : Option[Double],
	plus_minus       : Option[Double],
	plus_minus_wowy  : Option[Double]
)

class PresenceStatsEntity(tag: Tag) extends Table[PresenceStats](tag, "PresenceStats") {
	def player           = column[Option[String]]("player");
	def games 			 = column[Option[Double]]("games");
	def mnts             = column[Option[Double]]("mnts");
	def minutes_per_game = column[Option[Double]]("minutes_per_game");
	def minutes_pct      = column[Option[Double]]("minutes_pct");
	def minutes_90s      = column[Option[Double]]("minutes_90s");
	def games_starts     = column[Option[Double]]("games_starts");
	def games_complete   = column[Option[Double]]("games_complete");
	def games_subs       = column[Option[Double]]("games_subs");
	def unused_subs      = column[Option[Double]]("unused_subs");
	def points_per_match = column[Option[Double]]("points_per_match");
	def on_goals_for     = column[Option[Double]]("on_goals_for");
	def on_goals_against = column[Option[Double]]("on_goals_against");
	def plus_minus       = column[Option[Double]]("plus_minus");
	def plus_minus_wowy  = column[Option[Double]]("plus_minus_wowy");

	def * = (player, games, mnts, minutes_per_game, minutes_pct, minutes_90s, games_starts, games_complete, games_subs, unused_subs, points_per_match, on_goals_for, on_goals_against, plus_minus, plus_minus_wowy) <> (PresenceStats.tupled, PresenceStats.unapply);
}
