select
    fbgca.id as pid,
    fbgca.minutes_90s as min90s,
    fbgca.sca as sca,
    fbgca.sca_per90 as sca90,
    fbgca.gca as gca,
    fbgca.gca_per90 as gca90
from FbrefGca fbgca
where fbgca.id in (select id from (Fm20 fm join FbrefInfo fbinfo on (fm.Name = fbinfo.name))) 
order by pid