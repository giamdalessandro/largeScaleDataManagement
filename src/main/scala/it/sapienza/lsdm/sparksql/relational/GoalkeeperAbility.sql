select
    fm.name as player,
    cast(fm.TRO as integer) as TRO,
    cast(fm.v1 as integer) as v1,
    cast(fm.Han as integer) as Han,
    cast(fm.Cmd as integer) as Cmd
from Fm20 fm order by player