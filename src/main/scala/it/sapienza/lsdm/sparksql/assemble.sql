select
    null as id,
    fbinfo.name as name,
    fbinfo.position as position,
    fbinfo.foot as foot,
    cast(fbinfo.height as double) as height,
    cast(fm.Age as integer) as age,
    fbinfo.dob as dob,
    fbinfo.cityob as cityOb,
    fbinfo.countryob as countryOb
from Fm20 fm join FbrefInfo fbinfo on (fm.Name = fbinfo.name)