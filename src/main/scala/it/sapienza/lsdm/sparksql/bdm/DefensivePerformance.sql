select
    dpf.id as playerDefensiveAbilityId,
    brt.id as birthId,
    org.id as organizationId,
    tackles,
    tacklesWon,
    cards_yellow,
    cards_red
from
    DefensivePerformanceFull dpf
    join Organization org on (dpf.squad = org.squad and dpf.comp = org.comp)
    join Birth brt on (dpf.city = brt.city and dpf.country = brt.country)