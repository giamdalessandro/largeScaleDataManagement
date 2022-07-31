package it.sapienza.lsdm.model.relational

import slick.jdbc.PostgresProfile.api._


case class MentalAbility(
	player : Option[String],
	wor    : Option[Int],
	vis    : Option[Int],
	tea    : Option[Int],
	ref    : Option[Int],
	otb    : Option[Int],
	ldr    : Option[Int],
	fla    : Option[Int],
	cnt    : Option[Int],
	agg    : Option[Int]
)


class MentalAbilityEntity(tag: Tag) extends Table[MentalAbility](tag, "MentalAbility") {
	def player = column[String]("player");
	def wor   = column[Option[Int]]("wor");
	def vis   = column[Option[Int]]("vis");
	def tea   = column[Option[Int]]("tea");
	def ref   = column[Option[Int]]("def");
	def otb   = column[Option[Int]]("otb");
	def ldr   = column[Option[Int]]("ldr");
	def fla   = column[Option[Int]]("fla");
	def cnt   = column[Option[Int]]("cnt");
	def agg   = column[Option[Int]]("agg");

	def * = (player.?, wor, vis, tea, ref, otb, ldr, fla, cnt, agg) <> (MentalAbility.tupled, MentalAbility.unapply)
}

