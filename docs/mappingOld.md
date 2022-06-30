# GAV Mapping

## Global Schema
- $Player_{/14}$
- $PresenceStats_{/15}$ 
- $PassingStats_{/19}$ 
- $PlaymakingStats_{/19}$	
- $DefenseStats_{/17}$
- $GoalStats_{/17}$
- $GoalkeeperStats_{/9}$
- $TechnicalAbility_{/14}$
- $MentalAbility_{/10}$
- $PhysicalAbility_{/8}$
- $GoalkeeperAbility_{/5}$


## GAV Mapping
Sketch of GAV mapping, need to check if it is really GAV, and if all is correct.

In the following need to replace 
- {$\forall$*pid.* $\exists$*<...>*} to be replaced with {  $\forall$*pid,\<AttrInGlobal>*. $\exists$*\<AttrNotInGlobal>*}
- {has...Stats(*pid.<...>*)} to be replaced with {has...Stats(*pid,\<AttrInGlobal>*}

where *\<AttrInGlobal>* are those attribute of the source that are mapped in the global schema; essentially map each tuple in the Source with the corresponding tuple in the Global.

- $\forall$ playerName.$\exists$<...>.PlayingTime -> PresenceStats(playerName, )
- $\forall$ i, gag, gag90, stag, sav, savpct, cs, cspct, pspct.$\exists$<...>.Keeper $\wedge$ $\forall$ id,name.$\exists$.(<...>).Info $\wedge$  i=id -> Goalkeeper(pn, gag, gag90, stag, sav, savpct, cs, cspct, pspct)

- $\forall$ *pid,* $\exists$*<...>,* .GCA(*pid,<...>*) $\rightarrow$ hasActionStats(*pid,<...>*)
- $\forall$ *pid,* $\exists$*<...>,* .Defense(*pid,<...>*) $\rightarrow$ hasDefenseStats(*pid,<...>*)
- $\forall$ *pid,* $\exists$*<...>,* .Keeper(*pid,<...>*) $\rightarrow$ hasKeeperStats(*pid,<...>*)
- $\forall$ *pid,* $\exists$*<...>,* .Passing(*pid,<...>*) $\rightarrow$ hasPassingStats(*pid,<...>*)
- $\forall$ *pid,* $\exists$*<...>,* .PlayngTime(*pid,<...>*) $\rightarrow$ hasPlayingTimeStats(*pid,<...>*)
- $\forall$ *pid,* $\exists$*<...>,* .Possesion(*pid,<...>*) $\rightarrow$ hasPossessionStats(*pid,<...>*)
- $\forall$ *pid,* $\exists$*<...>,* .Shooting(*pid,<...>*) $\rightarrow$ hasShootingStats(*pid,<...>*)
- $\forall$ *pid,* $\exists$*<...>,* .Standard(*pid,<...>*) $\rightarrow$ hasStandardStats(*pid,<...>*)
- $\forall$ *pid,* $\exists$*<...>,* .Misc(*pid,<...>*) $\rightarrow$ hasMiscStats(*pid,<...>*)
- $\forall$ *name,* $\exists$*<...>,* .FM2020(*name,<...>*) $\rightarrow$ *FMStats(*name,<...>*)

#### to check
How to define *join* between **FM2020** and **Info** in GAV-mapping? Necessary?
How to define *join* between **Info** and **has...Stats** tables in GAV-mapping? Necessary?
- $\forall$ *pid,pname*. $\exists$*<...>,*.Info(*pid,pname,<...>*) $\wedge$ $\forall$ *fname,age*.$\exists$.FM2020(*fname,age,<...>*) $\wedge$ *pname=fname* $\rightarrow$ Player(*pid,pname,age,<...>*)
- $\forall$ *pid.* $\exists$*<...>,*.Info(*pid,<...>*) {$\wedge$ FM2020(*n,...*) ??} $\rightarrow$ PlaysIn(*pid,c*)

