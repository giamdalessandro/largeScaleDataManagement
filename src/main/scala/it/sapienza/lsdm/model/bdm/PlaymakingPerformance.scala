package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class PlaymakingPerformance(
    playerPlaymakingAbilityId : Option[Long],
    birthId                   : Option[Long],
    roleId                    : Option[Long],
    organizationId            : Option[Long],
    assists                   : Option[Int],
    touches                   : Option[Int],
    dribbles                  : Option[Int],
    pass_targets              : Option[Int]
)

class PlaymakingPerformanceEntity(tag: Tag) extends Table[PlaymakingPerformance](tag, "PLAYMAKING_PERFORMANCE") {
    def playerPlaymakingAbilityId = column[Option[Long]]("player_id");
    // def player = foreignKey("player_fk", playerId, TableQuery[PlaymakingAbilityEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

    def birthId = column[Option[Long]]("birth_id");
    def birth = foreignKey("birth_fk", birthId, TableQuery[BirthEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

    def roleId = column[Option[Long]]("role_id");
    def role   = foreignKey("role_fk", roleId, TableQuery[RoleEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

    def organizationId = column[Option[Long]]("organization_id");
    def organization = foreignKey("organization_fk", organizationId, TableQuery[OrganizationEntity])(_.id)

    def pk = primaryKey("Playmaking_performance_pk", (playerPlaymakingAbilityId, birthId, organizationId))

    def assists      = column[Option[Int]]("assists")
    def touches      = column[Option[Int]]("touches")
    def dribbles     = column[Option[Int]]("dribbles")
    def pass_targets = column[Option[Int]]("pass_targets")

    def * = (playerPlaymakingAbilityId, birthId, roleId, organizationId, assists, touches, dribbles, 
            pass_targets) <> (PlaymakingPerformance.tupled, PlaymakingPerformance.unapply)
}


