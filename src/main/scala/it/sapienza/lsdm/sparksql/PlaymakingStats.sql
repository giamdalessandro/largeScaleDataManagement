select
	/*fb.id as pid,*/
	cast(gca.sca as double) as sca,
    cast(gca.sca_per90 as double) as sca90,
    cast(gca.gca as double) as gca,
    cast(gca.gca_per90 as double) as gca90,
	cast(pass.assists as double) as assists,
	cast(std.assists_per90 as double) as assists_per90,
	cast(poss.touches as double) as touches,
	cast(poss.touches_def_3rd as double) as touches_def_3rd,
	cast(poss.touches_mid_3rd as double) as touches_mid_3rd,
	cast(poss.touches_att_3rd as double) as touches_att_3rd,
	cast(poss.touches_att_pen_area as double) as touches_att_pen_area,
	cast(poss.dribbles_completed as double) as dribbles_completed,
	cast(poss.dribbles as double) as dribbles,
	cast(poss.dribbles_completed_pct as double) as dribbles_completed_pct,
	cast(poss.miscontrols as double) as miscontrols,
	cast(poss.dispossessed as double) as dispossessed,
	cast(poss.pass_targets as double) as pass_targets,
	cast(misc.fouled as double) as fouled
from FbrefPoss poss, FbrefPass pass, FbrefGCA gca, FbrefMisc misc, FbrefStd std
/*order by pid*/
