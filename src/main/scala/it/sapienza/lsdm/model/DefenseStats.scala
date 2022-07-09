package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class DefenseStats(
    player        : Option[String],
	squad         : Option[String],
	tackles       : Option[Double],
	tacklesWon    : Option[Double],
	press		  : Option[Double],
	pressReg      : Option[Double],
	pressRegPct   : Option[Double],
	blocks        : Option[Double],
	blockedSht    : Option[Double],
	blockedShtSav : Option[Double],
	intercept     : Option[Double],
	clearence     : Option[Double],
	errors        : Option[Double],
	fouls 			: Option[Double],
	aerials_won 	: Option[Double],
	aerials_won_pct : Option[Double],
	cards_yellow 	: Option[Double],
	cards_red 		: Option[Double]
)


class DefenseStatsEntity(tag: Tag) extends Table[DefenseStats](tag, "DefenseStats") {
	def player        = column[Option[String]]("player");
	def squad         = column[Option[String]]("squad");
	def tackles       = column[Option[Double]]("tackles");
	def tacklesWon    = column[Option[Double]]("tacklesWon");
	def press         = column[Option[Double]]("press");
	def pressReg      = column[Option[Double]]("pressReg");
	def pressRegPct   = column[Option[Double]]("pressRegPct");
	def blocks        = column[Option[Double]]("blocks");
	def blockedSht    = column[Option[Double]]("blockedSht");
	def blockedShtSav = column[Option[Double]]("blockedShtSav");
	def intercept     = column[Option[Double]]("intercept");
	def clearence     = column[Option[Double]]("clearence");
	def errors        = column[Option[Double]]("errors");
	def fouls 			= column[Option[Double]]("fouls");
	def aerials_won 	= column[Option[Double]]("aerials_won");
	def aerials_won_pct = column[Option[Double]]("aerials_won_pct");
	def cards_yellow 	= column[Option[Double]]("cards_yellow");
	def cards_red 		= column[Option[Double]]("cards_red");
	
    def * = (player, squad, tackles, tacklesWon, press, pressReg, pressRegPct, blocks, blockedSht, blockedShtSav, intercept, clearence, errors, fouls, aerials_won, aerials_won_pct, cards_yellow, cards_red) <> (DefenseStats.tupled, DefenseStats.unapply)
}