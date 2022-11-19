select
    pmpf.id as playerPlaymakingAbilityId,
    brt.id as birthId,
    rl.id as roleId,
    org.id as organizationId,
    assists,
    dribbles,
    sca,
    sca90,
    pass_targets,
    miscontrols,
    dispossessed,
    fouled
from
    PlaymakingPerformanceFull pmpf
    join Organization org on (pmpf.squad = org.squad and pmpf.comp = org.comp)
    join Birth brt on (pmpf.city = brt.city and pmpf.country = brt.country)
    join Role rl on (pmpf.position = rl.role_complete)