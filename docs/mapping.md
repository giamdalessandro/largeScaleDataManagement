# GAV Mapping

## Global Schema
- $League_{/2}$
- $Club_{/1}$
- $BelongsTo_{/2}$
- $Player_{/9?}$
- $PlaysIn_{/2}$
- $PresenceStats_{/15}$ 
- $GoalKeeperStats_{/10}$
- $DefenseStats_{/17}$
- $PlaymakingStats_{/19}$	
- $GoalStats_{/17}$
- $Technical_{/14}$
- $Mental_{/10}$
- $Physical_{/8}$
- $KeeperAbility_{/5}$


## GAV Mapping
Sketch of GAV mapping, need to check if it is really GAV, and if all is correct.

- $\forall$ *d.* $\exists$ *<...>,*.FM2020(*d,<...>*) $\rightarrow$ League(*d*)
	- (check) $\forall d,nat. \exists <...>,$.FM2020($d,nat,<...>$) $\rightarrow$ hasCountry($d,nat$))
- $\forall$ *c.* $\exists$ *<...>*,.FM2020(*c,<...>*) $\rightarrow$ Club($c$) 
- $\forall$ *c,d.* $\exists$ *<...>,*.FM2020(*c,d,<...>*) $\rightarrow$ BelongsTo(*c,d*)
- $\forall$ *pid*. $\exists$ *<...>,*.Info(*pid,<...>*) $\rightarrow$ Player(*pid*)

In the following need to replace 
- {$\forall$*pid.* $\exists$*<...>*} to be replaced with {  $\forall$*pid,\<AttrInGlobal>*. $\exists$*\<AttrNotInGlobal>*}
- {has...Stats(*pid.<...>*)} to be replaced with {has...Stats(*pid,\<AttrInGlobal>*}

where *\<AttrInGlobal>* are those attribute of the source that are mapped in the global schema; essentially map each tuple in the Source with the corresponding tuple in the Global.

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
	- $\forall pid,name. \exists <...>,$.Info($pid,name,<...>$) $\rightarrow$ Player(*pid,name*)
	- $\forall$*name*.$\exists <...>,$.FM2020($name,<...>$) $\rightarrow$ Player(*pid,name*)
- $\forall$ *pid.* $\exists$*<...>,*.Info(*pid,<...>*) {$\wedge$ FM2020(*n,...*) ??} $\rightarrow$ PlaysIn(*pid,c*)