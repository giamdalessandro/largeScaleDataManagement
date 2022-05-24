select
    fbgca.id as pid,
    cast(fbgca.minutes_90s as double) as min90s,
    cast(fbgca.sca as double) as sca,
    cast(fbgca.sca_per90 as double) as sca90,
    cast(fbgca.gca as double) as gca,
    cast(fbgca.gca_per90 as double) as gca90
from FbrefGca fbgca
where fbgca.id in (select id from (Fm20 fm join FbrefInfo fbinfo on (fm.Name = fbinfo.name))) 
order by pid