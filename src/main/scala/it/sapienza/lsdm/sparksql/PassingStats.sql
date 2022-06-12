select
	fb.id as pid,
	cast(fb.passes_completed as double) as passes_completed,
	cast(fb.passes as double) as passes,
	cast(fb.passes_pct as double) as passes_pct,
	cast(fb.passes_completed_short as double) as passes_completed_short,
	cast(fb.passes_short as double) as passes_short,
	cast(fb.passes_pct_short as double) as passes_pct_short,
	cast(fb.passes_completed_medium as double) as passes_completed_medium,
	cast(fb.passes_medium as double) as passes_medium,
	cast(fb.passes_pct_medium as double) as passes_pct_medium,
	cast(fb.passes_completed_long as double) as passes_completed_long,
	cast(fb.passes_long as double) as passes_long,
	cast(fb.passes_pct_long as double) as passes_pct_long,
	cast(fb.assists as double) as assists,
	cast(fb.passes_into_final_third as double) as passes_into_final_third,
	cast(fb.passes_into_penalty_area as double) as passes_into_penalty_area,
	cast(fb.crosses_into_penalty_area as double) as crosses_into_penalty_area
from FbrefPass fb
order by pid
