package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class DefensivePerformance(
    defensiveAbilityId: Option[Long],
    birthId: Option[Long],
    roleId: Option[Long],
    playerOrganizationId: Option[Long],
    tackles: Option[Int],
    tacklesWon: Option[Int],
    cards_yellow: Option[Int],
    cards_red: Option[Int]
)

class DefensivePerformanceEntity(tag: Tag)
    extends Table[DefensivePerformance](tag, "DEFENSIVE_PERFORMANCE") {
    def defensiveAbilityId = column[Option[Long]]("defensive_ability_id");

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
      "defensive_performance_pk",
      (defensiveAbilityId, birthId, roleId, playerOrganizationId)
    )

    def tackles = column[Option[Int]]("tackles")
    def tacklesWon = column[Option[Int]]("tacklesWon")
    def cards_yellow = column[Option[Int]]("cards_yellow")
    def cards_red = column[Option[Int]]("cards_red")

    def * = (
      defensiveAbilityId,
      birthId,
      roleId,
      playerOrganizationId,
      tackles,
      tacklesWon,
      cards_yellow,
      cards_red
    ) <> (DefensivePerformance.tupled, DefensivePerformance.unapply)
}
