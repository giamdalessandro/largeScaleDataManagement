select Name, Position, Club, Division, Nation, Height, Weight, Age, Preferred Foot, Best Pos, Best Role, Value, Wage, CA, PA, Wor, Vis, Tec, Tea, Tck, Str, Sta, TRO, Ref, Pen, Pas, Pac, 1v1, OtB, Mar, L Th, Lon, Ldr, Jum, Hea, Han, Fla, Fir, Fin, Dri, Cro, Cor, Cnt, Cmd, Agi, Agg, Aer, Acc
from `fm20.csv`
where Division in ('Spanish First Division', 'Italian Serie A', 'Bundesliga', 'English Premier Division')
;

alter session set `store.format`='csv';
create table export.fm20Extract as
select Name, Position, Club, Division, Nation, Height, Weight, Age, Preferred_Foot, Best_Pos, Best_Role, Value, Wage, CA, PA, Wor, Vis, Tec, Tea, Tck, Str, Sta, TRO, Ref, Pen, Pas, Pac, 1v1, OtB, Mar, L_Th, Lon, Ldr, Jum, Hea, Han, Fla, Fir, Fin, Dri, Cro, Cor, Cnt, Cmd, Agi, Agg, Aer, Acc
from input.`fm20.csv`
where Division in ('Spanish First Division', 'Italian Serie A', 'Bundesliga', 'English Premier Division')
;