select
	fb.id as pid
	cast(fb.minutes_90s as double) as minutes_90s
	cast(fb.touches as double) as touches
	cast(fb.touches_def_3rd as double) as touches_def_3rd
	cast(fb.touches_mid_3rd as double) as touches_mid_3rd
	cast(fb.touches_att_3rd as double) as touches_att_3rd
	cast(fb.touches_att_pen_area as double) as touches_att_pen_area
	cast(fb.dribbles_completed as double) as dribbles_completed
	cast(fb.dribbles as double) as dribbles
	cast(fb.dribbles_completed_pct as double) as dribbles_completed_pct
	cast(fb.miscontrols as double) as miscontrols
	cast(fb.dispossessed as double) as dispossessed
	cast(fb.pass_targets as double) as pass_targets
from Fbref fb
where fb.id in (select id from (Fm20 fm join FbrefInfo fbinfo on (fm.Name = fbinfo.name)))
order by pid
