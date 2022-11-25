select
    oa.id as offensiveAbilityId,
    brt.id as birthId,
    rl.id as roleId,
    porg.id as playerOrganizationId,
    goals,
    shotsTotal,
    shotsOnTarget,
    pensMade
from
    OffensivePerformanceFull opf
    join OffensiveAbility oa on (opf.ca = oa.ca and opf.cnt = oa.cnt and opf.str = oa.str and opf.tec = oa.tec and opf.fin = oa.fin)
    join PlayerOrganization porg on (opf.playerFullName = porg.player and opf.squad = porg.squad and opf.comp = porg.comp)
    join Birth brt on (opf.city = brt.city and opf.country = brt.country)
    join Role rl on (opf.position = rl.role_complete)