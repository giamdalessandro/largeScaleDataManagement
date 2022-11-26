select distinct
    playerFullName as player,
    squad,
    comp
from
    GoalkeeperPerformanceFull
union
select distinct
    playerFullName as player,
    squad,
    comp
from
    DefensivePerformanceFull
union
select distinct
    playerFullName as player,
    squad,
    comp
from
    PlaymakingPerformanceFull
union
select distinct
    playerFullName as player,
    squad,
    comp
from
    OffensivePerformanceFull