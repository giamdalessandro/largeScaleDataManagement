-- defense

alter session set `store.format`='csv';

create table export.fbrefDefenseExtract as
select id,season,country,comp_level,lg_finish,squad,age,minutes_90s,tackles,tackles_won,pressures,pressure_regains,pressure_regain_pct,blocks,blocked_shots,blocked_shots_saves,interceptions,clearances,errors
from input.`fbref-defense.csv`
where
    season = '2019-2020'
    and country in ('ITA', 'GER', 'ESP', 'ENG')
    and comp_level in ('1. Serie A', '1. Bundesliga', '1. La Liga', '1. Premier League')
;

-- gca

alter session set `store.format`='csv';

create table export.fbrefGcaExtract as
select id,season,country,comp_level,lg_finish,squad,age,minutes_90s,sca,sca_per90,gca,gca_per90
from input.`fbref-gca.csv`
where
    season = '2019-2020'
    and country in ('ITA', 'GER', 'ESP', 'ENG')
    and comp_level in ('1. Serie A', '1. Bundesliga', '1. La Liga', '1. Premier League')
;

-- keeper

alter session set `store.format`='csv';

create table export.fbrefKeeperExtract as
select id,season,country,comp_level,lg_finish,squad,age,games_gk,games_starts_gk,minutes_gk,minutes_90s,goals_against_gk,goals_against_per90_gk,shots_on_target_against,saves,save_pct,clean_sheets,clean_sheets_pct,pens_save_pct
from input.`fbref-keeper.csv`
where
    season = '2019-2020'
    and country in ('ITA', 'GER', 'ESP', 'ENG')
    and comp_level in ('1. Serie A', '1. Bundesliga', '1. La Liga', '1. Premier League')
;

-- misc

alter session set `store.format`='csv';

create table export.fbrefMiscExtract as
select id,season,country,comp_level,lg_finish,squad,age,minutes_90s,cards_yellow,cards_red,fouls,fouled,offsides,crosses,aerials_won,aerials_won_pct
from input.`fbref-misc.csv`
where
    season = '2019-2020'
    and country in ('ITA', 'GER', 'ESP', 'ENG')
    and comp_level in ('1. Serie A', '1. Bundesliga', '1. La Liga', '1. Premier League')
;

-- passing

alter session set `store.format`='csv';

create table export.fbrefPassingExtract as
select id,season,country,comp_level,lg_finish,squad,age,minutes_90s,passes_completed,passes,passes_pct,passes_completed_short,passes_short,passes_pct_short,passes_completed_medium,passes_medium,passes_pct_medium,passes_completed_long,passes_long,passes_pct_long,assists,passes_into_final_third,passes_into_penalty_area,crosses_into_penalty_area
from input.`fbref-passing.csv`
where
    season = '2019-2020'
    and country in ('ITA', 'GER', 'ESP', 'ENG')
    and comp_level in ('1. Serie A', '1. Bundesliga', '1. La Liga', '1. Premier League')
;

-- playing_time

alter session set `store.format`='csv';

create table export.fbrefPlayingTimeExtract as
select id,season,country,comp_level,lg_finish,squad,age,games,mnts,minutes_per_game,minutes_pct,minutes_90s,games_starts,games_complete,games_subs,unused_subs,points_per_match,on_goals_for,on_goals_against,plus_minus,plus_minus_wowy
from input.`fbref-playing_time.csv`
where
    season = '2019-2020'
    and country in ('ITA', 'GER', 'ESP', 'ENG')
    and comp_level in ('1. Serie A', '1. Bundesliga', '1. La Liga', '1. Premier League')
;

-- possession

alter session set `store.format`='csv';

create table export.fbrefPossessionExtract as
select id,season,country,comp_level,lg_finish,squad,age,minutes_90s,touches,touches_def_3rd,touches_mid_3rd,touches_att_3rd,touches_att_pen_area,dribbles_completed,dribbles,dribbles_completed_pct,miscontrols,dispossessed,pass_targets
from input.`fbref-possession.csv`
where
    season = '2019-2020'
    and country in ('ITA', 'GER', 'ESP', 'ENG')
    and comp_level in ('1. Serie A', '1. Bundesliga', '1. La Liga', '1. Premier League')
;

-- shooting

alter session set `store.format`='csv';

create table export.fbrefShootingExtract as
select id,season,country,comp_level,lg_finish,squad,age,minutes_90s,goals,shots_total,shots_on_target,shots_on_target_pct,shots_total_per90,shots_on_target_per90,goals_per_shot,average_shot_distance,shots_free_kicks,pens_made,pens_att
from input.`fbref-shooting.csv`
where
    season = '2019-2020'
    and country in ('ITA', 'GER', 'ESP', 'ENG')
    and comp_level in ('1. Serie A', '1. Bundesliga', '1. La Liga', '1. Premier League')
;

-- standard

alter session set `store.format`='csv';

create table export.fbrefStandardExtract as
select id,season,country,comp_level,lg_finish,squad,age,games,games_starts,mnts,minutes_90s,goals,assists,goals_pens,pens_made,pens_att,cards_yellow,cards_red,goals_per90,assists_per90,goals_assists_per90,goals_pens_per90
from input.`fbref-standard.csv`
where
    season = '2019-2020'
    and country in ('ITA', 'GER', 'ESP', 'ENG')
    and comp_level in ('1. Serie A', '1. Bundesliga', '1. La Liga', '1. Premier League')
;

-- info

alter session set `store.format`='csv';

create table export.fbrefInfoExtract as
select distinct info.id,info.created,info.name,info.position,info.foot,info.height,info.weight,info.dob,info.cityob,info.countryob
from 
    input.`fbref-info.csv` info
    left join input.`fbref-standard.csv` std on info.id=std.id
where
    std.season = '2019-2020'
    and std.country in ('ITA', 'GER', 'ESP', 'ENG')
    and std.comp_level in ('1. Serie A', '1. Bundesliga', '1. La Liga', '1. Premier League')
;
