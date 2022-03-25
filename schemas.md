# Dataset



## Source Schemas

### Football manager data

The dataset contains a collection of players (no newgen) statistics from the Football Manager game, including many attributes such as age, position, club, nationality, value, wage, etc.

- *format*: CSV file;
- **Fm2020**(rank,name,position,club,division,based,nation,height,weight,age,prefFoot,bestPos,bestRole,value,wage,CA,PA,Wor,Vis,Tec,Tea,Tck,Str,Sta,TRO,Ref,Pen,Pas,Pac,1v1,OtB,Mar,L_Th,Lon,Ldr,Jum,Heat,Han,Fla,Fir,Fin,Dri,Cro,Cor,Cnt,Cmd,Agi,Agg,Aer,Aer,Acc)



### fbref stats website data

The dataset contains player performance data for ~3000 players currently playing in the Big 5 European soccer leagues. 

- **Info**(id,created,name,position,foot,height,weight,dob,cityOB,countryOB)
- **Defense**(id,season,country,compLevel,igFinish,squad,age,min90s,tackles,tacklesWon,pressures,pressuresRegains,pressuresRegainPct,blocks,blockedShots,blockedShotsSaves,interception,clearences,errors)
- **GCA**(id,season,country,compLevel,igFinish,squad,age,min90s,sca,scaPer90,gca,gcaPer90)
- **Keeper**(id,season,country,compLevel,igFinish,squad,age,gamesGK,gamesStartsGK,minGK,min90s,goalAgainstGK,goalAgainst90,shotOnTargetAgainst,saves,savesPct,cleanSheets,cleanSheetsPct,pensSavesPct)
- **Passing**(id,season,country,compLevel,igFinish,squad,age,min90s,passesCompleted,passes,passesPct,passesCompletedShort,passesShort,passesShortPct,passingCompletedMedium,passesMedium,passesMediumPct,passesCompletedLong,passesLong,passesLongPct,assist,passesIntoFinal,passesIntoPenalty,crossesIntoPenalty)
- **PlayngTime**(id,season,country,compLevel,igFinish,squad,age,games,mins,minsPerGame,minsPct,min90s,gameStarts,gamesCompleted,gamesSubs,unusedSubs,pointsPerMatch,onGoalsFor,onGoalsAgainst,plusMinus,plusMinusWowy)
- **Possession**(id,season,country,compLevel,igFinish,squad,age,min90s,touches,touchesDef3rd,touchesMid3rd,touchesAtt3rd,touchesAttPenArea,dribblesCompleted,dribbles,dribblesCompletedPct,miscontrols,dispossessed,passTargets)
- **Shooting**(id,season,country,compLevel,igFinish,squad,age,min90s,goals,shotsTotal,shotsOnTgt,shotsOnTgtPct,shotsTotalPer90,shotsOnTgtPer90,goalsPerShot,avgShotDistance,shotsFreeKicks,pensMade,pensAtt)
- **Standard**(id,season,country,compLevel,igFinish,squad,age,games,gameStarts,mins,min90s,goals,assist,goalPens,pensMade,pensAtt,cardsYellow,cardsRed,goalsPer90,assistPer90,goalAssistPer90,goalsPensPer90)
- **Misc**(id,season,country,compLevel,igFinish,squad,age,min90s,cardsYellow,cardsRed,cardsYellowRed,fouls,fouled,offsides,crosses,interceptions,tackels,Won,pensWon,pensConceded,ownGoals,ballRecoveries,aerialsWon,aerialsLost,aerialsWonPct)



## Complete Source Schema

Source schema considering all attribtes of the data. We keep everything at the beginning then we work only  on some *divisions* to reduce the amount of data (reduce columns here??).

- $FM2020_{/52}$
- $Info_{/10}$
- $Defense_{/12}$ (19)
- $GCA_{/12}$ 
- $Keeper_{/13}$ (19)
- $Passing_{/17}$ (24)
- $PlayingTime_{/15}$ (21)
- $Possession_{/12}$ (19)
- $Shooting_{/12}$ (19)
- $Standard_{/16}$ (22)
- $Misc_{/18}$ (25)



## Target Schema

Integration on columns, redistributing FM2020 stats to the relative fbref table.

- $League_{/2}$ (all leagues in dataset)
  - **League**(name,country)
- $Club_{/1}$ (all clubs in dataset)
  - **Club**(name)
- $BelongsTo_{/2}$ (which league a club belongs to)
  - **BelongsTo**(club,league)
- $Player_{/11?}$ (all players in dataset)
  - **Player**(id,name,position,foot,height,weight,age,dob,cityOB,countryOB,igFinish)
- $PlaysIn_{/2}$  (which club a player plays in)
  - **PlaysIn**(playerId,club)
- $hasActionStas_{/6}$ (player goal/shots creating actions)
  - **hasActionStats**(playerId,min90s,sca,scaPer90,gca,gcaPer90)
- $hasDefenseStats_{/12}$ (player defense stats)
  - **hasDefenseStats**(playerId,tackles,tacklesWon,pressures,pressuresRegains,pressuresRegainPct,blocks,blockedShots,blockedShotsSaves,interception,clearences,errors)
- $hasKeeperStas_{/13}$ (all stats of players that plays as goal keeper)
  - **hasKeeperStats**(playerId,gamesGK,gamesStartsGK,minGK,min90s,goalAgainstGK,goalAgainst90,shotOnTargetAgainst,saves,savesPct,cleanSheets,cleanSheetsPct,pensSavesPct)
- $hasPassingStats_{/17}$ (player passing stats)
  - **hasPassingStats**(playerId,passesCompleted,passes,passesPct,passesCompletedShort,passesShort,passesShortPct,passingCompletedMedium,passesMedium,passesMediumPct,passesCompletedLong,passesLong,passesLongPct,assist,passesIntoFinal,passesIntoPenalty,crossesIntoPenalty)
- $hasPlayingTimeStats_{/15}$ (player playing time stats)
  - **hasPlayngTimeStats**(playerId,games,mins,minsPerGame,minsPct,min90s,gameStarts,gamesCompleted,gamesSubs,unusedSubs,pointsPerMatch,onGoalsFor,onGoalsAgainst,plusMinus,plusMinusWowy)
- $hasPossessionStats_{/12}$ (player possession stats)
  - **hasPossessionStats**(playerId,touches,touchesDef3rd,touchesMid3rd,touchesAtt3rd,touchesAttPenArea,dribblesCompleted,dribbles,dribblesCompletedPct,miscontrols,dispossessed,passTargets)
- $hasShootingStats_{/12}$ (player shoooting stats)
  - **hasShootingStats**(playerId,goals,shotsTotal,shotsOnTgt,shotsOnTgtPct,shotsTotalPer90,shotsOnTgtPer90,goalsPerShot,avgShotDistance,shotsFreeKicks,pensMade,pensAtt)
- $hasStandardStats_{/16}$ (player standard stats)
  - **hasStandardStats**(playerId,games,gameStarts,mins,min90s,goals,assist,goalPens,pensMade,pensAtt,cardsYellow,cardsRed,goalsPer90,assistPer90,goalAssistPer90,goalsPensPer90)
- $hasMiscStats_{/18}$ (player misc stats)
  - **hasMiscStats**(playerId,cardsYellow,cardsRed,cardsYellowRed,fouls,fouled,offsides,crosses,interceptions,tackels,Won,pensWon,pensConceded,ownGoals,ballRecoveries,aerialsWon,aerialsLost,aerialsWonPct)
