package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class Organization(
    id      : Long,
    squad   : Option[String],
    comp    : Option[String]
)

class OrganizationEntity(tag: Tag) extends Table[Organization](tag, "ORGANIZATION") {
    def id      = column[Long]("id", O.PrimaryKey, O.AutoInc);
    def squad   = column[Option[String]]("squad");
    def comp    = column[Option[String]]("comp");
    def * = (id, squad, comp) <> (Organization.tupled, Organization.unapply);
}
