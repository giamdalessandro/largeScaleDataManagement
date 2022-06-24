package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class GoalkeeperAbility(
	player : Option[String],
	tRO : Option[Int],
	one : Option[Int],
	han : Option[Int],
	cmd : Option[Int]
)


class GoalkeeperAbilityEntity(tag: Tag) extends Table[GoalkeeperAbility](tag, "GoalkeeperAbility") {
	def player = column[String]("player");
	def tRO = column[Option[Int]]("tRO");
	def one = column[Option[Int]]("1v1");
	def han = column[Option[Int]]("han");
	def cmd = column[Option[Int]]("cmd");
	def * = (player.?, tRO, one, han, cmd) <> (GoalkeeperAbility.tupled, GoalkeeperAbility.unapply)
}


