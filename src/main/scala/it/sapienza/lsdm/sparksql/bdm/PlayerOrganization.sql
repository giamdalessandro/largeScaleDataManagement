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
    OffensivePerformanceFull