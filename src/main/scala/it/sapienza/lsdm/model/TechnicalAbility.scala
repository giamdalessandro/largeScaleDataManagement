package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._


case class TechincalAbility(
	player : Option[String],
    tec : Option[Int],
    tck : Option[Int],
    pen : Option[Int],
    pas : Option[Int],
    mar : Option[Int],
	l_Th : Option[Int],
    lon : Option[Int],
    hea : Option[Int],
    fir : Option[Int],
    fin : Option[Int],
    dri : Option[Int],
    cro : Option[Int],
    cor : Option[Int]
)


class TechincalAbilityEntity(tag: Tag) extends Table[TechincalAbility](tag, "TechincalAbility") {
	def player = column[String]("player");
	def tec = column[Option[Int]]("tec");
    def tck = column[Option[Int]]("tck");
    def pen = column[Option[Int]]("pen");
    def pas = column[Option[Int]]("pas");
    def mar = column[Option[Int]]("mar");
	def lTh = column[Option[Int]]("l_Th");
    def lon = column[Option[Int]]("lon");
    def hea = column[Option[Int]]("hea");
    def fir = column[Option[Int]]("fir");
    def fin = column[Option[Int]]("fin");
    def dri = column[Option[Int]]("dri");
    def cro = column[Option[Int]]("cro");
    def cor = column[Option[Int]]("cor");

	def * = (player.?, tec, tck, pen, pas, mar, lTh, lon, hea, fir, fin, dri, cro, cor) <> (TechincalAbility.tupled, TechincalAbility.unapply);
}
