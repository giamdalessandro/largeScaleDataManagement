select
	fb.id as pid,
	cast(fb.games as double) as games,
	cast(fb.games_starts as double) as games_starts,
	cast(fb.mnts as double) as mnts,
	cast(fb.goals as double) as goals,
	cast(fb.assists as double) as assists,
	cast(fb.goals_pens as double) as goals_pens,
	cast(fb.pens_made as double) as pens_made,
	cast(fb.pens_att as double) as pens_att,
	cast(fb.cards_yellow as double) as cards_yellow,
	cast(fb.cards_red as double) as cards_red,
	cast(fb.goals_per90 as double) as goals_per90,
	cast(fb.assists_per90 as double) as assists_per90,
	cast(fb.goals_assists_per90 as double) as goals_assists_per90,
	cast(fb.goals_pens_per90 as double) as goals_pens_per90
from FbrefStd fb
order by pid
