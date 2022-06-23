select
    fbinfo.id as pid,
    fm.club as club
from Fm20 fm join FbrefInfo fbinfo on (fm.Name = fbinfo.name) order by pid