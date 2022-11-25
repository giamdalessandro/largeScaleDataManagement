// package it.sapienza.lsdm.model.bdm

// import slick.jdbc.PostgresProfile.api._

// final case class GoalkeeperPerformance(
//     playerGoalkeeperAbilityId : Option[Long],
//     birthId                  : Option[Long],
//     roleId                   : Option[Long],
//     organizationId           : Option[Long],
//     goal_against_gk          : Option[Int],
//     shots_on_target_against  : Option[Int],
//     saves                    : Option[Int],
//     pen_saves_pct            : Option[Double]
// )

// class GoalkeeperPerformanceEntity(tag: Tag) extends Table[GoalkeeperPerformance](tag, "GOALKEEPER_PERFORMANCE") {
//     def playerGoalkeeperAbilityId = column[Option[Long]]("player_id");
//     // def player = foreignKey("player_fk", playerId, TableQuery[GoalkeeperAbilityEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

//     def birthId = column[Option[Long]]("birth_id");
//     def birth = foreignKey("birth_fk", birthId, TableQuery[BirthEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

//     def roleId = column[Option[Long]]("role_id");
//     def role   = foreignKey("role_fk", roleId, TableQuery[RoleEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

//     def organizationId = column[Option[Long]]("organization_id");
//     def organization = foreignKey("organization_fk", organizationId, TableQuery[OrganizationEntity])(_.id)

//     def pk = primaryKey("Goalkeeper_performance_pk", (playerGoalkeeperAbilityId, birthId, organizationId))

//     def goal_against_gk         = column[Option[Int]]("goal_against_gk")
//     def shots_on_target_against = column[Option[Int]]("shots_on_target_against")
//     def saves                   = column[Option[Int]]("saves")
//     def pen_saves_pct           = column[Option[Double]]("pen_saves_pct")

//     def * = (playerGoalkeeperAbilityId, birthId, roleId, organizationId, goal_against_gk, shots_on_target_against,
//              saves, pen_saves_pct) <> (GoalkeeperPerformance.tupled, GoalkeeperPerformance.unapply)
// }

