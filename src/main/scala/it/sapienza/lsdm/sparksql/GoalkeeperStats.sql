select
	inf.name as player,
	cast(fb.goals_against_gk as double) as goals_against_gk,
	cast(fb.goals_against_per90_gk as double) as goals_against_per90_gk,
	cast(fb.shots_on_target_against as double) as shots_on_target_against,
	cast(fb.saves as double) as saves,
	cast(fb.save_pct as double) as save_pct,
	cast(fb.clean_sheets as double) as clean_sheets,
	cast(fb.clean_sheets_pct as double) as clean_sheets_pct,
	cast(fb.pens_save_pct as double) as pens_save_pct
from FbrefKeep fb, FbrefInfo inf where (fb.id = inf.id) order by player
