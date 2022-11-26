select distinct
    city,
    country
from
    GoalkeeperPerformanceFull
union
select distinct
    city,
    country
from
    DefensivePerformanceFull
union
select distinct
    city,
    country
from
    PlaymakingPerformanceFull
union
select distinct
    city,
    country
from
    OffensivePerformanceFull