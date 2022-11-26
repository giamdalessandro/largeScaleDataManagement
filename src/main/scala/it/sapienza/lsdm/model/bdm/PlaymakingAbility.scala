package it.sapienza.lsdm.model.bdm

case class PlaymakingMentalAbility(
    vis: Int,
    ldr: Int,
    cnt: Int
)
case class PlaymakingTechnicalAbility(
    pas: Int,
    dri: Int
)

case class PlaymakingPhysicalAbility(
    agi: Int
)

case class PlaymakingAbility(
    id: Long,
    ca: Int,
    mentalAbility: PlaymakingMentalAbility,
    technicalAbility: PlaymakingTechnicalAbility,
    physicalAbility: PlaymakingPhysicalAbility
)
