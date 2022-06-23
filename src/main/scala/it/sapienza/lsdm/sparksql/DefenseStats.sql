select
    /*def.id as pid,*/
    cast(def.tackles as double) as tackles,
    cast(def.tackles_won as double) as tacklesWon,
    cast(def.pressures as double) as press,
    cast(def.pressure_regains as double) as pressReg,
    cast(def.pressure_regain_pct as double) as pressRegPct,
    cast(def.blocks as double) as blocks,
    cast(def.blocked_shots as double) as blockedSht,
    cast(def.blocked_shots_saves as double) as blockedShtSav,
    cast(def.interceptions as double) as intercept,
    cast(def.clearances as double) as clearence,
    cast(def.errors as double) as errors
	cast(misc.fouls as double) as fouls,
	cast(misc.aerials_won as double) as aerials_won,
	cast(misc.aerials_won_pct as double) as aerials_won_pct,
	cast(misc.cards_yellow as double) as cards_yellow,
	cast(misc.cards_red as double) as cards_red
from FbrefDef def join FbrefMisc misc on (def.pid == misc.pid)
/*order by pid*/