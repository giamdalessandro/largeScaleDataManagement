select
    gka.id as goalkeeperAbilityId,
    brt.id as birthId,
    rl.id as roleId,
    porg.id as playerOrganizationId,
    goal_against_gk,
    shots_on_target_against,
    saves,
    pen_saves_pct
from
    GoalkeeperPerformanceFull gkpf
    join GoalkeeperAbility gka on (gkpf.ca = gka.ca and gkpf.tro = gka.tro and gkpf.v1 = gka.v1 and gkpf.han = gka.han and gkpf.cmd = gka.cmd)
    join PlayerOrganization porg on (gkpf.playerFullName = porg.player and gkpf.squad = porg.squad and gkpf.comp = porg.comp)
    join Birth brt on (gkpf.city = brt.city and gkpf.country = brt.country)
    join Role rl on (gkpf.position = rl.role_complete)