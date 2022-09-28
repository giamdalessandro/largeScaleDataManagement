select
    cast(std.assists as integer) as assists,
    cast(poss.touches as integer) as touches,
    cast(poss.dribbles as integer) as dribbles,
    cast(poss.pass_targets as integer) as pass_targets,

    info.name as playerFullName,
    cast(CA as integer) as ca,
    cast(Vis as integer) as vis,
    cast(Tea as integer) as tea,
    cast(Pas as integer) as pas,
    cast(Dri as integer) as dri,

    cityob as city,
    countryob as country,

    poss.squad,
    poss.comp_level as comp
from
    FbrefInfo info
    join FbrefStandard std on info.id = std.id
    join FbrefPossession poss on info.id = poss.id
    join Fm20 on info.name = Fm20.Name