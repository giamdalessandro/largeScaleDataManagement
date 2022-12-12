# Offensive Performance

## Join Table

**Measure: goals**

```
select abilityDim.*, roleDim.*, birthDim.*, playerOrgDim.*, fact.goals
from ElephantSQL.public."OFFENSIVE_PERFORMANCE" fact
join OffensiveAbility abilityDim on (fact.offensive_ability_id = abilityDim.id)
join ElephantSQL.public.ROLE roleDim on (fact.role_id = roleDim.id)
join ElephantSQL.public.BIRTH birthDim on (fact.birth_id = birthDim.id)
join ElephantSQL.public.PLAYER_ORGANIZATION playerOrgDim on (fact.player_organization_id = playerOrgDim.id)
```

## Roll-up

**Measure: goals**

```
SELECT country, SUM(goals) AS Sum_goals
FROM (
  select abilityDim.*, roleDim.*, birthDim.*, playerOrgDim.*, fact.goals
  from ElephantSQL.public."OFFENSIVE_PERFORMANCE" fact
  join OffensiveAbility abilityDim on (fact.offensive_ability_id = abilityDim.id)
  join ElephantSQL.public.ROLE roleDim on (fact.role_id = roleDim.id)
  join ElephantSQL.public.BIRTH birthDim on (fact.birth_id = birthDim.id)
  join ElephantSQL.public.PLAYER_ORGANIZATION playerOrgDim on (fact.player_organization_id = playerOrgDim.id)
) nested_0
GROUP BY country
ORDER BY Sum_goals DESC
```

Increase data aggregation focusing on birth dimension only.

## Drill-down

**Measure: goals**

```
SELECT country, city, SUM(goals) AS Sum_goals
FROM (
  select abilityDim.*, roleDim.*, birthDim.*, playerOrgDim.*, fact.goals
  from ElephantSQL.public."OFFENSIVE_PERFORMANCE" fact
  join OffensiveAbility abilityDim on (fact.offensive_ability_id = abilityDim.id)
  join ElephantSQL.public.ROLE roleDim on (fact.role_id = roleDim.id)
  join ElephantSQL.public.BIRTH birthDim on (fact.birth_id = birthDim.id)
  join ElephantSQL.public.PLAYER_ORGANIZATION playerOrgDim on (fact.player_organization_id = playerOrgDim.id)
) nested_0
GROUP BY country, city
ORDER BY Sum_goals DESC
```

Reduce data aggregation considering a lower level of granularity for the birth dimension.

## Slice-and-dice

**Measure: goals**

```
SELECT player_full_name, role_generic, fin, ca, goals
FROM (
  select playerOrgDim.player_full_name, abilityDim.technicalAbility.fin, abilityDim.ca, roleDim.role_generic, fact.goals
  from ElephantSQL.public."OFFENSIVE_PERFORMANCE" fact
  join OffensiveAbility abilityDim on (fact.offensive_ability_id = abilityDim.id)
  join ElephantSQL.public.ROLE roleDim on (fact.role_id = roleDim.id)
  join ElephantSQL.public.BIRTH birthDim on (fact.birth_id = birthDim.id)
  join ElephantSQL.public.PLAYER_ORGANIZATION playerOrgDim on (fact.player_organization_id = playerOrgDim.id)
  where abilityDim.technicalAbility.fin>13 and abilityDim.ca>150 and roleDim.role_generic='FW'
) nested_0
ORDER BY goals DESC
```

Decrease cube dimensionality by setting constraints on dimensional attributes. Not working at aggregation levels but simply selecting some portions of cubes

## Pivoting

https://community.dremio.com/t/how-to-transpose-data/1552

**Measure: goals**

```
TODO
```

Change the structure of the cube: just reorganizing the view of the same data.

## Drill-across

**Measures: goals and assists**

```
-- Join Table
select abilityDim.*, roleDim.*, birthDim.*, playerOrgDim.*, fact1.goals, fact2.assists
from ElephantSQL.public."OFFENSIVE_PERFORMANCE" fact1
join ElephantSQL.public."PLAYMAKING_PERFORMANCE" fact2 on (fact1.player_organization_id = fact2.player_organization_id and fact1.role_id = fact2.role_id and fact1.birth_id = fact2.birth_id)
join OffensiveAbility abilityDim on (fact1.offensive_ability_id = abilityDim.id)
join ElephantSQL.public.ROLE roleDim on (fact1.role_id = roleDim.id)
join ElephantSQL.public.BIRTH birthDim on (fact1.birth_id = birthDim.id)
join ElephantSQL.public.PLAYER_ORGANIZATION playerOrgDim on (fact1.player_organization_id = playerOrgDim.id)
```

```
SELECT player_full_name, role_generic, ca, goals, assists, (goals + assists) as goalsAssits
FROM (
  select playerOrgDim.player_full_name, abilityDim.ca, roleDim.role_generic, fact1.goals, fact2.assists
  from ElephantSQL.public."OFFENSIVE_PERFORMANCE" fact1
  join ElephantSQL.public."PLAYMAKING_PERFORMANCE" fact2 on (fact1.player_organization_id = fact2.player_organization_id and fact1.role_id = fact2.role_id and fact1.birth_id = fact2.birth_id)
  join OffensiveAbility abilityDim on (fact1.offensive_ability_id = abilityDim.id)
  join ElephantSQL.public.ROLE roleDim on (fact1.role_id = roleDim.id)
  join ElephantSQL.public.BIRTH birthDim on (fact1.birth_id = birthDim.id)
  join ElephantSQL.public.PLAYER_ORGANIZATION playerOrgDim on (fact1.player_organization_id = playerOrgDim.id)
) nested_0
WHERE role_generic NOT LIKE '%DF%' AND role_generic NOT LIKE '%GK%'
ORDER BY ca DESC
```

```
SELECT player_full_name, role_generic, ca, goals, assists, goalsAssits
FROM (
  SELECT player_full_name, role_generic, ca, goals, assists, (goals + assists) as goalsAssits
  FROM (
    select playerOrgDim.player_full_name, abilityDim.ca, roleDim.role_generic, fact1.goals, fact2.assists
    from ElephantSQL.public."OFFENSIVE_PERFORMANCE" fact1
    join ElephantSQL.public."PLAYMAKING_PERFORMANCE" fact2 on (fact1.player_organization_id = fact2.player_organization_id and fact1.role_id = fact2.role_id and fact1.birth_id = fact2.birth_id)
    join OffensiveAbility abilityDim on (fact1.offensive_ability_id = abilityDim.id)
    join ElephantSQL.public.ROLE roleDim on (fact1.role_id = roleDim.id)
    join ElephantSQL.public.BIRTH birthDim on (fact1.birth_id = birthDim.id)
    join ElephantSQL.public.PLAYER_ORGANIZATION playerOrgDim on (fact1.player_organization_id = playerOrgDim.id)
  ) nested_0
  WHERE role_generic NOT LIKE '%DF%' AND role_generic NOT LIKE '%GK%'
) nested_0
ORDER BY goalsAssits DESC
```

Combine data in different cubes with common aspects (same aggregation levels)