select
    info.name as player,
    info.countyob as countryOB,
    cast(sh.goals as integer),
    cast(sh.shots_total as integer) as shotsTotal,
    cast(sh.shots_on_target as integer) as shotsOnTarget,
    cast(pens_made as integer) as pensMade
from
    FbrefInfo info
    join FbrefShooting sh on info.id = sh.id