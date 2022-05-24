select
    fbdef.id as pid,
    cast(fbdef.tackles as double) as tackles,
    cast(fbdef.tackles_won as double) as tacklesWon,
    cast(fbdef.pressures as double) as press,
    cast(fbdef.pressure_regains as double) as pressReg,
    cast(fbdef.pressure_regain_pct as double) as pressRegPct,
    cast(fbdef.blocks as double) as blocks,
    cast(fbdef.blocked_shots as double) as blockedSht,
    cast(fbdef.blocked_shots_saves as double) as blockedShtSav,
    cast(fbdef.interceptions as double) as intercept,
    cast(fbdef.clearances as double) as clearence,
    cast(fbdef.errors as double) as errors
from FbrefDef fbdef
where fbdef.id in (select id from (Fm20 fm join FbrefInfo fbinfo on (fm.Name = fbinfo.name))) 
order by pid