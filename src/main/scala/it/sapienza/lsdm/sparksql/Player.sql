select distinct
    fbinfo.name as name,
    fbinfo.position as position,
    fbinfo.foot as foot,
    cast(fbinfo.height as double) as height,
    cast(fbinfo.weight as double) as weight,
    cast(fm.Age as integer) as age,
    fbinfo.dob as dob,
    fbinfo.cityob as cityOb,
    fbinfo.countryob as countryOb,
    fm.Preferred_Foot as prefFoot,
    fm.Best_Pos as bestPos,
    fm.Best_Role as bestRole,
    cast(fm.Value as double) as value,
    cast(fm.Wage as double) as wage
from Fm20 fm, FbrefInfo fbinfo where (fm.Name = fbinfo.name) order by name
/* may use cartesian product instead of join*/
/*from Fm20 fm join FbrefInfo fbinfo on (fm.Name = fbinfo.name)*/
