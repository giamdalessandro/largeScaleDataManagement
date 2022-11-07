select
    cast(sh.goals as integer),
    cast(sh.shots_total as integer) as shotsTotal,
    cast(sh.shots_on_target as integer) as shotsOnTarget,
    cast(pens_made as integer) as pensMade,

    info.id as id,
    info.name as playerFullName,
    cast(CA as integer) as ca,
    cast(Str as integer) as str,
    cast(Tec as integer) as tec,
    cast(Fin as integer) as fin,
    cast(Cnt as integer) as cnt,

    cityob as city,
    countryob as country,

    info.position as position,

    sh.squad,
    sh.comp_level as comp
from
    FbrefInfo info
    join FbrefShooting sh on info.id = sh.id
    join Fm20 on info.name = Fm20.Name
