package it.sapienza.lsdm.model.bdm

case class PersonalData(
    name: String
)
case class FootballData(
    position: String,
    foot: String
)

case class PlayerNR(
    personalData: PersonalData,
    footballData: FootballData
)