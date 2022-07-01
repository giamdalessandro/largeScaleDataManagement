select
	inf.name as player,
    pass.squad as squad,
	cast(pass.passes_completed as double) as passes_completed,
	cast(pass.passes as double) as passes,
	cast(pass.passes_pct as double) as passes_pct,
	cast(pass.passes_completed_short as double) as passes_completed_short,
	cast(pass.passes_short as double) as passes_short,
	cast(pass.passes_pct_short as double) as passes_pct_short,
	cast(pass.passes_completed_medium as double) as passes_completed_medium,
	cast(pass.passes_medium as double) as passes_medium,
	cast(pass.passes_pct_medium as double) as passes_pct_medium,
	cast(pass.passes_completed_long as double) as passes_completed_long,
	cast(pass.passes_long as double) as passes_long,
	cast(pass.passes_pct_long as double) as passes_pct_long,
	cast(pass.passes_into_final_third as double) as passes_into_final_third,
	cast(pass.passes_into_penalty_area as double) as passes_into_penalty_area,
	cast(pass.crosses_into_penalty_area as double) as crosses_into_penalty_area,
	cast(misc.crosses as double) as crosses
from FbrefPass pass, FbrefMisc misc, FbrefInfo inf 
where (pass.id = misc.id and pass.squad = misc.squad) and (pass.id = inf.id) order by player
