package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class OffensivePerformance(
    offensiveAbilityId: Option[Long],
    birthId: Option[Long],
    roleId: Option[Long],
    playerOrganizationId: Option[Long],
    goals: Option[Int],
    shotsTotal: Option[Int],
    shotsOnTarget: Option[Int],
    pensMade: Option[Int]
)

class OffensivePerformanceEntity(tag: Tag) extends Table[OffensivePerformance](tag, "OFFENSIVE_PERFORMANCE") {
    def offensiveAbilityId = column[Option[Long]]("offensive_ability_id");
    // def player = foreignKey("player_fk", playerId, TableQuery[OffensiveAbilityEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

    def birthId = column[Option[Long]]("birth_id");
    def birth = foreignKey("birth_fk", birthId, TableQuery[BirthEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

    def roleId = column[Option[Long]]("role_id");
    def role = foreignKey("role_fk", roleId, TableQuery[RoleEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

    def playerOrganizationId = column[Option[Long]]("player_organization_id");
    def playerOrganization = foreignKey("player_organization_fk", playerOrganizationId, TableQuery[PlayerOrganizationEntity])(_.id)

    def pk = primaryKey("offensive_performance_pk", (offensiveAbilityId, birthId, roleId, playerOrganizationId))

    def goals = column[Option[Int]]("goals")
    def shotsTotal = column[Option[Int]]("shots_toal")
    def shotsOnTarget = column[Option[Int]]("shots_on_target")
    def pensMade = column[Option[Int]]("pens_made")

    def * = (offensiveAbilityId, birthId, roleId, playerOrganizationId, goals, shotsTotal, shotsOnTarget, pensMade) <> (OffensivePerformance.tupled, OffensivePerformance.unapply)
}
