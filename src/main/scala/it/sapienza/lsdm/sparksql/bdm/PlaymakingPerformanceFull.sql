select
    cast(std.assists as integer) as assists,
    cast(poss.dribbles as integer) as dribbles,
    cast(gcat.sca as integer) as sca,
    cast(gcat.sca_per90 as double) as sca90,
    cast(poss.pass_targets as integer) as pass_targets,
    cast(poss.miscontrols as integer) as miscontrols,
    cast(poss.dispossessed as integer) as dispossessed,
    cast(misc.fouled as integer) as fouled,

    info.id as id,
    info.name as playerFullName,

    cast(CA as integer) as ca,
    cast(Vis as integer) as vis,
    cast(Ldr as integer) as ldr,
    cast(Pas as integer) as pas,
    cast(Dri as integer) as dri,
    cast(Agi as integer) as agi,
    cast(Cnt as integer) as cnt,

    cityob as city,
    countryob as country,

    info.position as position,

    poss.squad,
    poss.comp_level as comp
from
    FbrefInfo info
    join FbrefStandard std on info.id = std.id
    join FbrefPossession poss on info.id = poss.id
    join FbrefGca gcat on info.id = gcat.id
    join FbrefMisc misc on info.id = misc.id
    join Fm20 on info.name = Fm20.Name
