package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class PlaymakingStats(
	player          	   : Option[String],
	squad         		   : Option[String],
	sca    				   : Option[Double],
    sca90  				   : Option[Double],
    gca    				   : Option[Double],
    gca90  				   : Option[Double],
	assists                : Option[Double],
	assists_per90 		   : Option[Double],	
	touches         	   : Option[Double],
	touches_def_3rd 	   : Option[Double],
	touches_mid_3rd 	   : Option[Double],
	touches_att_3rd 	   : Option[Double],
	touches_att_pen_area   : Option[Double],
	dribbles_completed     : Option[Double],
	dribbles 			   : Option[Double],
	dribbles_completed_pct : Option[Double],
	miscontrols            : Option[Double],
	dispossessed           : Option[Double],
	pass_targets           : Option[Double],
	fouled 				   : Option[Double],
)


class PlaymakingStatsEntity(tag: Tag) extends Table[PlaymakingStats](tag, "PlaymakingStats") {
	def player  			   = column[Option[String]]("player");
	def squad         		   = column[Option[String]]("squad");
	def sca     			   = column[Option[Double]]("sca");
    def sca90   			   = column[Option[Double]]("sca90");
    def gca     			   = column[Option[Double]]("gca");
    def gca90   			   = column[Option[Double]]("gca90");
	def assists         	   = column[Option[Double]]("assists");
	def assists_per90 		   = column[Option[Double]]("assists_per90");
	def touches 			   = column[Option[Double]]("touches");
	def touches_def_3rd 	   = column[Option[Double]]("touches_def_3rd");
	def touches_mid_3rd 	   = column[Option[Double]]("touches_mid_3rd");
	def touches_att_3rd 	   = column[Option[Double]]("touches_att_3rd");
	def touches_att_pen_area   = column[Option[Double]]("touches_att_pen_area");
	def dribbles_completed     = column[Option[Double]]("dribbles_completed");
	def dribbles 			   = column[Option[Double]]("dribbles");
	def dribbles_completed_pct = column[Option[Double]]("dribbles_completed_pct");
	def miscontrols  		   = column[Option[Double]]("miscontrols");
	def dispossessed 		   = column[Option[Double]]("dispossessed");
	def pass_targets 		   = column[Option[Double]]("pass_targets");
	def fouled				   = column[Option[Double]]("fouled");

	def * = (player, squad, sca, sca90, gca, gca90, assists, assists_per90, touches, touches_def_3rd, touches_mid_3rd, touches_att_3rd, touches_att_pen_area, dribbles_completed, dribbles, dribbles_completed_pct, miscontrols, dispossessed, pass_targets, fouled) <> (PlaymakingStats.tupled, PlaymakingStats.unapply)
}
