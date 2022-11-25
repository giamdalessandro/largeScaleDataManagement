package it.sapienza.lsdm.model.bdm

case class DefensiveMentalAbility(
    agg: Int
)
case class DefensiveTechnicalAbility(
    tck: Int,
    pen: Int,
    mar: Int
)

case class DefensiveAbility(
    id: Long,
    ca: Int,
    mentalAbility: DefensiveMentalAbility,
    technicalAbility: DefensiveTechnicalAbility
)
