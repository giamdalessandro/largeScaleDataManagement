package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class PlayerOrganization(
    id: Long,
    player: Option[String],
    squad: Option[String],
    comp: Option[String]
)

class PlayerOrganizationEntity(tag: Tag)
    extends Table[PlayerOrganization](tag, "PLAYER_ORGANIZATION") {
    def id = column[Long]("id", O.PrimaryKey);
    def player = column[Option[String]]("player_full_name");
    def squad = column[Option[String]]("squad");
    def comp = column[Option[String]]("comp");
    def * = (id, player, squad, comp) <> (PlayerOrganization.tupled, PlayerOrganization.unapply);
}
