package it.sapienza.lsdm.model.bdm

case class MentalAbility(
    cnt: Int
)
case class PhysicalAbility(
    str: Int
)

case class TechnicalAbility(
    tec: Int,
    fin: Int
)

case class PlayerOffensiveAbilityNR(
    id: Long,
    ca: Int,
    mentalAbility: MentalAbility,
    physicalAbility: PhysicalAbility,
    technicalAbility: TechnicalAbility
)