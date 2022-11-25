package it.sapienza.lsdm.model.bdm

case class MentalAbilityPm(
    vis: Int,
    ldr: Int,
    cnt: Int
)
case class TechnicalAbilityPm(
    pas: Int,
    dri: Int
)

case class PhysicalAbilityPm(
    agi: Int
)

case class PlayerPlaymakingAbilityNR(
    id: Long,
    playerFullName: String,
    ca: Int,
    mentalAbility: MentalAbilityPm,
    technicalAbility: TechnicalAbilityPm,
    physicalAbility: PhysicalAbilityPm
)
