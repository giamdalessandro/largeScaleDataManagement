package it.sapienza.lsdm.logic.bdm

import org.apache.spark.sql.{SparkSession, DataFrame, Encoders, Row}
import it.sapienza.lsdm.model.bdm.{GoalkeeperAbility}
import it.sapienza.lsdm.model.bdm.{DefensiveAbility,DefensiveMentalAbility,DefensiveTechnicalAbility}
import it.sapienza.lsdm.model.bdm.{PlaymakingAbility,PlaymakingMentalAbility,PlaymakingTechnicalAbility,PlaymakingPhysicalAbility}
import it.sapienza.lsdm.model.bdm.{OffensiveAbility,OffensiveMentalAbility,OffensivePhysicalAbility,OffensiveTechnicalAbility}


object Mapper {
    def goalkeeper_ability_mapper(r: Row): GoalkeeperAbility = {
        val id = r.getAs[Long]("id")
        val ca = r.getAs[Int]("ca")
        val tro = r.getAs[Int]("tro")
        val v1 = r.getAs[Int]("v1")
        val han = r.getAs[Int]("han")
        val cmd = r.getAs[Int]("cmd")

        GoalkeeperAbility(
            id,
            ca,
            tro,
            v1,
            han,
            cmd
        )
    }

    def defensive_ability_mapper(r: Row): DefensiveAbility = {
        val id = r.getAs[Long]("id")
        val ca = r.getAs[Int]("ca")
        val agg = r.getAs[Int]("agg")
        val tck = r.getAs[Int]("tck")
        val pen = r.getAs[Int]("pen")
        val mar = r.getAs[Int]("mar")

        DefensiveAbility(
            id,
            ca,
            DefensiveMentalAbility(agg),
            DefensiveTechnicalAbility(tck, pen, mar)
        )
    }

    def playmaking_ability_mapper(r: Row): PlaymakingAbility = {
        val id = r.getAs[Long]("id")
        val ca = r.getAs[Int]("ca")
        val vis = r.getAs[Int]("vis")
        val ldr = r.getAs[Int]("ldr")
        val pas = r.getAs[Int]("pas")
        val dri = r.getAs[Int]("dri")
        val agi = r.getAs[Int]("agi")
        val cnt = r.getAs[Int]("cnt")

        PlaymakingAbility(
            id,
            ca,
            PlaymakingMentalAbility(vis,ldr,cnt),
            PlaymakingTechnicalAbility(pas,dri),
            PlaymakingPhysicalAbility(agi)
        )
    }

    def offensive_ability_mapper(r: Row): OffensiveAbility = {
        val id = r.getAs[Long]("id")
        val ca = r.getAs[Int]("ca")
        val cnt = r.getAs[Int]("cnt")
        val str = r.getAs[Int]("str")
        val tec = r.getAs[Int]("tec")
        val fin = r.getAs[Int]("fin")

        OffensiveAbility(
            id,
            ca,
            OffensiveMentalAbility(cnt),
            OffensivePhysicalAbility(str),
            OffensiveTechnicalAbility(tec, fin)
        )
    }
}
