package it.sapienza.lsdm.model.bdm


case class MentalAbilityPm(
    vis: Int,
    tea: Int
)
case class TechnicalAbilityPm(
    pas: Int,
    dri: Int
)

case class PlayerPlaymakingAbilityNR(
    id: Long,
    playerFullName: String,
    ca: Int,
    mentalAbility    : MentalAbilityPm,
    technicalAbility : TechnicalAbilityPm
)

