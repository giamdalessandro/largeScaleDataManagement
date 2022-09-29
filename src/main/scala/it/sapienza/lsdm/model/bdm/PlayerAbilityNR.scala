package it.sapienza.lsdm.model.bdm


case class MentalAbilityNR(
    vis: Int,
    tea: Int,
    cnt: Int,
    agg: Int,
    //wor: Int,
    //dfn: Int,
    //otb: Int,
    //ldr: Int,
    //fla: Int,
)
case class PhysicalAbilityNR(
    str: Int,
    //sta: Int,
    //pac: Int,
    //jum: Int,
    //agi: Int,
    //aer: Int,
    //acc: Int
)
case class TechnicalAbilityNR(
    tec: Int,
    tck: Int,
    pen: Int,
    pas: Int,
    mar: Int,
    fin: Int,
    dri: Int,
    //l_Th: Int,
    //lon: Int,
    //hea: Int,
    //fir: Int,
    //cro: Int,
    //cor: Int
)
case class GoalkeeperAbilityNR(
    tRO: Int,
    v1:  Int,   // 1v1
    han: Int,
    cmd: Int
)

case class PlayerAbilityNR(
    id: Long,
    playerFullName: String,
    ca: Int,
    mentalAbility    : MentalAbilityNR,
    physicalAbility  : PhysicalAbilityNR,
    technicalAbility : TechnicalAbilityNR,
    goalkeeperAbility: GoalkeeperAbilityNR
)
