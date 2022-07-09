# Player

**Player**(name, position, foot, height, weight, dob, age, cityob, countryob, value, wage, ca, pa)

ar(Player) = 13

Contains general information about the players.

# DefenseStat

**DefenseStats**(player_name, player_squad, tackles, tackles_won, press, press_reg, press_reg_pct, blocks, blocked_sht, blocked_sht_sav, intercept, clearence, errors, fouls, aerials_won, aerials_won_pct, cards_yellow, cards_red)

ar(DefenseStats) = 18

Contains data on a player's defensive performance focusing on most relevant statistics.

# GoalkeeperStat

**GoalkeeperStat**(player_name, player_squad, goals_against_gk, goals_against_per90_gk, shots_on_target_against, saves, save_pct, clean_sheets, clean_sheets_pct, pens_save_pct)

ar(GoalkeeperStat) = 10

Contains data on goalkeeper performance focusing on most relevant statistics.

# GoalStat

**GoalStat**(player_name, player_squad, goals, shots_total, shots_on_target, shots_on_target_pct, shots_total_per90, shots_on_target_per90, goals_per_shot, average_shot_distance, shots_free_kicks, pens_made, pens_att, goals_pens, goals_per90, goals_assists_per90, goals_pens_per90, offsides)

ar(GoalStat) = 18

Contains data on a player's attacking performance in relation to his ability to score and/or to create opportunities.

# PassingStat

**PassingStat**(player_name, player_squad, passes_completed, passes, passes_pct, passes_completed_short, passes_short, passes_pct_short, passes_completed_medium, passes_medium, passes_pct_medium, passes_completed_long, passes_long, passes_pct_long, passes_into_final_third, passes_into_penalty_area, crosses_into_penalty_area, crosses)

ar(PassingStat) = 18

Contains passing data focusing on most relevant statistics.

# PlaymakingStat

**PlaymakingStat**(player_name, player_squad, sca, sca_per90, gca, gca_per90, assists, touches, touches_def_3rd, touches_mid_3rd, touches_att_3rd, touches_att_pen_area, dribbles_completed, dribbles, dribbles_completed_pct, miscontrols, dispossessed, pass_targets, assists_per90, fouled)

ar(PlaymakingStat) = 20

Contains data on a player's performance in relation to his ability to playmake: creating opportunities for the team mates, being at the center of the action.

# PresenceStat

**PresenceStat**(player_name, player_squad, games, mnts, minutes_per_game, minutes_pct, minutes_90s, games_starts, games_complete, games_subs, unused_subs, points_per_match, on_goals_for, on_goals_against, plus_minus, plus_minus_wowy)

ar(PresenceStat) = 16

Contains data on a player's presence on the field and the corresponding results of his team.

# GoalkeeperAbility

**GoalkeeperAbility**(player_name, tro, 1v1, han, cmd)

ar(GoalkeeperAbility) = 5

Contains fictional player attributes relative to goalkeeper.

# MentalAbility

**MentalAbility**(player_name, wor, vis, tea, ref, otb, ldr, fla, cnt, agg)

ar(MentalAbility) = 10

Contains fictional player attributes relative to mental abilities.

# PhysicalAbility

**PhysicalAbility**(player_name, str, sta, pac, jum, agi, aer, acc)

ar(PhysicalAbility) = 8

Contains fictional player attributes relative to physical abilities.

# TechnicalAbility

**TechnicalAbility**(player_name, tec, tck, pen, pas, mar, lth, lon, hea, fir, fin, dri, cro, cor)

ar(TechnicalAbility) = 14

Contains fictional player attributes relative to technical abilities.