select
    cast(def.tackles as integer) as tackles,
    cast(def.tackles_won as integer) as tacklesWon,
    cast(misc.cards_yellow as integer) as cards_yellow,
    cast(misc.cards_red as integer) as cards_red,

    info.id as id,
    info.name as playerFullName,
    cast(CA as integer) as ca,
    cast(Tck as integer) as tck,
    cast(Agg as integer) as agg,
    cast(Pen as integer) as pen,
    cast(Mar as integer) as mar,

    cityob as city,
    countryob as country,

    info.position as position,

    misc.squad,
    misc.comp_level as comp
from
    FbrefInfo info
    join FbrefMisc misc on info.id = misc.id
    join FbrefDefense def on info.id = def.id
    join Fm20 on info.name = Fm20.Name
