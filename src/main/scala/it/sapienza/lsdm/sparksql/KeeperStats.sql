select
	fb.id as pid
	cast(fb.games_gk as double) as games_gk
	cast(fb.games_starts_gk as double) as games_starts_gk
	cast(fb.minutes_gk as double) as minutes_gk
	cast(fb.minutes_90s as double) as minutes_90s
	cast(fb.goals_against_gk as double) as goals_against_gk
	cast(fb.goals_against_per90_gk as double) as goals_against_per90_gk
	cast(fb.shots_on_target_against as double) as shots_on_target_against
	cast(fb.saves as double) as saves
	cast(fb.save_pct as double) as save_pct
	cast(fb.clean_sheets as double) as clean_sheets
	cast(fb.clean_sheets_pct as double) as clean_sheets_pct
	cast(fb.pens_save_pct as double) as pens_save_pct
from Fbref fb
where fb.id in (select id from (Fm20 fm join FbrefInfo fbinfo on (fm.Name = fbinfo.name)))
order by pid
