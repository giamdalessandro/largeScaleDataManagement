select
    pmpf.id as playerPlaymakingAbilityId,
    brt.id as birthId,
    org.id as organizationId,
    assists,
    touches,
    dribbles,
    pass_targets
from
    PlaymakingPerformanceFull pmpf
    join Organization org on (pmpf.squad = org.squad and pmpf.comp = org.comp)
    join Birth brt on (pmpf.city = brt.city and pmpf.country = brt.country)