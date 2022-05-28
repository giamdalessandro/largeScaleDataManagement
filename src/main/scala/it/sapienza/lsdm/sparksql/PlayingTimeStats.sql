select
	fb.id as pid,
	cast(fb.games as double) as games,
	cast(fb.mnts as double) as mnts,
	cast(fb.minutes_per_game as double) as minutes_per_game,
	cast(fb.minutes_pct as double) as minutes_pct,
	cast(fb.minutes_90s as double) as minutes_90s,
	cast(fb.games_starts as double) as games_starts,
	cast(fb.games_complete as double) as games_complete,
	cast(fb.games_subs as double) as games_subs,
	cast(fb.unused_subs as double) as unused_subs,
	cast(fb.points_per_match as double) as points_per_match,
	cast(fb.on_goals_for as double) as on_goals_for,
	cast(fb.on_goals_against as double) as on_goals_against,
	cast(fb.plus_minus as double) as plus_minus,
	cast(fb.plus_minus_wowy as double) as plus_minus_wowy
from FbrefPTime fb
where fb.id in (select id from (Fm20 fm join FbrefInfo fbinfo on (fm.Name = fbinfo.name)))
order by pid
