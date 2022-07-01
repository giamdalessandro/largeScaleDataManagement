select
	inf.name as player,
    pt.squad as squad,
	cast(pt.games as double) as games,
	cast(pt.mnts as double) as mnts,
	cast(pt.minutes_per_game as double) as minutes_per_game,
	cast(pt.minutes_pct as double) as minutes_pct,
	cast(pt.minutes_90s as double) as minutes_90s,
	cast(pt.games_starts as double) as games_starts,
	cast(pt.games_complete as double) as games_complete,
	cast(pt.games_subs as double) as games_subs,
	cast(pt.unused_subs as double) as unused_subs,
	cast(pt.points_per_match as double) as points_per_match,
	cast(pt.on_goals_for as double) as on_goals_for,
	cast(pt.on_goals_against as double) as on_goals_against,
	cast(pt.plus_minus as double) as plus_minus,
	cast(pt.plus_minus_wowy as double) as plus_minus_wowy
from FbrefPTime pt, FbrefInfo inf 
where (pt.id = inf.id) order by player