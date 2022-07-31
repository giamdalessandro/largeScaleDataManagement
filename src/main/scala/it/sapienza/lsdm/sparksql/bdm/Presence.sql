select
    info.name as player,
    cast(sh.games as integer),
    cast(sh.mnts as integer) as minutes
from
    FbrefInfo info
    join FbrefPlayingTime pr on info.id = pr.id