select
    opf.id as playerOffensiveAbilityId,
    brt.id as birthId,
    org.id as organizationId,
    goals,
    shotsTotal,
    shotsOnTarget,
    pensMade
from
    OffensivePerformanceFull opf
    join Organization org on (opf.squad = org.squad and opf.comp = org.comp)
    join Birth brt on (opf.city = brt.city and opf.country = brt.country)