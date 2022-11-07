package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class Role(
    id: Option[Long],
    role_complete: Option[String],
    role_specific: Option[String],
    role_generic: Option[String]
)

class RoleEntity(tag: Tag) extends Table[Role](tag, "ROLE") {
    def id = column[Option[Long]]("id", O.PrimaryKey);
    def role_complete = column[Option[String]]("role_complete");
    def role_specific = column[Option[String]]("role_specific");
    def role_generic = column[Option[String]]("role_generic");
    def * = (id, role_complete, role_specific, role_generic) <> (Role.tupled, Role.unapply);
}
