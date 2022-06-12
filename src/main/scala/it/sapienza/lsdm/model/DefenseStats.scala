package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class DefenseStats(
    pid           : Option[String],
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
	errors        : Option[Double] 
)


class DefenseStatsEntity(tag: Tag) extends Table[DefenseStats](tag, "DefenseStats") {
	def pid           = column[String]("pid");
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
	
    def * = (pid.?, tackles, tacklesWon, press, pressReg, pressRegPct, blocks, blockedSht, blockedShtSav, intercept, clearence, errors) <> (DefenseStats.tupled, DefenseStats.unapply)
}