select
	fb.id as pid
	cast(fb.minutes_90s as double) as minutes_90s
	cast(fb.goals as double) as goals
	cast(fb.shots_total as double) as shots_total
	cast(fb.shots_on_target as double) as shots_on_target
	cast(fb.shots_on_target_pct as double) as shots_on_target_pct
	cast(fb.shots_total_per90 as double) as shots_total_per90
	cast(fb.shots_on_target_per90 as double) as shots_on_target_per90
	cast(fb.goals_per_shot as double) as goals_per_shot
	cast(fb.average_shot_distance as double) as average_shot_distance
	cast(fb.shots_free_kicks as double) as shots_free_kicks
	cast(fb.pens_made as double) as pens_made
	cast(fb.pens_att as double) as pens_att
from Fbref fb
where fb.id in (select id from (Fm20 fm join FbrefInfo fbinfo on (fm.Name = fbinfo.name)))
order by pid
