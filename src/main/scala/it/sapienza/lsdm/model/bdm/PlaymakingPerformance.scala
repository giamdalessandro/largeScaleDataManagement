package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class PlaymakingPerformance(
    playmakingAbilityId: Option[Long],
    birthId: Option[Long],
    roleId: Option[Long],
    playerOrganizationId: Option[Long],
    assists: Option[Int],
    dribbles: Option[Int],
    sca: Option[Int],
    sca90: Option[Double],
    pass_targets: Option[Int],
    miscontrols: Option[Int],
    dispossessed: Option[Int],
    fouled: Option[Int]
)

class PlaymakingPerformanceEntity(tag: Tag)
    extends Table[PlaymakingPerformance](tag, "PLAYMAKING_PERFORMANCE") {
    
    def playmakingAbilityId = column[Option[Long]]("playmaking_ability_id");

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
      "playmaking_performance_pk",
      (playmakingAbilityId, birthId, roleId, playerOrganizationId)
    )

    def assists = column[Option[Int]]("assists")
    def dribbles = column[Option[Int]]("dribbles")
    def sca = column[Option[Int]]("sca")
    def sca90 = column[Option[Double]]("sca_90")
    def pass_targets = column[Option[Int]]("pass_targets")
    def miscontrols = column[Option[Int]]("miscontrols")
    def dispossessed = column[Option[Int]]("dispossessed")
    def fouled = column[Option[Int]]("fouled")

    def * = (
      playmakingAbilityId,
      birthId,
      roleId,
      playerOrganizationId,
      assists,
      dribbles,
      sca,
      sca90,
      pass_targets,
      miscontrols,
      dispossessed,
      fouled
    ) <> (PlaymakingPerformance.tupled, PlaymakingPerformance.unapply)
}
