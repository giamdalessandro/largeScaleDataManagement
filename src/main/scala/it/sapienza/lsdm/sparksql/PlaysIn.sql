select
    fbinfo.name as player,
    fm.club as club
from Fm20 fm join FbrefInfo fbinfo on (fm.Name = fbinfo.name) order by pid