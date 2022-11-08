select
    cast(gk.goals_against_gk as integer) as goal_against_gk,
    cast(gk.shots_on_target_against as integer) as shots_on_target_against,
    cast(gk.saves as integer) as saves,
    cast(gk.pens_save_pct as double) as pen_saves_pct,

    info.id as id,
    info.name as playerFullName,
    cast(CA as integer) as ca,
    cast(TRO as integer) as tro,
    cast(v1 as integer) as  ovo,
    cast(Han as integer) as han,
    cast(Cmd as integer) as cmd,

    cityob as city,
    countryob as country,

    info.position as position,

    gk.squad,
    gk.comp_level as comp
from
    FbrefInfo info
    join FbrefKeeper gk on info.id = gk.id
    join Fm20 on info.name = Fm20.Name
