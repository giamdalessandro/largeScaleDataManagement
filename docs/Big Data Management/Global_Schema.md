# Relational

## GoalkeeperPerformance

| Multidimensional Model | Arity | Description |
| --- | --- | --- |
| FACT | 8 | Contains players real statistics meaningful for summarizing their performance as goalkeepers. |

| Attribute | Description |
| --- | --- |
| goalkeeper_ability_id | Reference to *GoalkeeperAbility* data |
| birth_id | Fk toward *Birth* relation |
| role_id | Fk toward *Role* relation |
| player_organization_id | Fk toward *PlayerOrganization* relation |
| goal_against_gk | Goals against |
| shots_on_target_against | Shots on targets against |
| saves | Number of saves |
| pen_saves_pct | Percentage of penalty kicks saved (penalty shots that miss the target are not included) |

## DefensivePerformance

| Multidimensional Model | Arity | Description |
| --- | --- | --- |
| FACT | 8 | Contains players real statistics meaningful for summarizing their defensive performance. |

| Attribute | Description |
| --- | --- |
| defensive_ability_id | Reference to *DefensiveAbility* data |
| birth_id | Fk toward *Birth* relation |
| role_id | Fk toward *Role* relation |
| player_organization_id | Fk toward *PlayerOrganization* relation |
| tackles | Number of players tackled |
| tacklesWon | Tackles in which the tackler's team won possession of the ball |
| cards_yellow | Yellow cards |
| cards_red | Red cards |

## PlaymakingPerformance

| Multidimensional Model | Arity | Description |
| --- | --- | --- |
| FACT | 12 | Contains players real statistics meaningful for summarizing their performance playmaking-related. |

| Attribute | Description |
| --- | --- |
| playmaking_ability_id | Reference to *PlaymakingAbility* data |
| birth_id | Fk toward *Birth* relation |
| role_id | Fk toward *Role* relation |
| player_organization_id | Fk toward *PlayerOrganization* relation |
| assists | Assists |
| dribbles | Dribbles attempted |
| sca | Shot-Creating Actions: the two offensive actions directly leading to a shot, such as passes, dribbles and drawing fouls |
| sca_90 | Shot-Creating Actions per 90 minutes |
| pass_targets | Number of times a player was the target of an attempted pass |
| miscontrols | Number of times a player failed when attempting to gain control of a ball |
| dispossessed | Number of times a player loses control of the ball after being tackled by an opposing player. Does not include attempted dribbles |
| fouled | Fouls drawn |

## OffensivePerformance

| Multidimensional Model | Arity | Description |
| --- | --- | --- |
| FACT | 8 | Contains players real statistics meaningful for summarizing their offensive performance. |

| Attribute | Description |
| --- | --- |
| offensive_ability_id | Reference to *OffensiveAbility* data |
| birth_id | Fk toward *Birth* relation |
| role_id | Fk toward *Role* relation |
| player_organization_id | Fk toward *PlayerOrganization* relation |
| goals | Goals |
| shots_total | Shots total (does not include penalty kicks) |
| shots_on_target | Shots on target |
| pens_made | Penalty kicks Made |

## PlayerOrganization

| Multidimensional Model | Arity | Description |
| --- | --- | --- |
| DIMENSION | 4 | Contains players full names and the squads and the national competitions to which they belong. |

| Attribute | Description |
| --- | --- |
| id | Numerical unique identifier |
| player_full_name | Player’s full name |
| squad | Player's squad |
| comp | National competition in which the squad plays |

## Role

| Multidimensional Model | Arity | Description |
| --- | --- | --- |
| DIMENSION | 4 | Contains information about the roles assumed by players on pitch with different levels of precision. |

| Attribute | Description |
| --- | --- |
| id | Numerical unique identifier |
| role_complete | Full role specification (generic + specific) |
| role_specific | Deeper specification of role inside the basic category |
| role_generic | Role classification within the 4 basic categories: goalkeepers (GK), defenders (DF), midfielders (MF), forwards (FW) |

## Birth

| Multidimensional Model | Arity | Description |
| --- | --- | --- |
| DIMENSION | 3 | Contains players’ cities and countries of birth. |

| Attribute | Description |
| --- | --- |
| id | Numerical unique identifier |
| city | Player’s city of birth |
| country | Player’s country of birth |

# Non-relational

## GoalkeeperAbility

| Multidimensional Model | Arity | Description |
| --- | --- | --- |
| DIMENSION | 6 | Contains most relevant fictional attributes related to players’ ability as goalkeepers. |

| Hierarchy Lvl | Attribute | Description |
| --- | --- | --- |
| Root | id | Numerical unique identifier |
| Root | ca | Current Ability of player (hidden attribute in FM20) |
| Root | tro | Rushing out (tendency); goalkeeper's tendency to come off his line to react to through ball and crosses |
| Root | v1 | One vs One; goalkeeper's ability to do well when faced with an opponent in a one-vs-one situation |
| Root | han | Handling; goalkeeper's ability to hold onto the ball when making a save |
| Root | cmd | Command of Area; goalkeeper's ability to instinctively take charge of his penalty area by coming crosses and commanding his defensive line |

## DefensiveAbility

| Multidimensional Model | Arity | Description |
| --- | --- | --- |
| DIMENSION | 6 | Contains most relevant fictional attributes related to players’ defensive ability. |

| Hierarchy Lvl | Attribute | Description |
| --- | --- | --- |
| Root | id | Numerical unique identifier |
| Root | ca | Current Ability of player (hidden attribute in FM20) |
| Mental Ability | agg | Aggression; player willingness to get stuck in perhaps at expense of giving away more fouls |
| Technical Ability | tck | Tackling; player's ability to win the ball cleanly without conceding foul in such situations |
| Technical Ability | pen | Penalty Taking; player's ability from the penalty spot |
| Technical Ability | mar | Marking; player's ability to stick close to his direct opposition in defensive situations |

## PlaymakingAbility

| Multidimensional Model | Arity | Description |
| --- | --- | --- |
| DIMENSION | 8 | Contains most relevant fictional attributes related to players’ ability playmaking-related. |

| Hierarchy Lvl | Attribute | Description |
| --- | --- | --- |
| Root | id | Numerical unique identifier |
| Root | ca | Current Ability of player (hidden attribute in FM20) |
| Mental Ability | vis | Vision; player's ability to see a potential opening and spot an opportunity another player may not have seen |
| Mental Ability | ldr | Leadership; player's ability to influence player around them on the pitch |
| Mental Ability | cnt | Concentration; player's mental focus and attention to detail on a event a event basis |
| Technical Ability | pas | Passing; player's ability to successfully find a team-mate with the ball |
| Technical Ability | dri | Dribbling; player's ability to run with the ball and manipulate it under close control |
| Physical Ability | agi | Agility; how well player can start stop and move in different directions at varying levels of speed both on and off the ball |

## OffensiveAbility

| Multidimensional Model | Arity | Description |
| --- | --- | --- |
| DIMENSION | 6 |Contains most relevant fictional attributes related to players’ offensive ability. |

| Hierarchy Lvl | Attribute | Description |
| --- | --- | --- |
| Root | id | Numerical unique identifier |
| Root | ca | Current Ability of player (hidden attribute in FM20) |
| Mental Ability | cnt | Concentration; player's mental focus and attention to detail on a event a event basis |
| Physical Ability | str | Strength; player's ability to exert his physical force on an opponent to his benefit |
| Technical Ability | tec | Technique; the aesthetic quality of a player's technical game |
| Technical Ability | fin | Finishing; player's ability to put the ball in the back of the net when presented with a chance |