# GAV Mapping

## Axioms (on Global Schema)
### Keys

### Foreign Keys
- $\forall x.$ League($x$) $\rightarrow \exists y.$ hasCountry($x,y$)
- $\forall x.$ Club($x$) $\rightarrow \exists y.$ BelongsTo($x,y$)
	- ~~$\forall x.\exists y.$BelongsTo($x,y$) $\rightarrow$ Club($x$) $\wedge$ League($y$)~~
- $\forall x.$ Player($x$) $\rightarrow \exists y.$ PlaysIn($x,y$)

If we assume that every palyer as **all** kind of available stats:
- $\forall x $.Player($x$) $\rightarrow \exists <...>,.$ hasInfo($x,<...>$)
- $\forall x$.Player($x$) $\rightarrow \exists <...>,.$ hasActionStats($x,<...>$)
- $\forall x$.Player($x$) $\rightarrow \exists <...>,.$ hasDefenseStats($x,<...>$)
- $\forall x$.Player($x$) $\rightarrow \exists <...>,.$ hasKeepStats($x,<...>$)
- $\forall x$.Player($x$) $\rightarrow \exists <...>,.$ hasPassingStats($x,<...>$)
- $\forall x$.Player($x$) $\rightarrow \exists <...>,.$ hasPlayngTimeStats($x,<...>$)
- $\forall x$.Player($x$) $\rightarrow \exists <...>,.$ hasPossesionStats($x,<...>$)
- $\forall x$.Player($x$) $\rightarrow \exists <...>,.$ hasShootingStats($x,<...>$)
- $\forall x$.Player($x$) $\rightarrow \exists <...>,.$ hasStandardStats($x,<...>$)
- $\forall x$.Player($x$) $\rightarrow \exists <...>,.$ hasMiscStats($x,<...>$)


### Global Schema
- $League_{/2}$ (name,country)
	- $hasCountry_{/1}$
		- **League**(name)
		- **hasCountry**(league,country)
- $Club_{/1}$ (name)
- $BelongsTo_{/2}$ (club,league)
- $Player_{/11?}$ (pid,...)
	- $hasInfo_{/10}$ 
		- **Player**(id)
		- **hasInfo**(pid,...)
- $PlaysIn_{/2}$  (pid,...)

#### GSchema Extension
- $hasActionStas_{/6}$ (pid,...)
- $hasDefenseStats_{/12}$ (pid,...)
- $hasKeeperStas_{/13}$ (pid,...)
- $hasPassingStats_{/17}$ (pid,...)
- $hasPlayingTimeStats_{/15}$ (pid,...)
- $hasPossessionStats_{/12}$ (pid,...)
- $hasShootingStats_{/12}$ (pid,...)
- $hasStandardStats_{/16}$ (pid,...)
- $hasMiscStats_{/18}$ (pid,...)


## GAV Mapping
- $\forall d. \exists <...>,.$ FM2020($d,<...>$) $\rightarrow$ League($d$)
- $\forall d,nat. \exists <...>,$.FM2020($d,nat,<...>$) $\rightarrow$ hasCountry($d,nat$)
- $\forall c. \exists <...>,$.FM2020($c,<...>$) $\rightarrow$ Club($c$) 
- $\forall c,d. \exists <...>,$.FM2020($c,d,<...>$) $\rightarrow$ BelongsTo($c,d$)

How to define *join* between **FM2020** and **Info** in GAV-mapping? Necessary?
How to define *join* between **Info** and **has...Stats** tables in GAV-mapping? Necessary?

- $\forall pid. \exists <...>,$.Info($pid,<...>$) $\rightarrow$ Player($pid$)
- $\forall pid. \exists <...>,$.Info($pid,<...>$) {$\wedge$ FM2020(n,...) ??} $\rightarrow$ PlaysIn($pid,c$)

- $\forall pid. \exists <...>,$.GCA($pid,<...>$) $\rightarrow$ hasActionStats($pid,<...>$)
- $\forall pid. \exists <...>,$.Defense($pid,<...>$) $\rightarrow$ hasDefenseStats($pid,<...>$)
- $\forall pid. \exists <...>,$.Keeper($pid,<...>$) $\rightarrow$ hasKeeperStats($pid,<...>$)
- $\forall pid. \exists <...>,$.Passing($pid,<...>$) $\rightarrow$ hasPassingStats($pid,<...>$)
- $\forall pid. \exists <...>,$.PlayngTime($pid,<...>$) $\rightarrow$ hasPlayingTimeStats($pid,<...>$)
- $\forall pid. \exists <...>,$.Possesion($pid,<...>$) $\rightarrow$ hasPossessionStats($pid,<...>$)
- $\forall pid. \exists <...>,$.Shooting($pid,<...>$) $\rightarrow$ hasShootingStats($pid,<...>$)
- $\forall pid. \exists <...>,$.Standard($pid,<...>$) $\rightarrow$ hasStandardStats($pid,<...>$)
- $\forall pid. \exists <...>,$.Misc($pid,<...>$) $\rightarrow$ hasMiscStats($pid,<...>$)S