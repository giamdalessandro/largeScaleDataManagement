package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class BelongsTo(
    club:   Option[String],
    league: Option[String]
)


class BelongsToEntity(tag: Tag) extends Table[BelongsTo](tag, "BelongsTo") {
    def club    = column[Option[String]]("club")
    def league  = column[Option[String]]("league")
	
	val clubFK = TableQuery[ClubEntity]
	def club_fk = foreignKey("club_fk", club, clubFK)(_.name, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
	val leagueFK = TableQuery[LeagueEntity]	
	def league_fk = foreignKey("league_fk", league, leagueFK)(_.name, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)

    def * = (club, league) <> (BelongsTo.tupled, BelongsTo.unapply)
}