select
    da.id as defensiveAbilityId,
    brt.id as birthId,
    rl.id as roleId,
    porg.id as playerOrganizationId,
    tackles,
    tacklesWon,
    cards_yellow,
    cards_red
from
    DefensivePerformanceFull dpf
    join DefensiveAbility da on (dpf.ca = da.ca and dpf.agg = da.agg and dpf.tck = da.tck and dpf.pen = da.pen and dpf.mar = da.mar)
    join PlayerOrganization porg on (dpf.playerFullName = porg.player and dpf.squad = porg.squad and dpf.comp = porg.comp)
    join Birth brt on (dpf.city = brt.city and dpf.country = brt.country)
    join Role rl on (dpf.position = rl.role_complete)
