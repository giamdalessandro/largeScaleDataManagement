select
    fm.name as player,
    cast(fm.TRO as integer) as TRO,
    cast(fm.1v1 as integer) as 1v1,
    cast(fm.Han as integer) as Han,
    cast(fm.Cmd as integer) as Cmd
from Fm20 fm order by player