# 1

Retrieve the number of goals scored by the players who have the same finalization ability (FM fictional attribute) of "Ciro Immobile".

## FOL

$$
\begin{split}
q_1 = \{(\boldsymbol{player\_name, goals, fin}) |& \\
&\exists g_{3}, g_{4}, g_{5}, g_{6}, g_{7}, g_{8}, g_{9}, g_{10}, g_{11}, g_{12}, g_{13}, g_{14}, g_{15}, g_{16}, g_{17} \\
&\exists t_{2}, t_{3}, t_{4}, t_{5}, t_{6}, t_{7}, t_{8}, t_{9}, t_{10}, t_{12}, t_{13}, t_{14} . \\
&GoalStat(\boldsymbol{player\_name, goals}, g_{3}, g_{4}, g_{5}, g_{6}, g_{7}, g_{8}, g_{9}, g_{10}, g_{11}, g_{12}, g_{13}, g_{14}, g_{15}, g_{16}, g_{17}) \\
&\wedge TechnicalAbility(\boldsymbol{player\_name}, t_{2}, t_{3}, t_{4}, t_{5}, t_{6}, t_{7}, t_{8}, t_{9}, t_{10}, \boldsymbol{fin}, t_{12}, t_{13}, t_{14}) \\
&\wedge TechnicalAbility(\textrm{\textbf{``Ciro Immobile''}}, t_{2}, t_{3}, t_{4}, t_{5}, t_{6}, t_{7}, t_{8}, t_{9}, t_{10}, fin, t_{12}, t_{13}, t_{14})\}
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
from "GoalStats" gs, "TechnicalAbility" ta1, "TechnicalAbility" ta2
where 
	gs.player = ta1.player
	and ta1.fin = ta2.fin
	and ta2.player = 'Ciro Immobile'
;
```

# 2

Retrieve the number of yellow cards received by the players who have 17 as value of the aggression ability (FM fictional attribute).

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

Retrieve the number of assists realized by the players who have a value of the vision ability (FM fictional attribute) not equal to 20 nor 19 nor 18 nor 17 nor 16.

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

Retrieve the points per match gained by Juventus with respect to the presence of its players. Retrieve also the wage and the strength of the players (FM fictional attributes).

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

Retrieve the potential ability (FM fictional attribute) and the save percentage of the goalkeepers whose age is 20 or 21 or 22.

## FOL

$$
\begin{split}
q_5 = \{(player\_name, player\_squad, age, pa, save\_pct) |& \\
&(\exists p_{3}, p_{4}, p_{5}, p_{6}, p_{8}, p_{9}, p_{10}, p_{11}, p_{12} \\
&\exists g_{3}, g_{4}, g_{5}, g_{6}, g_{8}, g_{9}, g_{10} . \\
&Player(player\_name, \textrm{``GK''}, p_3, p_4, p_5, p_6, age, p_8, p_9, p_{10}, p_{11}, p_{12}, pa) \\
&\wedge GoalkeeperStat(player\_name, player\_squad, g_3, g_4, g_5, g_6, save\_pct, g_8, g_9, g_{10}) \\
&\wedge age = 20)) \\
&\lor \\
&(\exists p'_{3}, p'_{4}, p'_{5}, p'_{6}, p'_{8}, p'_{9}, p'_{10}, p'_{11}, p'_{12} \\
&\exists g'_{3}, g'_{4}, g'_{5}, g'_{6}, g'_{8}, g'_{9}, g'_{10} . \\
&(Player(player\_name, \textrm{``GK''}, p'_{3}, p'_{4}, p'_{5}, p'_{6}, age p'_{8}, p'_{9}, p'_{10}, p'_{11}, p'_{12}, pa) \\
&\wedge GoalkeeperStat(player\_name, player\_squad, g'_{3}, g'_{4}, g'_{5}, g'_{6}, save\_pct, g'_{8}, g'_{9}, g'_{10}) \\
&\wedge age = 21)) \\ 
&\lor \\
&(\exists p''_{3}, p''_{4}, p''_{5}, p''_{6}, p''_{8}, p''_{9}, p''_{10}, p''_{11}, p''_{12} \\
&\exists g''_{3}, g''_{4}, g''_{5}, g''_{6}, g''_{8}, g''_{9}, g''_{10} . \\
&(Player(player\_name, \textrm{``GK''}, p''_{3}, p''_{4}, p''_{5}, p''_{6}, age, p''_{8}, p''_{9}, p''_{10}, p''_{11}, p''_{12}, pa) \\
&\wedge GoalkeeperStat(player\_name, player\_squad, g''_{3}, g''_{4}, g''_{5}, g''_{6}, save\_pct, g''_{8}, g''_{9}, g''_{10}) \\
&\wedge age = 22)) \}
\end{split}
$$

## SQL

```
select player_name, player_squad, age, pa, save_pct
from Player p, GoalkeeperStat g
where 
	p.name = g.player_name and p.position = 'GK'
	and (age=20 or age=21 or age=22)
;
```

```
select player_name, player_squad, age, pa, save_pct
from Player p, GoalkeeperStat g
where 
	p.name = g.player_name and p.position = 'GK'
	and age = 20
union
select player_name, player_squad, age, pa, save_pct
from Player p, GoalkeeperStat g
where 
	p.name = g.player_name and p.position = 'GK'
	and age = 21
union
select player_name, player_squad, age, pa, save_pct
from Player p, GoalkeeperStat g
where 
	p.name = g.player_name and p.position = 'GK'
	and age = 22
;
```

## SQL-Execute

```
select player, squad, age, pa, save_pct
from "Player" p, "GoalkeeperStats" g
where 
	p.name = g.player and p.position = 'GK'
	and (age=20 or age=21 or age=22)
;
```

```
select player, squad, age, pa, save_pct
from "Player" p, "GoalkeeperStats" g
where 
	p.name = g.player and p.position = 'GK'
	and age = 20
union
select player, squad, age, pa, save_pct
from "Player" p, "GoalkeeperStats" g
where 
	p.name = g.player and p.position = 'GK'
	and age = 21
union
select player, squad, age, pa, save_pct
from "Player" p, "GoalkeeperStats" g
where 
	p.name = g.player and p.position = 'GK'
	and age = 22
;
```

# 6

Retrieve the players whose dribbling ability (FM fictional attribute) is equal to 18.

## FOL

$$
\begin{split}
q_6 = \{(player\_name, dri) |& \\
&\exists t_2, t_3, t_4, t_5, t_6, t_7, t_8, t_9, t_{10}, t_{11}, t_{13}, t_{14} \\
&TechnicalAbility(player\_name, t_2, t_3, t_4, t_5, t_6, t_7, t_8, t_9, t_{10}, t_{11}, dri, t_{13}, t_{14}) \\
&\wedge dri = 18 \}
\end{split}
$$

## SQL

```
select player_name, dri
from TechnicalAbility
where dri = 18
;
```

## SQL-Execute

```
select player, dri
from "TechnicalAbility"
where dri = 18
;
```

## FOL-Unfolding

$$
\begin{split}
q_6 = \{(player\_name, dri) |& \\
&(\exists f_{1}, f_{3}, f_{4}, f_{6}, f_{7}, f_{8}, f_{9}, f_{10}, f_{11}, f_{12}, f_{13}, f_{14}, f_{15}, f_{16}, f_{17}, f_{18}, f_{19}, f_{20}, f_{21}, f_{22}, f_{23}, f_{24}, f_{25}, f_{26}, f_{27}, f_{28}, f_{29}, f_{30}, f_{31}, f_{32}, f_{33}, f_{34}, f_{35}, f_{36}, f_{37}, f_{38}, f_{39}, f_{40}, f_{41}, f_{42}, f_{43}, f_{44}, f_{45}, f_{46}, f_{47}, f_{48}, f_{50}, f_{51}, f_{52}, f_{53}, f_{54}, f_{55}, f_{56}, f_{57}, f_{58}, f_{59}, f_{60}, f_{61}, f_{62}, f_{63}, f_{64} \\
&FM20(f_{1}, player\_name, f_{3}, f_{4}, \textrm{``Italian Serie A''}, f_{6}, f_{7}, f_{8}, f_{9}, f_{10}, f_{11}, f_{12}, f_{13}, f_{14}, f_{15}, f_{16}, f_{17}, f_{18}, f_{19}, f_{20}, f_{21}, f_{22}, f_{23}, f_{24}, f_{25}, f_{26}, f_{27}, f_{28}, f_{29}, f_{30}, f_{31}, f_{32}, f_{33}, f_{34}, f_{35}, f_{36}, f_{37}, f_{38}, f_{39}, f_{40}, f_{41}, f_{42}, f_{43}, f_{44}, f_{45}, f_{46}, f_{47}, f_{48}, dri, f_{50}, f_{51}, f_{52}, f_{53}, f_{54}, f_{55}, f_{56}, f_{57}, f_{58}, f_{59}, f_{60}, f_{61}, f_{62}, f_{63}, f_{64}) \\
&\wedge dri = 18) \\
&\lor \\
&(\exists f'_{1}, f'_{3}, f'_{4}, f'_{6}, f'_{7}, f'_{8}, f'_{9}, f'_{10}, f'_{11}, f'_{12}, f'_{13}, f'_{14}, f'_{15}, f'_{16}, f'_{17}, f'_{18}, f'_{19}, f'_{20}, f'_{21}, f'_{22}, f'_{23}, f'_{24}, f'_{25}, f'_{26}, f'_{27}, f'_{28}, f'_{29}, f'_{30}, f'_{31}, f'_{32}, f'_{33}, f'_{34}, f'_{35}, f'_{36}, f'_{37}, f'_{38}, f'_{39}, f'_{40}, f'_{41}, f'_{42}, f'_{43}, f'_{44}, f'_{45}, f'_{46}, f'_{47}, f'_{48}, f'_{50}, f'_{51}, f'_{52}, f'_{53}, f'_{54}, f'_{55}, f'_{56}, f'_{57}, f'_{58}, f'_{59}, f'_{60}, f'_{61}, f'_{62}, f'_{63}, f'_{64} \\
&FM20(f'_{1}, player\_name, f'_{3}, f'_{4}, \textrm{``Bundesliga''}, f'_{6}, f'_{7}, f'_{8}, f'_{9}, f'_{10}, f'_{11}, f'_{12}, f'_{13}, f'_{14}, f'_{15}, f'_{16}, f'_{17}, f'_{18}, f'_{19}, f'_{20}, f'_{21}, f'_{22}, f'_{23}, f'_{24}, f'_{25}, f'_{26}, f'_{27}, f'_{28}, f'_{29}, f'_{30}, f'_{31}, f'_{32}, f'_{33}, f'_{34}, f'_{35}, f'_{36}, f'_{37}, f'_{38}, f'_{39}, f'_{40}, f'_{41}, f'_{42}, f'_{43}, f'_{44}, f'_{45}, f'_{46}, f'_{47}, f'_{48}, dri, f'_{50}, f'_{51}, f'_{52}, f'_{53}, f'_{54}, f'_{55}, f'_{56}, f'_{57}, f'_{58}, f'_{59}, f'_{60}, f'_{61}, f'_{62}, f'_{63}, f'_{64}) \\
&\wedge dri = 18) \\
&\lor \\
&(\exists f''_{1}, f''_{3}, f''_{4}, f''_{6}, f''_{7}, f''_{8}, f''_{9}, f''_{10}, f''_{11}, f''_{12}, f''_{13}, f''_{14}, f''_{15}, f''_{16}, f''_{17}, f''_{18}, f''_{19}, f''_{20}, f''_{21}, f''_{22}, f''_{23}, f''_{24}, f''_{25}, f''_{26}, f''_{27}, f''_{28}, f''_{29}, f''_{30}, f''_{31}, f''_{32}, f''_{33}, f''_{34}, f''_{35}, f''_{36}, f''_{37}, f''_{38}, f''_{39}, f''_{40}, f''_{41}, f''_{42}, f''_{43}, f''_{44}, f''_{45}, f''_{46}, f''_{47}, f''_{48}, f''_{50}, f''_{51}, f''_{52}, f''_{53}, f''_{54}, f''_{55}, f''_{56}, f''_{57}, f''_{58}, f''_{59}, f''_{60}, f''_{61}, f''_{62}, f''_{63}, f''_{64} \\
&FM20(f''_{1}, player\_name, f''_{3}, f''_{4}, \textrm{``Spanish First Division''}, f''_{6}, f''_{7}, f''_{8}, f''_{9}, f''_{10}, f''_{11}, f''_{12}, f''_{13}, f''_{14}, f''_{15}, f''_{16}, f''_{17}, f''_{18}, f''_{19}, f''_{20}, f''_{21}, f''_{22}, f''_{23}, f''_{24}, f''_{25}, f''_{26}, f''_{27}, f''_{28}, f''_{29}, f''_{30}, f''_{31}, f''_{32}, f''_{33}, f''_{34}, f''_{35}, f''_{36}, f''_{37}, f''_{38}, f''_{39}, f''_{40}, f''_{41}, f''_{42}, f''_{43}, f''_{44}, f''_{45}, f''_{46}, f''_{47}, f''_{48}, dri, f''_{50}, f''_{51}, f''_{52}, f''_{53}, f''_{54}, f''_{55}, f''_{56}, f''_{57}, f''_{58}, f''_{59}, f''_{60}, f''_{61}, f''_{62}, f''_{63}, f''_{64}) \\
&\wedge dri = 18) \\
&\lor \\
&(\exists f'''_{1}, f'''_{3}, f'''_{4}, f'''_{6}, f'''_{7}, f'''_{8}, f'''_{9}, f'''_{10}, f'''_{11}, f'''_{12}, f'''_{13}, f'''_{14}, f'''_{15}, f'''_{16}, f'''_{17}, f'''_{18}, f'''_{19}, f'''_{20}, f'''_{21}, f'''_{22}, f'''_{23}, f'''_{24}, f'''_{25}, f'''_{26}, f'''_{27}, f'''_{28}, f'''_{29}, f'''_{30}, f'''_{31}, f'''_{32}, f'''_{33}, f'''_{34}, f'''_{35}, f'''_{36}, f'''_{37}, f'''_{38}, f'''_{39}, f'''_{40}, f'''_{41}, f'''_{42}, f'''_{43}, f'''_{44}, f'''_{45}, f'''_{46}, f'''_{47}, f'''_{48}, f'''_{50}, f'''_{51}, f'''_{52}, f'''_{53}, f'''_{54}, f'''_{55}, f'''_{56}, f'''_{57}, f'''_{58}, f'''_{59}, f'''_{60}, f'''_{61}, f'''_{62}, f'''_{63}, f'''_{64} \\
&FM20(f'''_{1}, player\_name, f'''_{3}, f'''_{4}, \textrm{``English Premier Division''}, f'''_{6}, f'''_{7}, f'''_{8}, f'''_{9}, f'''_{10}, f'''_{11}, f'''_{12}, f'''_{13}, f'''_{14}, f'''_{15}, f'''_{16}, f'''_{17}, f'''_{18}, f'''_{19}, f'''_{20}, f'''_{21}, f'''_{22}, f'''_{23}, f'''_{24}, f'''_{25}, f'''_{26}, f'''_{27}, f'''_{28}, f'''_{29}, f'''_{30}, f'''_{31}, f'''_{32}, f'''_{33}, f'''_{34}, f'''_{35}, f'''_{36}, f'''_{37}, f'''_{38}, f'''_{39}, f'''_{40}, f'''_{41}, f'''_{42}, f'''_{43}, f'''_{44}, f'''_{45}, f'''_{46}, f'''_{47}, f'''_{48}, dri, f'''_{50}, f'''_{51}, f'''_{52}, f'''_{53}, f'''_{54}, f'''_{55}, f'''_{56}, f'''_{57}, f'''_{58}, f'''_{59}, f'''_{60}, f'''_{61}, f'''_{62}, f'''_{63}, f'''_{64}) \\
&\wedge dri = 18)\}
\end{split}
$$

## SQL-Unfolding

```
select name, dri
from FM20
where 
    division = 'Italian Serie A'
    and dri = 18
union
select name, dri
from FM20
where 
    division = 'Bundesliga'
    and dri = 18
union
select name, dri
from FM20
    where division = 'Spanish First Division'
    and dri = 18
union
select name, dri
from FM20
    where division = 'English Premier Division'
    and dri = 18;
```

## SQL-Unfolding-Execute-Drill

```
select Name, Dri
from input.`FM20.csv`
where Division in ('Spanish First Division', 'Italian Serie A', 'Bundesliga', 'English Premier Division')
and Dri= 18;
```

```
select Name, Dri
from input.`FM20.csv`
where Division = 'Italian Serie A'
and Dri= 18
union
select Name, Dri
from input.`FM20.csv`
where Division = 'Bundesliga'
and Dri= 18
union
select Name, Dri
from input.`FM20.csv`
where Division = 'Spanish First Division'
and Dri= 18
union
select Name, Dri
from input.`FM20.csv`
where Division = 'English Premier Division'
and Dri= 18
;
```