select
    fm.name as player,
    cast(fm.Str as integer) as Str,
    cast(fm.Sta as integer) as Sta,
    cast(fm.Pac as integer) as Pac,
    cast(fm.Jum as integer) as Jum,
    cast(fm.Agi as integer) as Agi,
    cast(fm.Aer as integer) as Aer,
    cast(fm.Acc as integer) as Acc
from Fm20 fm order by player