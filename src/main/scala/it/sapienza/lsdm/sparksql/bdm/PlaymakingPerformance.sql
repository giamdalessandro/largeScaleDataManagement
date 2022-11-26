select
    pma.id as playmakingAbilityId,
    brt.id as birthId,
    rl.id as roleId,
    porg.id as playerOrganizationId,
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
    join PlaymakingAbility pma on (pmpf.ca = pma.ca and pmpf.vis = pma.vis and pmpf.ldr = pma.ldr and pmpf.pas = pma.pas and pmpf.dri = pma.dri and pmpf.agi = pma.agi and pmpf.cnt = pma.cnt)
    join PlayerOrganization porg on (pmpf.playerFullName = porg.player and pmpf.squad = porg.squad and pmpf.comp = porg.comp)
    join Birth brt on (pmpf.city = brt.city and pmpf.country = brt.country)
    join Role rl on (pmpf.position = rl.role_complete)