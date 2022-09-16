package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class OffensivePerformance(
    playerOffensiveAbilityId: Option[Long],
    birthId: Option[Long],
    organizationId: Option[Long],
    goals: Option[Int],
    shotsTotal: Option[Int],
    shotsOnTarget: Option[Int],
    pensMade: Option[Int]
)

class OffensivePerformanceEntity(tag: Tag) extends Table[OffensivePerformance](tag, "OFFENSIVE_PERFORMANCE") {
    def playerOffensiveAbilityId = column[Option[Long]]("player_id");
    // def player = foreignKey("player_fk", playerId, TableQuery[OffensiveAbilityEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

    def birthId = column[Option[Long]]("birth_id");
    def birth = foreignKey("birth_fk", birthId, TableQuery[BirthEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

    def organizationId = column[Option[Long]]("organization_id");
    def organization = foreignKey("organization_fk", organizationId, TableQuery[OrganizationEntity])(_.id)

    def pk = primaryKey("offensive_performance_pk", (playerOffensiveAbilityId, birthId, organizationId))

    def goals = column[Option[Int]]("goals")
    def shotsTotal = column[Option[Int]]("shots_toal")
    def shotsOnTarget = column[Option[Int]]("shots_on_target")
    def pensMade = column[Option[Int]]("pens_made")

    def * = (playerOffensiveAbilityId, birthId, organizationId, goals, shotsTotal, shotsOnTarget, pensMade) <> (OffensivePerformance.tupled, OffensivePerformance.unapply)
}
