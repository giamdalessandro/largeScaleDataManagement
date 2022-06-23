select
    fm.name as Player,
    cast(fm.Tec as integer) as Tec,
    cast(fm.Tck as integer) as Tck,
    cast(fm.Pen as integer) as Pen,
    cast(fm.Pen as integer) as Pen,
    cast(fm.Mar as integer) as Mar,
    cast(fm.L_Th as integer) as L_Th,
    cast(fm.Lon as integer) as Lon,
    cast(fm.Hea as integer) as Hea,
    cast(fm.Fir as integer) as Fir,
    cast(fm.Fin as integer) as Fin,
    cast(fm.Dri as integer) as Dri,
    cast(fm.Cro as integer) as Cro,
    cast(fm.Cor as integer) as Cor
from Fm20 fm order by player