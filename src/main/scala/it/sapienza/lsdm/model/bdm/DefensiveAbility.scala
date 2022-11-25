package it.sapienza.lsdm.model.bdm


case class MentalAbilityDef(
    agg: Int,
)
case class TechnicalAbilityDef(
    tck: Int,
    pen: Int,
    mar: Int
)

case class PlayerDefensiveAbilityNR(
    id: Long,
    playerFullName: String,
    ca: Int,
    mentalAbility    : MentalAbilityDef,
    technicalAbility : TechnicalAbilityDef
)
