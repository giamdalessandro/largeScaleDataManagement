package it.sapienza.lsdm.model.bdm


case class GoalkeeperAbilityGk(
    tRO: Int,
    v1:  Int,   // 1v1
    han: Int,
    cmd: Int
)

case class PlayerGoalkeeperAbilityNR(
    id: Long,
    playerFullName: String,
    ca: Int,
    goalkeeperAbility: GoalkeeperAbilityGk
)

