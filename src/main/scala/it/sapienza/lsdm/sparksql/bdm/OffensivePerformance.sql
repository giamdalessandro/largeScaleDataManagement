select
    opf.id as abilityId,
    opf.id as presenceId,
    org.id as organizationId,
    player,
    countryOB,
    goals,
    shotsTotal,
    shotsOnTarget,
    pensMade
from
    OffensivePerformanceFull opf
    join Organization org on (opf.squad = org.squad and opf.comp = org.comp)