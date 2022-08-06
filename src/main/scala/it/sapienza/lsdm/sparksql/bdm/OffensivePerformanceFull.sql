select
    info.name as player,
    info.countryob as countryOB,
    cast(sh.goals as integer),
    cast(sh.shots_total as integer) as shotsTotal,
    cast(sh.shots_on_target as integer) as shotsOnTarget,
    cast(pens_made as integer) as pensMade,

    cast(CA as integer) as ca,
    cast(Str as integer) as str,
    cast(Tec as integer) as tec,
    cast(Fin as integer) as fin,
    cast(Cnt as integer) as cnt,

    cast(pr.games as integer),
    cast(pr.mnts as integer) as minutes,

    pr.squad,
    pr.comp_level as comp
from
    FbrefInfo info
    join FbrefShooting sh on info.id = sh.id
    join Fm20 on info.name = Fm20.Name
    join FbrefPlayingTime pr on info.id = pr.id