package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class DefensivePerformance(
    playerDefensiveAbilityId : Option[Long],
    birthId                  : Option[Long],
    organizationId           : Option[Long],
    tackles                  : Option[Int],
    tacklesWon               : Option[Int],
    cards_yellow             : Option[Int],
    cards_red                : Option[Int]
)

class DefensivePerformanceEntity(tag: Tag) extends Table[DefensivePerformance](tag, "DEFENSIVE_PERFORMANCE") {
    def playerDefensiveAbilityId = column[Option[Long]]("player_id");
    // def player = foreignKey("player_fk", playerId, TableQuery[DefensiveAbilityEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

    def birthId = column[Option[Long]]("birth_id");
    def birth = foreignKey("birth_fk", birthId, TableQuery[BirthEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

    def organizationId = column[Option[Long]]("organization_id");
    def organization = foreignKey("organization_fk", organizationId, TableQuery[OrganizationEntity])(_.id)

    def pk = primaryKey("Defensive_performance_pk", (playerDefensiveAbilityId, birthId, organizationId))

    def tackles      = column[Option[Int]]("tackles")
    def tacklesWon   = column[Option[Int]]("tacklesWon")
    def cards_yellow = column[Option[Int]]("cards_yellow")
    def cards_red    = column[Option[Int]]("cards_red")

    def * = (playerDefensiveAbilityId, birthId, organizationId, tackles, tacklesWon, cards_yellow, cards_red) <> (DefensivePerformance.tupled, DefensivePerformance.unapply)
}


