select
    gkpf.id as playerGoalkeeperAbilityId,
    brt.id as birthId,
    rl.id as roleId,
    org.id as organizationId,
    goal_against_gk,
    shots_on_target_against,
    saves,
    pen_saves_pct
from
    GoalkeeperPerformanceFull gkpf
    join Organization org on (gkpf.squad = org.squad and gkpf.comp = org.comp)
    join Birth brt on (gkpf.city = brt.city and gkpf.country = brt.country)
    join Role rl on (gkpf.position = rl.role_complete)