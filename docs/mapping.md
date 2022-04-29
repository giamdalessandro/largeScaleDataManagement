# GAV Mapping

## Global Schema
- $League_{/2}$ (name,country)
	-  we mat separate $League_{/2}$ and $hasCountry_{/1}$
		- **League**(name)
		- **hasCountry**(league,country)
- $Club_{/1}$ (name)
- $BelongsTo_{/2}$ (club,league)
- $Player_{/11?}$ (pid,...)
	- we mat separate player $(Player_{/2})$ and info $(hasInfo_{/10})$ 
		- **Player**(id,name)
		- **hasInfo**(pid,...)
- $PlaysIn_{/2}$  (pid,...)

### GSchema Extension
- $hasActionStas_{/6}$ (pid,...)
- $hasDefenseStats_{/12}$ (pid,...)
- $hasKeeperStas_{/13}$ (pid,...)
- $hasPassingStats_{/17}$ (pid,...)
- $hasPlayingTimeStats_{/15}$ (pid,...)
- $hasPossessionStats_{/12}$ (pid,...)
- $hasShootingStats_{/12}$ (pid,...)
- $hasStandardStats_{/16}$ (pid,...)
- $hasMiscStats_{/18}$ (pid,...)



## Axioms (on Global Schema)
### Keys
- league name is key for **League**(name)
- club name is key for **Club**(name)
- palyer id is key fot **Player**(id)

Don't know if the following axioms are really needed:
- $\forall l.\forall nt.\forall nt'.$ hasCountry($l,nt$) $\wedge$ hasCountry($l,nt'$) $\rightarrow$ ($nt=nt'$) 
	- a league belongs only to one country
- $\forall c.\forall l.\forall l'.$ belongsTo($c,l$) $\wedge$ belongsTo($c,l'$) $\rightarrow$ ($l=l'$)
	- a club belongs only to one League 
- $\forall pid.\forall c.\forall c'.$ playsIn($pid,c$) $\wedge$ playsIn($pid,c'$) $\rightarrow$ ($c=c'$)
	- a player plays only in one club (ha senso?)

### Foreign Keys
- $\forall l,nt.$ hasCountry($l,nt$) $\rightarrow$ League($l$)
- $\forall c,l.$ belongsTo($c,l$) $\rightarrow$ Club($c$) $\wedge$ League($l$)
- $\forall pid,c$. playsIn($pid,c$) $\rightarrow$ Player($pid$) $\wedge$ Club($c$)

- $\forall pid,<...>$.hasInfo($pid,<...>$) $\rightarrow$ Player($pid$)
- $\forall pid,<...>$.hasDefenseStats($pid,<...>$) $\rightarrow$ Player($pid$)
- $\forall pid,<...>$.hasKeepStats($pid,<...>$) $\rightarrow$ Player($pid$)
- $\forall pid,<...>$.hasPassingStats($pid,<...>$) $\rightarrow$ Player($pid$)
- $\forall pid,<...>$.hasPlayngTimeStats($pid,<...>$) $\rightarrow$ Player($pid$)
- $\forall pid,<...>$.hasPossesionStats($pid,<...>$) $\rightarrow$ Player($pid$)
- $\forall pid,<...>$.hasShootingStats($pid,<...>$) $\rightarrow$ Player($pid$)
- $\forall pid,<...>$.hasStandardStats($pid,<...>$) $\rightarrow$ Player($pid$)
- $\forall pid,<...>$.hasMiscStats($pid,<...>$) $\rightarrow$ Player($pid$)


## GAV Mapping
Sketch of GAV mapping, need to check if it is really GAV, and if all is correct.

- $\forall d. \exists <...>,.$FM2020($d,<...>$) $\rightarrow$ League($d$)
- $\forall d,nat. \exists <...>,$.FM2020($d,nat,<...>$) $\rightarrow$ hasCountry($d,nat$)
- $\forall c. \exists <...>,$.FM2020($c,<...>$) $\rightarrow$ Club($c$) 
- $\forall c,d. \exists <...>,$.FM2020($c,d,<...>$) $\rightarrow$ BelongsTo($c,d$)

In the following need to replace $$\forall pid. \exists <...> \text{ with} \quad \forall pid,<AttrInGlobal>. \exists <AttrNotInGlobal>$$essentially map each tuple in the Source with the corresponding tuple in the Global.
- $\forall pid. \exists <...>,$.GCA($pid,<...>$) $\rightarrow$ hasActionStats($pid,<...>$)
- $\forall pid. \exists <...>,$.Defense($pid,<...>$) $\rightarrow$ hasDefenseStats($pid,<...>$)
- $\forall pid. \exists <...>,$.Keeper($pid,<...>$) $\rightarrow$ hasKeeperStats($pid,<...>$)
- $\forall pid. \exists <...>,$.Passing($pid,<...>$) $\rightarrow$ hasPassingStats($pid,<...>$)
- $\forall pid. \exists <...>,$.PlayngTime($pid,<...>$) $\rightarrow$ hasPlayingTimeStats($pid,<...>$)
- $\forall pid. \exists <...>,$.Possesion($pid,<...>$) $\rightarrow$ hasPossessionStats($pid,<...>$)
- $\forall pid. \exists <...>,$.Shooting($pid,<...>$) $\rightarrow$ hasShootingStats($pid,<...>$)
- $\forall pid. \exists <...>,$.Standard($pid,<...>$) $\rightarrow$ hasStandardStats($pid,<...>$)
- $\forall pid. \exists <...>,$.Misc($pid,<...>$) $\rightarrow$ hasMiscStats($pid,<...>$)

#### to check
How to define *join* between **FM2020** and **Info** in GAV-mapping? Necessary?
How to define *join* between **Info** and **has...Stats** tables in GAV-mapping? Necessary?
- $\forall pid,name. \exists <...>,$.Info($pid,name,<...>$) $\wedge$ FM2020($name,<...>$) $\rightarrow$ Player($pid,name$)
	- $Player_{/2}$ (pid,name)
- $\forall pid. \exists <...>,$.Info($pid,<...>$) {$\wedge$ FM2020(n,...) ??} $\rightarrow$ PlaysIn($pid,c$)