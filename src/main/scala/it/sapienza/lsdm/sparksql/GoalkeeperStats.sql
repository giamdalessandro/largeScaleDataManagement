select
	inf.name as player,
    kp.squad as squad,
	cast(kp.goals_against_gk as double) as goals_against_gk,
	cast(kp.goals_against_per90_gk as double) as goals_against_per90_gk,
	cast(kp.shots_on_target_against as double) as shots_on_target_against,
	cast(kp.saves as double) as saves,
	cast(kp.save_pct as double) as save_pct,
	cast(kp.clean_sheets as double) as clean_sheets,
	cast(kp.clean_sheets_pct as double) as clean_sheets_pct,
	cast(kp.pens_save_pct as double) as pens_save_pct
from FbrefKeep kp, FbrefInfo inf 
where (kp.id = inf.id) order by player
