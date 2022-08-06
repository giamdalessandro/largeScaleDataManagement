package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class OffensivePerformance(
    abilityId       : Option[Long],
    presenceId      : Option[Long],
    organizationId  : Option[Long],
    countryOB       : String,
    player          : String,
    goals           : Option[Int],
    shotsTotal      : Option[Int],
    shotsOnTarget   : Option[Int],
    pensMade        : Option[Int]
)

class OffensivePerformanceEntity(tag: Tag) extends Table[OffensivePerformance](tag, "OFFENSIVE_PERFORMANCE") {
    def abilityId       = column[Option[Long]]("ability_id");
    def ability         = foreignKey("ability_fk", abilityId, TableQuery[OffensiveAbilityEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

    def presenceId      = column[Option[Long]]("presence_id");
    def presence        = foreignKey("presence_fk", presenceId, TableQuery[PresenceEntity])(_.id, onDelete = ForeignKeyAction.Cascade)

    def organizationId  = column[Option[Long]]("organization_id");
    def organization    = foreignKey("organization_fk", organizationId, TableQuery[OrganizationEntity])(_.id)

    def countryOB       = column[String]("country_ob");

    def pk              = primaryKey("offensive_performance_pk", (abilityId, presenceId, organizationId, countryOB))

    def player          = column[String]("player")
    def goals           = column[Option[Int]]("goals")
    def shotsTotal      = column[Option[Int]]("shots_toal")
    def shotsOnTarget   = column[Option[Int]]("shots_on_target")
    def pensMade        = column[Option[Int]]("pens_made")
    def * = (abilityId, presenceId, organizationId, countryOB, player, goals, shotsTotal, shotsOnTarget, pensMade) <> (OffensivePerformance.tupled, OffensivePerformance.unapply)
}
