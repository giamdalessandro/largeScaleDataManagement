select
    fm.name as Player,
    cast(fm.Wor as integer) as Wor,
    cast(fm.Vis as integer) as Vis,
    cast(fm.Tea as integer) as Tea,
    cast(fm.Pen as integer) as Pen,
    cast(fm.Ref as integer) as Ref,
    cast(fm.Otb as integer) as OtB,
    cast(fm.Ldr as integer) as Ldr,
    cast(fm.Fla as integer) as Fla,
    cast(fm.Cnt as integer) as Cnt,
    cast(fm.Agg as integer) as Agg
from Fm20 fm order by player