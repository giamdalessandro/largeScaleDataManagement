select
	fb.id as pid,
	cast(fb.cards_yellow as double) as cards_yellow,
	cast(fb.cards_red as double) as cards_red,
	cast(fb.fouls as double) as fouls,
	cast(fb.fouled as double) as fouled,
	cast(fb.offsides as double) as offsides,
	cast(fb.crosses as double) as crosses,
	cast(fb.aerials_won as double) as aerials_won,
	cast(fb.aerials_won_pct as double) as aerials_won_pct
from FbrefMisc fb
order by pid
