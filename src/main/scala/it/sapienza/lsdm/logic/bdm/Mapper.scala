package it.sapienza.lsdm.logic.bdm

import org.apache.spark.sql.{SparkSession, DataFrame, Encoders, Row}
import it.sapienza.lsdm.model.bdm.{OffensiveAbility,OffensiveMentalAbility,OffensivePhysicalAbility,OffensiveTechnicalAbility}
import it.sapienza.lsdm.model.bdm.{GoalkeeperAbility}

object Mapper {
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

    // def player_defensive_ability_mapper(r: Row): PlayerDefensiveAbilityNR = {
    //     PlayerDefensiveAbilityNR(
    //         r.getLong(0),
    //         r.getString(1),
    //         r.getInt(2),
    //         MentalAbilityDef(r.getInt(3)),
    //         TechnicalAbilityDef(r.getInt(4),r.getInt(5),r.getInt(6))
    //     )
    // }

    // def player_goalkeeper_ability_mapper(r: Row): PlayerGoalkeeperAbilityNR = {
    //     PlayerGoalkeeperAbilityNR(
    //         r.getLong(0),
    //         r.getString(1),
    //         r.getInt(2),
    //         GoalkeeperAbilityGk(r.getInt(3),r.getInt(4),r.getInt(5),r.getInt(6))
    //     )
    // }

    // def player_playmaking_ability_mapper(r: Row): PlayerPlaymakingAbilityNR = {
    //     PlayerPlaymakingAbilityNR(
    //         r.getLong(0),
    //         r.getString(1),
    //         r.getInt(2),
    //         MentalAbilityPm(r.getInt(3),r.getInt(4),r.getInt(8)),
    //         TechnicalAbilityPm(r.getInt(5),r.getInt(6)),
    //         PhysicalAbilityPm(r.getInt(7))
    //     )
    // }
}
