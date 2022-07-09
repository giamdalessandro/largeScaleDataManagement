package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class PhysicalAbility(
	player : Option[String],
	str : Option[Int],
    sta : Option[Int],
    pac : Option[Int],
    jum : Option[Int],
    agi : Option[Int],
    aer : Option[Int],
    acc : Option[Int]
)


class PhysicalAbilityEntity(tag: Tag) extends Table[PhysicalAbility](tag, "PhysicalAbility") {
	def player = column[String]("player");
	def str = column[Option[Int]]("str");
	def sta = column[Option[Int]]("sta");
	def pac = column[Option[Int]]("pac");
	def jum = column[Option[Int]]("jum");
	def agi = column[Option[Int]]("agi");
	def aer = column[Option[Int]]("aer");
	def acc = column[Option[Int]]("acc");
	def * = (player.?, str, sta, pac, jum, agi,aer, acc) <> (PhysicalAbility.tupled, PhysicalAbility.unapply)
}


