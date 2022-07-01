select distinct
    info.name as name,
    info.position as position,
    info.foot as foot,
    cast(info.height as double) as height,
    cast(info.weight as double) as weight,
    cast(fm.Age as integer) as age,
    info.dob as dob,
    info.cityob as cityOb,
    info.countryob as countryOb,
    std.squad as club,
    std.comp_level as comp_level,
    cast(fm.Value as double) as value,
    cast(fm.Wage as double) as wage,
    cast(fm.CA as double) as ca,
    cast(fm.PA as double) as pa
from Fm20 fm, FbrefInfo info, FbrefStd std
where (fm.Name = info.name) and (info.id = std.id) order by name