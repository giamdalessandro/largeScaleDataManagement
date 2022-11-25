package it.sapienza.lsdm.model.bdm

case class OffensiveMentalAbility(
    cnt: Int
)
case class OffensivePhysicalAbility(
    str: Int
)

case class OffensiveTechnicalAbility(
    tec: Int,
    fin: Int
)

case class OffensiveAbility(
    id: Long,
    ca: Int,
    mentalAbility: OffensiveMentalAbility,
    physicalAbility: OffensivePhysicalAbility,
    technicalAbility: OffensiveTechnicalAbility
)