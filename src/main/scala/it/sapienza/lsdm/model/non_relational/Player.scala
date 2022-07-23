package it.sapienza.lsdm.model.non_relational

case class PersonalData(
    name: String
)
case class FootballData(
    position: String,
    foot: String
)

case class Player(
    personalData: Map[String, String],
    footballData: FootballData
)