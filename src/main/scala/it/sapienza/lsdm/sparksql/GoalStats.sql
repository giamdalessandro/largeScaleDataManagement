select
	/*fb.id as pid,*/
	cast(sht.minutes_90s as double) as minutes_90s,
	cast(sht.goals as double) as goals,
	cast(sht.shots_total as double) as shots_total,
	cast(sht.shots_on_target as double) as shots_on_target,
	cast(sht.shots_on_target_pct as double) as shots_on_target_pct,
	cast(sht.shots_total_per90 as double) as shots_total_per90,
	cast(sht.shots_on_target_per90 as double) as shots_on_target_per90,
	cast(sht.goals_per_shot as double) as goals_per_shot,
	cast(sht.average_shot_distance as double) as average_shot_distance,
	cast(sht.shots_free_kicks as double) as shots_free_kicks,
	cast(sht.pens_made as double) as pens_made,
	cast(sht.pens_att as double) as pens_att,
	cast(std.goals_pens as double) as goals_pens,
	cast(std.goals_per90 as double) as goals_per90,
	cast(std.goals_assists_per90 as double) as goals_assists_per90,
	cast(std.goals_pens_per90 as double) as goals_pens_per90,
	cast(misc.offsides as double) as offsides
from FbrefSht sht, FbrefStd std, FbrefMisc misc
/*order by pid*/
