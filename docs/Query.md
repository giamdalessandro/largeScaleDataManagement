# 1

Retrive the number of goals scored by the players who have the same finalization ability (FM fictional attribute) of "Ciro Immobile".

## FOL

$$
\begin{split}
q_1 = \{(player\_name, goals, fin) |& \\
&\exists g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15, g16, g17 \\
&\exists t2, t3, t4, t5, t6, t7, t8, t9, t10, t12, t13, t14 . \\
&GoalStat(player\_name, goals, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15, g16, g17) \\
&\wedge TechnicalAbility(player\_name, t2, t3, t4, t5, t6, t7, t8, t9, t10, fin, t12, t13, t14) \\
&\wedge TechnicalAbility(\textrm{``Ciro Immobile''}, t2, t3, t4, t5, t6, t7, t8, t9, t10, fin, t12, t13, t14)\}
\end{split}
$$

## SQL

```
select gs.player_name, goals, ta1.fin
from GoalStat gs, TechnicalAbility ta1, TechnicalAbility ta2
where 
	gs.player_name = ta1.player_name
	and ta1.fin = ta2.fin
	and ta2.player_name = 'Ciro Immobile'
;
```

## SQL-Execute

```
select gs.player, goals, ta1.fin
from "GoalStats" gs, "TechincalAbility" ta1, "TechincalAbility" ta2
where 
	gs.player = ta1.player
	and ta1.fin = ta2.fin
	and ta2.player = 'Ciro Immobile'
;
```

# 2

Retrive the number of yellow cards received by the players who have 17 as value of the aggression ability (FM fictional attribute).

## FOL

$$
\begin{split}
q_2 = \{(player\_name, player\_squad, cards\_yellow, games, agg) |& \\
&\exists d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d18 \\
&\exists p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16 \\
&\exists m2, m3, m4, m5, m6, m7, m8, m9 . \\
&DefenseStat(player\_name, player\_squad, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, cards\_yellow, d18) \\
&\wedge PresenceStat(player\_name, player\_squad, games, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16) \\
&\wedge MentalAbility(player\_name, m2, m3, m4, m5, m6, m7, m8, m9, agg) \\
&\wedge agg = 17\}
\end{split}
$$

## SQL

```
select ds.player_name, ds.player_squad, cards_yellow, games, agg
from DefenseStat ds, MentalAbility ma, PresenceStat ps
where
	(ds.player_name = ps.player_name and ds.player_squad = ps.player_squad)
	and ps.player_name = ma.player_name
	and ma.agg = 17
;
```

## SQL-Execute

```
select ds.player, ds.squad, cards_yellow, games, agg
from "DefenseStats" ds, "MentalAbility" ma, "PresenceStats" ps
where
	(ds.player = ps.player and ds.squad = ps.squad)
	and ps.player = ma.player
	and ma.agg = 17
;
```

# 3

Retrive the number of assists realized by the players who have a value of the vision ability (FM fictional attribute) below 16.

## FOL

$$
\begin{split}
q_3 = \{(player\_name, player\_squad, position, assists, vis) |& \\
&\exists pm3, pm4, pm5, pm6, pm8, pm9, pm10, pm11, pm12, pm13, pm14, pm15, pm16, pm17, pm18, pm19, pm20 \\
&\exists p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13 \\
&\exists m2, m4, m5, m6, m7, m8, m9, m10 . \\
&PlaymakingStat(player\_name, player\_squad, pm3, pm4, pm5, pm6, assists, pm8, pm9, pm10, pm11, pm12, pm13, pm14, pm15, pm16, pm17, pm18, pm19, pm20) \\
&\wedge Player(player\_name, position, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13) \\
&\wedge MentalAbility(player\_name, m2, vis, m4, m5, m6, m7, m8, m9, m10) \\
&\wedge \neg(vis=20) \wedge \neg(vis=19) \wedge \neg(vis=18) \wedge \neg(vis=17) \wedge \neg(vis=16) \}
\end{split}
$$

## SQL

```
select pm.player_name, pm.player_squad, position, assists, vis
from PlaymakingStat pm, Player p, MentalAbility m
where 
	pm.player_name = p.name
	and pm.player_name = m.player_name
	and vis != 20 and vis != 19 and vis != 18 and vis != 17 and vis != 16
;
```

## SQL-Execute

```
select pm.player, pm.squad, position, assists, vis
from "PlaymakingStats" pm, "Player" p, "MentalAbility" m
where 
	pm.player = p.name
	and p.player = m.player
	and vis != 20 and vis != 19 and vis != 18 and vis != 17 and vis != 16
;
```

# 4

Retrive the points per match gained by Juventus with respect to the presence of its players. Retrive also the wage and the strength of the players (FM fictional attributes).

## FOL

$$
\begin{split}
q_4 = \{(player\_name, player\_squad, points\_per\_match, mnts, str, wage) |& \\
&\exists pr3, pr5, pr6, pr7, pr8, pr9, pr10, pr11, pr13, pr14, pr15, pr16 \\
&\exists p2, p3, p4, p5, p6, p7, p8, p9, p10, p12, p13 \\
&\exists ph3, ph4, ph5, ph6, ph7, ph8 . \\
&PresenceStat(player\_name, player\_squad, pr3, mnts, pr5, pr6, pr7, pr8, pr9, pr10, pr11, points\_per\_match, pr13, pr14, pr15, pr16) \\
&\wedge Player(player\_name, p2, p3, p4, p5, p6, p7, p8, p9, p10, wage, p12, p13) \\
&\wedge PhysicalAbility(player\_name, str, ph3, ph4, ph5, ph6, ph7, ph8) \\
&\wedge player\_squad = \textrm{``Juventus''}\}
\end{split}
$$

## SQL

```
select pr.player_name, pr.player_squad, points_per_match, mnts, str, wage
from PresenceStat pr, Player p, PhysicalAbility ph
where 
	pr.player_name = p.name
	and pr.player_name = ph.player_name
	and pr.player_squad = 'Juventus'
;
```

## SQL-Execute

```
select pr.player, pr.squad, points_per_match, mnts, str, wage
from "PresenceStats" pr, "Player" p, "PhysicalAbility" ph
where 
	pr.player = p.name
	and pr.player = ph.player
	and pr.squad = 'Juventus'
;
```

# 5

Retrive the potential ability (FM fictional attribute) and the save percentage of the goalkeepers whose age is 20 or 21 or 22.

## FOL

$$
\begin{split}
q_5 = \{(player\_name, player\_squad, age, pa, save\_pct) |& \\
&\exists p3, p4, p5, p6, p8, p9, p10, p11, p12 \\
&\exists g3, g4, g5, g6, g8, g9, g10 . \\
&(Player(player\_name, \textrm{``GK''}, p3, p4, p5, p6, age p8, p9, p10, p11, p12, pa) \\
&\wedge GoalkeeperStat(player\_name, player\_squad, g3, g4, g5, g6, save\_pct, g8, g9, g10) \\
&\wedge age = 20) \\
&\lor \\
&(Player(player\_name, \textrm{``GK''}, p3, p4, p5, p6, age p8, p9, p10, p11, p12, pa) \\
&\wedge GoalkeeperStat(player\_name, player\_squad, g3, g4, g5, g6, save\_pct, g8, g9, g10) \\
&\wedge age = 21) \\ 
&\lor \\
&(Player(player\_name, \textrm{``GK''}, p3, p4, p5, p6, age p8, p9, p10, p11, p12, pa) \\
&\wedge GoalkeeperStat(player\_name, player\_squad, g3, g4, g5, g6, save\_pct, g8, g9, g10) \\
&\wedge age = 22) \}
\end{split}
$$

## SQL

```
select player_name, player_squad, age, pa, save_pct
from Player p, GoalkeeperStat g
where 
	p.name = g.player_name
	and (age=20 or age=21 or age=22)
;
```

```
select player_name, player_squad, age, pa, save_pct
from Player p, GoalkeeperStat g
where 
	p.name = g.player_name
	and age = 20
union
select player_name, player_squad, age, pa, save_pct
from Player p, GoalkeeperStat g
where 
	p.name = g.player_name
	and age = 21
union
select player_name, player_squad, age, pa, save_pct
from Player p, GoalkeeperStat g
where 
	p.name = g.player_name
	and age = 22
;
```

## SQL-Execute

```
select player, squad, age, pa, save_pct
from "Player" p, "GoalkeeperStats" g
where 
	p.name = g.player
	and (age=20 or age=21 or age=22)
;
```

```
select player, squad, age, pa, save_pct
from "Player" p, "GoalkeeperStats" g
where 
	p.name = g.player
	and age = 20
union
select player, squad, age, pa, save_pct
from "Player" p, "GoalkeeperStats" g
where 
	p.name = g.player
	and age = 21
union
select player, squad, age, pa, save_pct
from "Player" p, "GoalkeeperStats" g
where 
	p.name = g.player
	and age = 22
;
```