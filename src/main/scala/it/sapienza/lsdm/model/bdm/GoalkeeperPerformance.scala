package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class GoalkeeperPerformance(
    goalkeeperAbilityId: Option[Long],
    birthId: Option[Long],
    roleId: Option[Long],
    playerOrganizationId: Option[Long],
    goal_against_gk: Option[Int],
    shots_on_target_against: Option[Int],
    saves: Option[Int],
    pen_saves_pct: Option[Double]
)

class GoalkeeperPerformanceEntity(tag: Tag)
    extends Table[GoalkeeperPerformance](tag, "GOALKEEPER_PERFORMANCE") {

    def goalkeeperAbilityId = column[Option[Long]]("goalkeeper_ability_id");

    def birthId = column[Option[Long]]("birth_id");
    def birth = foreignKey("birth_fk", birthId, TableQuery[BirthEntity])(
      _.id,
      onDelete = ForeignKeyAction.Cascade
    )

    def roleId = column[Option[Long]]("role_id");
    def role = foreignKey("role_fk", roleId, TableQuery[RoleEntity])(
      _.id,
      onDelete = ForeignKeyAction.Cascade
    )

    def playerOrganizationId = column[Option[Long]]("player_organization_id");
    def playerOrganization = foreignKey(
      "player_organization_fk",
      playerOrganizationId,
      TableQuery[PlayerOrganizationEntity]
    )(_.id)

    def pk = primaryKey(
      "goalkeeper_performance_pk",
      (goalkeeperAbilityId, birthId, roleId, playerOrganizationId)
    )

    def goal_against_gk = column[Option[Int]]("goal_against_gk")
    def shots_on_target_against = column[Option[Int]]("shots_on_target_against")
    def saves = column[Option[Int]]("saves")
    def pen_saves_pct = column[Option[Double]]("pen_saves_pct")

    def * = (
      goalkeeperAbilityId,
      birthId,
      roleId,
      playerOrganizationId,
      goal_against_gk,
      shots_on_target_against,
      saves,
      pen_saves_pct
    ) <> (GoalkeeperPerformance.tupled, GoalkeeperPerformance.unapply)
}
