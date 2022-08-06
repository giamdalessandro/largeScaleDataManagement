package it.sapienza.lsdm.model.bdm

import slick.jdbc.PostgresProfile.api._

final case class OffensiveAbility(
    id  : Option[Long],
    ca  : Option[Int],
    str : Option[Int],
    tec : Option[Int],
    fin : Option[Int],
    cnt : Option[Int]
)

class OffensiveAbilityEntity(tag: Tag) extends Table[OffensiveAbility](tag, "OFFENSIVE_ABILITY") {
    def id  = column[Option[Long]]("id", O.PrimaryKey);
    def ca  = column[Option[Int]]("ca");
    def str = column[Option[Int]]("str");
    def tec = column[Option[Int]]("tec");
    def fin = column[Option[Int]]("fin");
    def cnt = column[Option[Int]]("cnt");
    def * = (id, ca, str, tec, fin, cnt) <> (OffensiveAbility.tupled, OffensiveAbility.unapply);
}
