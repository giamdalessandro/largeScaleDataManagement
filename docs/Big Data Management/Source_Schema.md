# FBref

It contains statistics about real soccer player performances for the Big 5 European leagues, for seasons from 2012/2013 to 2021/2022.
Data comes from [FBref.com](https://fbref.com/en/), famous international Web portal devoted to tracking statistics for football teams and players from around the world.

## Defense

**Defense**(id, season, country, comp_level, lg_finish, squad, age, minutes_90s, tackles, tackles_won, tackles_def_3rd, tackles_mid_3rd, tackles_att_3rd, dribble_tackles, dribbles_vs, dribble_tackles_pct, dribbled_past, pressures, pressure_regains, pressure_regain_pct, pressures_def_3rd, pressures_mid_3rd, pressures_att_3rd, blocks, blocked_shots, blocked_shots_saves, blocked_passes, interceptions, tackles_interceptions, clearances, errors)

ar(Defense) = 31

Contains data on a player's defensive performance.

## GCA

**GCA**(id, season, country, comp_level, lg_finish, squad, age, minutes_90s, sca, sca_per90, sca_passes_live, sca_passes_dead, sca_dribbles, sca_shots, sca_fouled, sca_defense, gca, gca_per90, gca_passes_live, gca_passes_dead, gca_dribbles, gca_shots, gca_fouled, gca_defense)

ar(GCA) = 24

Contains data on a player's goal and shot creation.

## Info

**Info**(id, created, name, position, foot, height, weight, dob, cityob, countryob, nt, club, age)

ar(Info) = 13

Contains general information about a player.

## Keeper

**Keeper**(id, season, country, comp_level, lg_finish, squad, age, games_gk, games_starts_gk, minutes_gk, minutes_90s, goals_against_gk, goals_against_per90_gk, shots_on_target_against, saves, save_pct, wins_gk, draws_gk, losses_gk, clean_sheets, clean_sheets_pct, pens_att_gk, pens_allowed, pens_saved, pens_missed_gk, pens_save_pct)

ar(Keeper) = 26

Contains data on goalkeeper performance.

## KeeperAdv

**KeeperAdv**(id, season, country, comp_level, lg_finish, squad, age, minutes_90s, goals_against_gk, pens_allowed, free_kick_goals_against_gk, corner_kick_goals_against_gk, own_goals_against_gk, psxg_gk, psnpxg_per_shot_on_target_against, psxg_net_gk, psxg_net_per90_gk, passes_completed_launched_gk, passes_launched_gk, passes_pct_launched_gk, passes_gk, passes_throws_gk, pct_passes_launched_gk, passes_length_avg_gk, goal_kicks, pct_goal_kicks_launched, goal_kick_length_avg, crosses_gk, crosses_stopped_gk, crosses_stopped_pct_gk, def_actions_outside_pen_area_gk, def_actions_outside_pen_area_per90_gk, avg_distance_def_actions_gk)

ar(KeeperAdv) = 33

Contains advanced data for goalkeeper performance.

## Misc

**Misc**(id, season, country, comp_level, lg_finish, squad, age, minutes_90s, cards_yellow, cards_red, cards_yellow_red, fouls, fouled, offsides, crosses, interceptions, tackles_won, pens_won, pens_conceded, own_goals, ball_recoveries, aerials_won, aerials_lost, aerials_won_pct)

ar(Misc) = 24

Contains miscellaneous player performance data.

## Passing

**Passing**(id, season, country, comp_level, lg_finish, squad, age, minutes_90s, passes_completed, passes, passes_pct, passes_total_distance, passes_progressive_distance, passes_completed_short, passes_short, passes_pct_short, passes_completed_medium, passes_medium, passes_pct_medium, passes_completed_long, passes_long, passes_pct_long, assists, xa, xa_net, assisted_shots, passes_into_final_third, passes_into_penalty_area, crosses_into_penalty_area, progressive_passes)

ar(Passing) = 30

Contains passing data.

## PassingTypes

**PassingTypes**(id, season, country, comp_level, lg_finish, squad, age, minutes_90s, passes, passes_live, passes_dead, passes_free_kicks, through_balls, passes_pressure, passes_switches, crosses, corner_kicks, corner_kicks_in, corner_kicks_out, corner_kicks_straight, passes_ground, passses_low, passes_high, passes_left_foot, passes_right_foot, passes_head, throw_ins, passses_other_body, passes_completed, passes_offsides, passes_oob, passes_intercepted, passes_blocked)

ar(PassingTypes) = 33

Contains data about players' pass types.

## PlayingTime

**PlayingTime**(id, season, country, comp_level, lg_finish, squad, age, games, minutes, minutes_per_game, minutes_pct, minutes_90s, games_starts, minutes_per_start, games_complete, games_subs, minutes_per_sub, unused_subs, points_per_match, on_goals_for, on_goals_against, plus_minus, plus_minus_per90, plus_minus_wowy, on_xg_for, on_xg_against, xg_plus_minus, xg_plus_minus_per90, xg_plus_minus_wowy)

ar(PlayingTime) = 29

Contains data about a player's playing time.

## Possession

**Possession**(id, season, country, comp_level, lg_finish, squad, age, minutes_90s, touches, touches_def_pen_area, touches_def_3rd, touches_mid_3rd, touches_att_3rd, touches_att_pen_area, touches_live_ball, dribbles_completed, dribbles, dribbles_completed_pct, players_dribbled_past, nutmegs, carries, carry_distance, carry_progressive_distance, progressive_carries, carries_into_final_third, carries_into_penalty_area, miscontrols, dispossessed, pass_targets, passes_received, passes_received_pct, progressive_passes_received)

ar(Possession) = 32

Contains possession data.

## Shooting

**Shooting**(id, season, country, comp_level, lg_finish, squad, age, minutes_90s, goals, shots_total, shots_on_target, shots_on_target_pct, shots_total_per90, shots_on_target_per90, goals_per_shot, goals_per_shot_on_target, average_shot_distance, shots_free_kicks, pens_made, pens_att, xg, npxg, npxg_per_shot, xg_net, npxg_net)

ar(Shooting) = 25

Contains data about a player's shooting performance.

## Standard

**Standard**(id, season, country, comp_level, lg_finish, squad, age, games, games_starts, minutes, minutes_90s, goals, assists, goals_pens, pens_made, pens_att, cards_yellow, cards_red, goals_per90, assists_per90, goals_assists_per90, goals_pens_per90, goals_assists_pens_per90, xg, npxg, xa, npxg_xa, xg_per90, xa_per90, xg_xa_per90, npxg_per90, npxg_xa_per90)

ar(Standard) = 32

Contains an overview of player performance data.

# FM20

It contains fictional player attributes contained in the database of Football Manager 2020 (season 2019/20) videogame.
Football Manager simulation gaming has become particularly interesting also in real soccer scouting activities for its realistic recreation of professional world of football.
[https://www.footballmanager.com/features/data-hub](https://www.footballmanager.com/features/data-hub)

**FM20**(id, name, position, club, division, based, nation, height, weight, age, preferred foot, best pos, best role, value, wage, ca, pa, wor, vis, thr, tec, tea, tck, str, sta, tro, ref, pun, pos, pen, pas, pac, 1v1, otb, nat, mar, l th, lon, ldr, kic, jum, hea, han, fre, fla, fir, fin, ecc, dri, det, dec, cro, cor, cnt, cmp, com, cmd, bra, bal, ant, agi, agg, aer, acc)

ar(FM20) = 64