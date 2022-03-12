# Dataset



## Source Schemas

### Football manager data

The dataset contains a collection of players (no newgen) statistics from the Football Manager game, including many attributes such as age, position, club, nationality, value, wage, etc.

- *format*: CSV file;
- **Fm2020**(rank,name,position,club,division,based,nation,height,weight,age,prefFoot,bestPos,bestRole,value,wage,...)



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



## Target Schema

