# Player

$$
\begin{split}
&\forall name, position, foot, height, weight, dob, age, cityob, countryob, club, value, wage, ca, pa . \\
&\exists id, \\
&\exists i2, i11 \\
&\exists s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32 \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f18, f19, f20, f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f36, f37, f38, f39, f40, f41, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64 . \\
&Info(id, i2, name, position, foot, height, weight, dob, cityob, countryob, i11, club, age) \\
&\wedge Standard(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32) \\
&\wedge FM20(f1, name, f3, f4, \textrm{``Italian Serie A''}, f6, f7, f8, f9, f10, f11, f12, f13, value, wage, ca, pa, f18, f19, f20, f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f36, f37, f38, f39, f40, f41, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64) \\
&\rightarrow Player(name, position, foot, height, weight, dob, age, cityob, countryob, club, \textrm{``1. Serie A''}, value, wage, ca, pa)
\end{split}
$$

$$
\begin{split}
&\forall name, position, foot, height, weight, dob, age, cityob, countryob, club, value, wage, ca, pa . \\
&\exists id, \\
&\exists i2, i11 \\
&\exists s2, s3, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32 \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f18, f19, f20, f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f36, f37, f38, f39, f40, f41, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64 . \\
&Info(id, i2, name, position, foot, height, weight, dob, cityob, countryob, i11, club, age) \\
&\wedge Standard(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32) \\
&\wedge FM20(f1, name, f3, f4, \textrm{``Bundesliga''}, f6, f7, f8, f9, f10, f11, f12, f13, value, wage, ca, pa, f18, f19, f20, f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f36, f37, f38, f39, f40, f41, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64) \\
&\rightarrow Player(name, position, foot, height, weight, dob, age, cityob, countryob, club, \textrm{``1. Bundesliga''}, value, wage, ca, pa)
\end{split}
$$

$$
\begin{split}
&\forall name, position, foot, height, weight, dob, age, cityob, countryob, club, value, wage, ca, pa . \\
&\exists id, \\
&\exists i2, i11 \\
&\exists s2, s3, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32 \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f18, f19, f20, f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f36, f37, f38, f39, f40, f41, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64 . \\
&Info(id, i2, name, position, foot, height, weight, dob, cityob, countryob, i11, club, age) \\
&\wedge Standard(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32) \\
&\wedge FM20(f1, name, f3, f4, \textrm{``Spanish First Division''}, f6, f7, f8, f9, f10, f11, f12, f13, value, wage, ca, pa, f18, f19, f20, f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f36, f37, f38, f39, f40, f41, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64) \\
&\rightarrow Player(name, position, foot, height, weight, dob, age, cityob, countryob, club, \textrm{``1. La Liga''}, value, wage, ca, pa)
\end{split}
$$

$$
\begin{split}
&\forall name, position, foot, height, weight, dob, age, cityob, countryob, club, value, wage, ca, pa . \\
&\exists id, \\
&\exists i2, i11 \\
&\exists s2, s3, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32 \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f18, f19, f20, f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f36, f37, f38, f39, f40, f41, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64 . \\
&Info(id, i2, name, position, foot, height, weight, dob, cityob, countryob, i11, club, age) \\
&\wedge Standard(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32) \\
&\wedge FM20(f1, name, f3, f4, \textrm{``English Premier Division''}, f6, f7, f8, f9, f10, f11, f12, f13, value, wage, ca, pa, f18, f19, f20, f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f36, f37, f38, f39, f40, f41, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64) \\
&\rightarrow Player(name, position, foot, height, weight, dob, age, cityob, countryob, club, \textrm{``1. Premier League''}, value, wage, ca, pa)
\end{split}
$$

# DefenseStat

$$
\begin{split}
&\forall player\_name, tackles, tackles\_won, press, press\_reg, press\_reg\_pct, blocks, blocked\_sht, blocked\_sht\_sav, intercept, clearence, errors, fouls, aerials\_won, aerials\_won\_pct, cards\_yellow, cards\_red . \\
&\exists id, d5, d6, d7, d8, d11, d12, d13, d14, d15, d16, d17, d21, d22, d23, d27, d29 \\
&\exists m5, m6, m7, m8, m11, m13, m14, m15, m16, m17, m18, m19, m20, m21, m23 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Defense(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, d5, d6, d7, d8, tackles, tackles\_won, d11, d12, d13, d14, d15, d16, d17, press, press\_reg, press\_reg\_pct, d21, d22, d23, blocks, blocked_sht, blocked_sho_sav, d27, intercept, d29, clearance, errors) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, m5, m6, m7, m8, cards\_yellow, cards\_red, m11, fouls, m13, m14, m15, m16, m17, m18, m19, m20, m21, aerials\_won, m23, aerials\_won\_pct) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow DefenseStat(player\_name, tackles, tackles\_won, press, press\_reg, press\_reg\_pct, blocks, blocked\_sht, blocked\_sht\_sav, intercept, clearence, errors, fouls, aerials\_won, aerials\_won\_pct, cards\_yellow, cards\_red)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, tackles, tackles\_won, press, press\_reg, press\_reg\_pct, blocks, blocked\_sht, blocked\_sht\_sav, intercept, clearence, errors, fouls, aerials\_won, aerials\_won\_pct, cards\_yellow, cards\_red . \\
&\exists id, d5, d6, d7, d8, d11, d12, d13, d14, d15, d16, d17, d21, d22, d23, d27, d29 \\
&\exists m5, m6, m7, m8, m11, m13, m14, m15, m16, m17, m18, m19, m20, m21, m23 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Defense(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, d5, d6, d7, d8, tackles, tackles\_won, d11, d12, d13, d14, d15, d16, d17, press, press\_reg, press\_reg\_pct, d21, d22, d23, blocks, blocked_sht, blocked_sho_sav, d27, intercept, d29, clearance, errors) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, m5, m6, m7, m8, cards\_yellow, cards\_red, m11, fouls, m13, m14, m15, m16, m17, m18, m19, m20, m21, aerials\_won, m23, aerials\_won\_pct) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow DefenseStat(player\_name, tackles, tackles\_won, press, press\_reg, press\_reg\_pct, blocks, blocked\_sht, blocked\_sht\_sav, intercept, clearence, errors, fouls, aerials\_won, aerials\_won\_pct, cards\_yellow, cards\_red)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, tackles, tackles\_won, press, press\_reg, press\_reg\_pct, blocks, blocked\_sht, blocked\_sht\_sav, intercept, clearence, errors, fouls, aerials\_won, aerials\_won\_pct, cards\_yellow, cards\_red . \\
&\exists id, d5, d6, d7, d8, d11, d12, d13, d14, d15, d16, d17, d21, d22, d23, d27, d29 \\
&\exists m5, m6, m7, m8, m11, m13, m14, m15, m16, m17, m18, m19, m20, m21, m23 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Defense(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, d5, d6, d7, d8, tackles, tackles\_won, d11, d12, d13, d14, d15, d16, d17, press, press\_reg, press\_reg\_pct, d21, d22, d23, blocks, blocked_sht, blocked_sho_sav, d27, intercept, d29, clearance, errors) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, m5, m6, m7, m8, cards\_yellow, cards\_red, m11, fouls, m13, m14, m15, m16, m17, m18, m19, m20, m21, aerials\_won, m23, aerials\_won\_pct) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow DefenseStat(player\_name, tackles, tackles\_won, press, press\_reg, press\_reg\_pct, blocks, blocked\_sht, blocked\_sht\_sav, intercept, clearence, errors, fouls, aerials\_won, aerials\_won\_pct, cards\_yellow, cards\_red)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, tackles, tackles\_won, press, press\_reg, press\_reg\_pct, blocks, blocked\_sht, blocked\_sht\_sav, intercept, clearence, errors, fouls, aerials\_won, aerials\_won\_pct, cards\_yellow, cards\_red . \\
&\exists id, d5, d6, d7, d8, d11, d12, d13, d14, d15, d16, d17, d21, d22, d23, d27, d29 \\
&\exists m5, m6, m7, m8, m11, m13, m14, m15, m16, m17, m18, m19, m20, m21, m23 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Defense(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, d5, d6, d7, d8, tackles, tackles\_won, d11, d12, d13, d14, d15, d16, d17, press, press\_reg, press\_reg\_pct, d21, d22, d23, blocks, blocked_sht, blocked_sho_sav, d27, intercept, d29, clearance, errors) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, m5, m6, m7, m8, cards\_yellow, cards\_red, m11, fouls, m13, m14, m15, m16, m17, m18, m19, m20, m21, aerials\_won, m23, aerials\_won\_pct) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow DefenseStat(player\_name, tackles, tackles\_won, press, press\_reg, press\_reg\_pct, blocks, blocked\_sht, blocked\_sht\_sav, intercept, clearence, errors, fouls, aerials\_won, aerials\_won\_pct, cards\_yellow, cards\_red)
\end{split}
$$

# GoalkeeperStat

$$
\begin{split}
&\forall player\_name, goals\_against\_gk, goals\_against\_per90\_gk, shots\_on\_target\_against, saves, save\_pct, clean\_sheets, clean\_sheets\_pct, pens\_save\_pct . \\
&\exists id, k5, k6, k7, k8, k9, k10, k11, k17, k18, k19, k22, k23, k24, k25 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Keeper(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, k5, k6, k7, k8, k9, k10, k11, goals\_against\_gk, goals\_against\_per90\_gk, shots\_on\_target\_against, saves, save\_pct, k17, k18, k19, clean\_sheets, clean\_sheets\_pct, k22, k23, k24, k25, pens\_save\_pct) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow GoalkeeperStat(player\_name, goals\_against\_gk, goals\_against\_per90\_gk, shots\_on\_target\_against, saves, save\_pct, clean\_sheets, clean\_sheets\_pct, pens\_save\_pct)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, goals\_against\_gk, goals\_against\_per90\_gk, shots\_on\_target\_against, saves, save\_pct, clean\_sheets, clean\_sheets\_pct, pens\_save\_pct . \\
&\exists id, k5, k6, k7, k8, k9, k10, k11, k17, k18, k19, k22, k23, k24, k25 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Keeper(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, k5, k6, k7, k8, k9, k10, k11, goals\_against\_gk, goals\_against\_per90\_gk, shots\_on\_target\_against, saves, save\_pct, k17, k18, k19, clean\_sheets, clean\_sheets\_pct, k22, k23, k24, k25, pens\_save\_pct) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow GoalkeeperStat(player\_name, goals\_against\_gk, goals\_against\_per90\_gk, shots\_on\_target\_against, saves, save\_pct, clean\_sheets, clean\_sheets\_pct, pens\_save\_pct)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, goals\_against\_gk, goals\_against\_per90\_gk, shots\_on\_target\_against, saves, save\_pct, clean\_sheets, clean\_sheets\_pct, pens\_save\_pct . \\
&\exists id, k5, k6, k7, k8, k9, k10, k11, k17, k18, k19, k22, k23, k24, k25 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Keeper(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, k5, k6, k7, k8, k9, k10, k11, goals\_against\_gk, goals\_against\_per90\_gk, shots\_on\_target\_against, saves, save\_pct, k17, k18, k19, clean\_sheets, clean\_sheets\_pct, k22, k23, k24, k25, pens\_save\_pct) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow GoalkeeperStat(player\_name, goals\_against\_gk, goals\_against\_per90\_gk, shots\_on\_target\_against, saves, save\_pct, clean\_sheets, clean\_sheets\_pct, pens\_save\_pct)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, goals\_against\_gk, goals\_against\_per90\_gk, shots\_on\_target\_against, saves, save\_pct, clean\_sheets, clean\_sheets\_pct, pens\_save\_pct . \\
&\exists id, k5, k6, k7, k8, k9, k10, k11, k17, k18, k19, k22, k23, k24, k25 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Keeper(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, k5, k6, k7, k8, k9, k10, k11, goals\_against\_gk, goals\_against\_per90\_gk, shots\_on\_target\_against, saves, save\_pct, k17, k18, k19, clean\_sheets, clean\_sheets\_pct, k22, k23, k24, k25, pens\_save\_pct) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow GoalkeeperStat(player\_name, goals\_against\_gk, goals\_against\_per90\_gk, shots\_on\_target\_against, saves, save\_pct, clean\_sheets, clean\_sheets\_pct, pens\_save\_pct)
\end{split}
$$

# GoalStat

$$
\begin{split}
&\forall player\_name, goals, shots\_total, shots\_on\_target, shots\_on\_target\_pct, shots\_total\_per90, shots\_on\_target\_per90, goals\_per\_shot, average\_shot\_distance, shots\_free\_kicks, pens\_made, pens\_att, goals\_pens, goals\_per90, goals\_assists\_per90, goals\_pens\_per90, offsides . \\
&\exists id, sh5, sh6, sh7, sh8, sh16, sh21, sh22, sh23, sh24, sh25 \\
&\exists st2, st3, st5, st6, st7, st8, st9, st10, st11, st12, st13, st15, st16, st17, st18, st20, st23, st24, st25, st26, st27, st28, st29, st30, st31, st32 \\
&\exists m5, m6, m7, m8, m9, m10, m11, m12, m13, m15, m16, m17, m18, m19, m20, m21, m22, m23, m24 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Shooting(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, sh5, sh6, sh7, sh8, goals, shots\_total, shots\_on\_target, shots\_on\_target\_pct, shots\_total\_per90, shots\_on\_target\_per90, goals\_per\_shot, sh16, average\_shot\_distance, shots\_free\_kicks, pens\_made, pens\_att, sh21, sh22, sh23, sh24, sh25) \\
&\wedge Standard(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, st5, st6, st7, st8, st9, st10, st11, st12, st13, goals\_pens, st15, st16, st17, st18, goals\_per90, st20, goals\_assists\_per90, goals\_pens\_per90, st23, st24, st25, st26, st27, st28, st29, st30, st31, st32) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, m5, m6, m7, m8, m9, m10, m11, m12, m13, offsides, m15, m16, m17, m18, m19, m20, m21, m22, m23, m24) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow GoalStat(player\_name, goals, shots\_total, shots\_on\_target, shots\_on\_target\_pct, shots\_total\_per90, shots\_on\_target\_per90, goals\_per\_shot, average\_shot\_distance, shots\_free\_kicks, pens\_made, pens\_att, goals\_pens, goals\_per90, goals\_assists\_per90, goals\_pens\_per90, offsides)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, goals, shots\_total, shots\_on\_target, shots\_on\_target\_pct, shots\_total\_per90, shots\_on\_target\_per90, goals\_per\_shot, average\_shot\_distance, shots\_free\_kicks, pens\_made, pens\_att, goals\_pens, goals\_per90, goals\_assists\_per90, goals\_pens\_per90, offsides . \\
&\exists id, sh5, sh6, sh7, sh8, sh16, sh21, sh22, sh23, sh24, sh25 \\
&\exists st2, st3, st5, st6, st7, st8, st9, st10, st11, st12, st13, st15, st16, st17, st18, st20, st23, st24, st25, st26, st27, st28, st29, st30, st31, st32 \\
&\exists m5, m6, m7, m8, m9, m10, m11, m12, m13, m15, m16, m17, m18, m19, m20, m21, m22, m23, m24 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Shooting(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, sh5, sh6, sh7, sh8, goals, shots\_total, shots\_on\_target, shots\_on\_target\_pct, shots\_total\_per90, shots\_on\_target\_per90, goals\_per\_shot, sh16, average\_shot\_distance, shots\_free\_kicks, pens\_made, pens\_att, sh21, sh22, sh23, sh24, sh25) \\
&\wedge Standard(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, st5, st6, st7, st8, st9, st10, st11, st12, st13, goals\_pens, st15, st16, st17, st18, goals\_per90, st20, goals\_assists\_per90, goals\_pens\_per90, st23, st24, st25, st26, st27, st28, st29, st30, st31, st32) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, m5, m6, m7, m8, m9, m10, m11, m12, m13, offsides, m15, m16, m17, m18, m19, m20, m21, m22, m23, m24) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow GoalStat(player\_name, goals, shots\_total, shots\_on\_target, shots\_on\_target\_pct, shots\_total\_per90, shots\_on\_target\_per90, goals\_per\_shot, average\_shot\_distance, shots\_free\_kicks, pens\_made, pens\_att, goals\_pens, goals\_per90, goals\_assists\_per90, goals\_pens\_per90, offsides)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, goals, shots\_total, shots\_on\_target, shots\_on\_target\_pct, shots\_total\_per90, shots\_on\_target\_per90, goals\_per\_shot, average\_shot\_distance, shots\_free\_kicks, pens\_made, pens\_att, goals\_pens, goals\_per90, goals\_assists\_per90, goals\_pens\_per90, offsides . \\
&\exists id, sh5, sh6, sh7, sh8, sh16, sh21, sh22, sh23, sh24, sh25 \\
&\exists st2, st3, st5, st6, st7, st8, st9, st10, st11, st12, st13, st15, st16, st17, st18, st20, st23, st24, st25, st26, st27, st28, st29, st30, st31, st32 \\
&\exists m5, m6, m7, m8, m9, m10, m11, m12, m13, m15, m16, m17, m18, m19, m20, m21, m22, m23, m24 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Shooting(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, sh5, sh6, sh7, sh8, goals, shots\_total, shots\_on\_target, shots\_on\_target\_pct, shots\_total\_per90, shots\_on\_target\_per90, goals\_per\_shot, sh16, average\_shot\_distance, shots\_free\_kicks, pens\_made, pens\_att, sh21, sh22, sh23, sh24, sh25) \\
&\wedge Standard(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, st5, st6, st7, st8, st9, st10, st11, st12, st13, goals\_pens, st15, st16, st17, st18, goals\_per90, st20, goals\_assists\_per90, goals\_pens\_per90, st23, st24, st25, st26, st27, st28, st29, st30, st31, st32) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, m5, m6, m7, m8, m9, m10, m11, m12, m13, offsides, m15, m16, m17, m18, m19, m20, m21, m22, m23, m24) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow GoalStat(player\_name, goals, shots\_total, shots\_on\_target, shots\_on\_target\_pct, shots\_total\_per90, shots\_on\_target\_per90, goals\_per\_shot, average\_shot\_distance, shots\_free\_kicks, pens\_made, pens\_att, goals\_pens, goals\_per90, goals\_assists\_per90, goals\_pens\_per90, offsides)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, goals, shots\_total, shots\_on\_target, shots\_on\_target\_pct, shots\_total\_per90, shots\_on\_target\_per90, goals\_per\_shot, average\_shot\_distance, shots\_free\_kicks, pens\_made, pens\_att, goals\_pens, goals\_per90, goals\_assists\_per90, goals\_pens\_per90, offsides . \\
&\exists id, sh5, sh6, sh7, sh8, sh16, sh21, sh22, sh23, sh24, sh25 \\
&\exists st2, st3, st5, st6, st7, st8, st9, st10, st11, st12, st13, st15, st16, st17, st18, st20, st23, st24, st25, st26, st27, st28, st29, st30, st31, st32 \\
&\exists m5, m6, m7, m8, m9, m10, m11, m12, m13, m15, m16, m17, m18, m19, m20, m21, m22, m23, m24 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Shooting(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, sh5, sh6, sh7, sh8, goals, shots\_total, shots\_on\_target, shots\_on\_target\_pct, shots\_total\_per90, shots\_on\_target\_per90, goals\_per\_shot, sh16, average\_shot\_distance, shots\_free\_kicks, pens\_made, pens\_att, sh21, sh22, sh23, sh24, sh25) \\
&\wedge Standard(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, st5, st6, st7, st8, st9, st10, st11, st12, st13, goals\_pens, st15, st16, st17, st18, goals\_per90, st20, goals\_assists\_per90, goals\_pens\_per90, st23, st24, st25, st26, st27, st28, st29, st30, st31, st32) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, m5, m6, m7, m8, m9, m10, m11, m12, m13, offsides, m15, m16, m17, m18, m19, m20, m21, m22, m23, m24) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow GoalStat(player\_name, goals, shots\_total, shots\_on\_target, shots\_on\_target\_pct, shots\_total\_per90, shots\_on\_target\_per90, goals\_per\_shot, average\_shot\_distance, shots\_free\_kicks, pens\_made, pens\_att, goals\_pens, goals\_per90, goals\_assists\_per90, goals\_pens\_per90, offsides)
\end{split}
$$

# PassingStat

$$
\begin{split}
&\forall player\_name, passes\_completed, passes, passes\_pct, passes\_completed\_short, passes\_short, passes\_pct\_short, passes\_completed\_medium, passes\_medium, passes\_pct\_medium, passes\_completed\_long, passes\_long, passes\_pct\_long, passes\_into\_final\_third, passes\_into\_penalty\_area, crosses\_into\_penalty\_area, crosses . \\
&\exists id, p5, p6, p7, p8, p12, p13, p23, p24, p25, p26, p30 \\
&\exists m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m16, m17, m18, m19, m20, m21, m22, m23, m24 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Passing(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, p5, p6, p7, p8, passes\_completed, passes, passes\_pct, p12, p13, passes\_completed\_short, passes\_short, passes\_pct\_short, passes\_completed\_medium, passes\_medium, passes\_pct\_medium, passes\_completed\_long, passes\_long, passes\_pct\_long, p23, p24, p25, p26, passes\_into\_final\_third, passes\_into\_penalty\_area, crosses\_into\_penalty\_area, p30) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, crosses, m16, m17, m18, m19, m20, m21, m22, m23, m24) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow PassingStat(player\_name, passes\_completed, passes, passes\_pct, passes\_completed\_short, passes\_short, passes\_pct\_short, passes\_completed\_medium, passes\_medium, passes\_pct\_medium, passes\_completed\_long, passes\_long, passes\_pct\_long, passes\_into\_final\_third, passes\_into\_penalty\_area, crosses\_into\_penalty\_area, crosses)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, passes\_completed, passes, passes\_pct, passes\_completed\_short, passes\_short, passes\_pct\_short, passes\_completed\_medium, passes\_medium, passes\_pct\_medium, passes\_completed\_long, passes\_long, passes\_pct\_long, passes\_into\_final\_third, passes\_into\_penalty\_area, crosses\_into\_penalty\_area, crosses . \\
&\exists id, p5, p6, p7, p8, p12, p13, p23, p24, p25, p26, p30 \\
&\exists m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m16, m17, m18, m19, m20, m21, m22, m23, m24 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Passing(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, p5, p6, p7, p8, passes\_completed, passes, passes\_pct, p12, p13, passes\_completed\_short, passes\_short, passes\_pct\_short, passes\_completed\_medium, passes\_medium, passes\_pct\_medium, passes\_completed\_long, passes\_long, passes\_pct\_long, p23, p24, p25, p26, passes\_into\_final\_third, passes\_into\_penalty\_area, crosses\_into\_penalty\_area, p30) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, crosses, m16, m17, m18, m19, m20, m21, m22, m23, m24) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow PassingStat(player\_name, passes\_completed, passes, passes\_pct, passes\_completed\_short, passes\_short, passes\_pct\_short, passes\_completed\_medium, passes\_medium, passes\_pct\_medium, passes\_completed\_long, passes\_long, passes\_pct\_long, passes\_into\_final\_third, passes\_into\_penalty\_area, crosses\_into\_penalty\_area, crosses)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, passes\_completed, passes, passes\_pct, passes\_completed\_short, passes\_short, passes\_pct\_short, passes\_completed\_medium, passes\_medium, passes\_pct\_medium, passes\_completed\_long, passes\_long, passes\_pct\_long, passes\_into\_final\_third, passes\_into\_penalty\_area, crosses\_into\_penalty\_area, crosses . \\
&\exists id, p5, p6, p7, p8, p12, p13, p23, p24, p25, p26, p30 \\
&\exists m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m16, m17, m18, m19, m20, m21, m22, m23, m24 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Passing(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, p5, p6, p7, p8, passes\_completed, passes, passes\_pct, p12, p13, passes\_completed\_short, passes\_short, passes\_pct\_short, passes\_completed\_medium, passes\_medium, passes\_pct\_medium, passes\_completed\_long, passes\_long, passes\_pct\_long, p23, p24, p25, p26, passes\_into\_final\_third, passes\_into\_penalty\_area, crosses\_into\_penalty\_area, p30) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, crosses, m16, m17, m18, m19, m20, m21, m22, m23, m24) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow PassingStat(player\_name, passes\_completed, passes, passes\_pct, passes\_completed\_short, passes\_short, passes\_pct\_short, passes\_completed\_medium, passes\_medium, passes\_pct\_medium, passes\_completed\_long, passes\_long, passes\_pct\_long, passes\_into\_final\_third, passes\_into\_penalty\_area, crosses\_into\_penalty\_area, crosses)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, passes\_completed, passes, passes\_pct, passes\_completed\_short, passes\_short, passes\_pct\_short, passes\_completed\_medium, passes\_medium, passes\_pct\_medium, passes\_completed\_long, passes\_long, passes\_pct\_long, passes\_into\_final\_third, passes\_into\_penalty\_area, crosses\_into\_penalty\_area, crosses . \\
&\exists id, p5, p6, p7, p8, p12, p13, p23, p24, p25, p26, p30 \\
&\exists m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m16, m17, m18, m19, m20, m21, m22, m23, m24 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&Passing(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, p5, p6, p7, p8, passes\_completed, passes, passes\_pct, p12, p13, passes\_completed\_short, passes\_short, passes\_pct\_short, passes\_completed\_medium, passes\_medium, passes\_pct\_medium, passes\_completed\_long, passes\_long, passes\_pct\_long, p23, p24, p25, p26, passes\_into\_final\_third, passes\_into\_penalty\_area, crosses\_into\_penalty\_area, p30) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, crosses, m16, m17, m18, m19, m20, m21, m22, m23, m24) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow PassingStat(player\_name, passes\_completed, passes, passes\_pct, passes\_completed\_short, passes\_short, passes\_pct\_short, passes\_completed\_medium, passes\_medium, passes\_pct\_medium, passes\_completed\_long, passes\_long, passes\_pct\_long, passes\_into\_final\_third, passes\_into\_penalty\_area, crosses\_into\_penalty\_area, crosses)
\end{split}
$$

# PlaymakingStat

$$
\begin{split}
&\forall player\_name, sca, sca\_per90, gca, gca\_per90, assists, touches, touches\_def\_3rd, touches\_mid\_3rd, touches\_att\_3rd, touches\_att\_pen\_area, dribbles\_completed, dribbles, dribbles\_completed\_pct, miscontrols, dispossessed, pass\_targets, assists\_per90, fouled . \\
&\exists id, g5, g6, g7, g8, g11, g12, g13, g14, g15, g16, g19, g20, g21, g2, g23, g24 \\
&\exists pa5, pa6, pa7, pa8, pa9, pa10, pa11, pa12, pa13, pa14, pa15, pa16, pa17, pa18, pa19, pa20, pa21, pa22, pa24, pa25, pa26, pa27, pa28, pa29, pa30 \\
&\exists po5, po6, po7, po8, po10, po15, po19, po20, po21, po22, po23, po24, po25, po26, po30, po31, po32 \\
&\exists s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32 \\
&\exists m5, m6, m7, m8, m9, m10, m11, m12, m14, m15, m16, m17, m18, m19, m20, m21, m22, m23, m24 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&GCA(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, g5. g6, g7, g8, sca, sca\_per90, g11, g12, g13, g14, g15, g16, gca, gca\_per90, g19, g20, g21, g2, g23, g24) \\
&\wedge Passing(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, pa5, pa6, pa7, pa8, pa9, pa10, pa11, pa12, pa13, pa14, pa15, pa16, pa17, pa18, pa19, pa20, pa21, pa22, assists, pa24, pa25, pa26, pa27, pa28, pa29, pa30) \\
&\wedge Possession(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, po5, po6, po7, po8, touches, po10, touches\_def\_3rd, touches\_mid\_3rd, touches\_att\_3rd, touches\_att\_pen\_area, po15, dribbles\_completed, dribbles, dribbles\_completed\_pct, po19, po20, po21, po22, po23, po24, po25, po26, miscontrols, dispossessed, pass\_targets, po30, po31, po32) \\
&\wedge Standard(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, assists\_per90, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, m5, m6, m7, m8, m9, m10, m11, m12, fouled, m14, crosses, m16, m17, m18, m19, m20, m21, m22, m23, m24) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow PlaymakingStat(player\_name, sca, sca\_per90, gca, gca\_per90, assists, touches, touches\_def\_3rd, touches\_mid\_3rd, touches\_att\_3rd, touches\_att\_pen\_area, dribbles\_completed, dribbles, dribbles\_completed\_pct, miscontrols, dispossessed, pass\_targets, assists\_per90, fouled)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, sca, sca\_per90, gca, gca\_per90, assists, touches, touches\_def\_3rd, touches\_mid\_3rd, touches\_att\_3rd, touches\_att\_pen\_area, dribbles\_completed, dribbles, dribbles\_completed\_pct, miscontrols, dispossessed, pass\_targets, assists\_per90, fouled . \\
&\exists id, g5, g6, g7, g8, g11, g12, g13, g14, g15, g16, g19, g20, g21, g2, g23, g24 \\
&\exists pa5, pa6, pa7, pa8, pa9, pa10, pa11, pa12, pa13, pa14, pa15, pa16, pa17, pa18, pa19, pa20, pa21, pa22, pa24, pa25, pa26, pa27, pa28, pa29, pa30 \\
&\exists po5, po6, po7, po8, po10, po15, po19, po20, po21, po22, po23, po24, po25, po26, po30, po31, po32 \\
&\exists s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32 \\
&\exists m5, m6, m7, m8, m9, m10, m11, m12, m14, m15, m16, m17, m18, m19, m20, m21, m22, m23, m24 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&GCA(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, g5. g6, g7, g8, sca, sca\_per90, g11, g12, g13, g14, g15, g16, gca, gca\_per90, g19, g20, g21, g2, g23, g24) \\
&\wedge Passing(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, pa5, pa6, pa7, pa8, pa9, pa10, pa11, pa12, pa13, pa14, pa15, pa16, pa17, pa18, pa19, pa20, pa21, pa22, assists, pa24, pa25, pa26, pa27, pa28, pa29, pa30) \\
&\wedge Possession(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, po5, po6, po7, po8, touches, po10, touches\_def\_3rd, touches\_mid\_3rd, touches\_att\_3rd, touches\_att\_pen\_area, po15, dribbles\_completed, dribbles, dribbles\_completed\_pct, po19, po20, po21, po22, po23, po24, po25, po26, miscontrols, dispossessed, pass\_targets, po30, po31, po32) \\
&\wedge Standard(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, assists\_per90, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, m5, m6, m7, m8, m9, m10, m11, m12, fouled, m14, crosses, m16, m17, m18, m19, m20, m21, m22, m23, m24) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow PlaymakingStat(player\_name, sca, sca\_per90, gca, gca\_per90, assists, touches, touches\_def\_3rd, touches\_mid\_3rd, touches\_att\_3rd, touches\_att\_pen\_area, dribbles\_completed, dribbles, dribbles\_completed\_pct, miscontrols, dispossessed, pass\_targets, assists\_per90, fouled)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, sca, sca\_per90, gca, gca\_per90, assists, touches, touches\_def\_3rd, touches\_mid\_3rd, touches\_att\_3rd, touches\_att\_pen\_area, dribbles\_completed, dribbles, dribbles\_completed\_pct, miscontrols, dispossessed, pass\_targets, assists\_per90, fouled . \\
&\exists id, g5, g6, g7, g8, g11, g12, g13, g14, g15, g16, g19, g20, g21, g2, g23, g24 \\
&\exists pa5, pa6, pa7, pa8, pa9, pa10, pa11, pa12, pa13, pa14, pa15, pa16, pa17, pa18, pa19, pa20, pa21, pa22, pa24, pa25, pa26, pa27, pa28, pa29, pa30 \\
&\exists po5, po6, po7, po8, po10, po15, po19, po20, po21, po22, po23, po24, po25, po26, po30, po31, po32 \\
&\exists s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32 \\
&\exists m5, m6, m7, m8, m9, m10, m11, m12, m14, m15, m16, m17, m18, m19, m20, m21, m22, m23, m24 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&GCA(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, g5. g6, g7, g8, sca, sca\_per90, g11, g12, g13, g14, g15, g16, gca, gca\_per90, g19, g20, g21, g2, g23, g24) \\
&\wedge Passing(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, pa5, pa6, pa7, pa8, pa9, pa10, pa11, pa12, pa13, pa14, pa15, pa16, pa17, pa18, pa19, pa20, pa21, pa22, assists, pa24, pa25, pa26, pa27, pa28, pa29, pa30) \\
&\wedge Possession(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, po5, po6, po7, po8, touches, po10, touches\_def\_3rd, touches\_mid\_3rd, touches\_att\_3rd, touches\_att\_pen\_area, po15, dribbles\_completed, dribbles, dribbles\_completed\_pct, po19, po20, po21, po22, po23, po24, po25, po26, miscontrols, dispossessed, pass\_targets, po30, po31, po32) \\
&\wedge Standard(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, assists\_per90, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, m5, m6, m7, m8, m9, m10, m11, m12, fouled, m14, crosses, m16, m17, m18, m19, m20, m21, m22, m23, m24) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow PlaymakingStat(player\_name, sca, sca\_per90, gca, gca\_per90, assists, touches, touches\_def\_3rd, touches\_mid\_3rd, touches\_att\_3rd, touches\_att\_pen\_area, dribbles\_completed, dribbles, dribbles\_completed\_pct, miscontrols, dispossessed, pass\_targets, assists\_per90, fouled)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, sca, sca\_per90, gca, gca\_per90, assists, touches, touches\_def\_3rd, touches\_mid\_3rd, touches\_att\_3rd, touches\_att\_pen\_area, dribbles\_completed, dribbles, dribbles\_completed\_pct, miscontrols, dispossessed, pass\_targets, assists\_per90, fouled . \\
&\exists id, g5, g6, g7, g8, g11, g12, g13, g14, g15, g16, g19, g20, g21, g2, g23, g24 \\
&\exists pa5, pa6, pa7, pa8, pa9, pa10, pa11, pa12, pa13, pa14, pa15, pa16, pa17, pa18, pa19, pa20, pa21, pa22, pa24, pa25, pa26, pa27, pa28, pa29, pa30 \\
&\exists po5, po6, po7, po8, po10, po15, po19, po20, po21, po22, po23, po24, po25, po26, po30, po31, po32 \\
&\exists s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32 \\
&\exists m5, m6, m7, m8, m9, m10, m11, m12, m14, m15, m16, m17, m18, m19, m20, m21, m22, m23, m24 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&GCA(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, g5. g6, g7, g8, sca, sca\_per90, g11, g12, g13, g14, g15, g16, gca, gca\_per90, g19, g20, g21, g2, g23, g24) \\
&\wedge Passing(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, pa5, pa6, pa7, pa8, pa9, pa10, pa11, pa12, pa13, pa14, pa15, pa16, pa17, pa18, pa19, pa20, pa21, pa22, assists, pa24, pa25, pa26, pa27, pa28, pa29, pa30) \\
&\wedge Possession(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, po5, po6, po7, po8, touches, po10, touches\_def\_3rd, touches\_mid\_3rd, touches\_att\_3rd, touches\_att\_pen\_area, po15, dribbles\_completed, dribbles, dribbles\_completed\_pct, po19, po20, po21, po22, po23, po24, po25, po26, miscontrols, dispossessed, pass\_targets, po30, po31, po32) \\
&\wedge Standard(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, assists\_per90, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32) \\
&\wedge Misc(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, m5, m6, m7, m8, m9, m10, m11, m12, fouled, m14, crosses, m16, m17, m18, m19, m20, m21, m22, m23, m24) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow PlaymakingStat(player\_name, sca, sca\_per90, gca, gca\_per90, assists, touches, touches\_def\_3rd, touches\_mid\_3rd, touches\_att\_3rd, touches\_att\_pen\_area, dribbles\_completed, dribbles, dribbles\_completed\_pct, miscontrols, dispossessed, pass\_targets, assists\_per90, fouled)
\end{split}
$$

# PresenceStat

$$
\begin{split}
&\forall player\_name, games, mnts, minutes\_per\_game, minutes\_pct, minutes\_90s, games\_starts, games\_complete, games\_subs, unused\_subs, points\_per\_match, on\_goals\_for, on\_goals\_against, plus\_minus, plus\_minus\_wowy . \\
&\exists id, p5, p6, p7, p17, p23, p25, p26, p27, p28, p29 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&PlayingTime(id, \textrm{``2019-2020''}, \textrm{``ITA''}, \textrm{``1. Serie A''}, p5, p6, p7, games, mnts, minutes\_per\_game, minutes\_pct, minutes\_90s, games\_starts, games\_complete, games\_subs, p17, unused\_subs, points\_per\_match, on\_goals\_for, on\_goals\_against, plus\_minus, p23, plus\_minus\_wowy, p25, p26, p27, p28, p29) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow PresenceStat(player\_name, games, mnts, minutes\_per\_game, minutes\_pct, minutes\_90s, games\_starts, games\_complete, games\_subs, unused\_subs, points\_per\_match, on\_goals\_for, on\_goals\_against, plus\_minus, plus\_minus\_wowy)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, games, mnts, minutes\_per\_game, minutes\_pct, minutes\_90s, games\_starts, games\_complete, games\_subs, unused\_subs, points\_per\_match, on\_goals\_for, on\_goals\_against, plus\_minus, plus\_minus\_wowy . \\
&\exists id, p5, p6, p7, p17, p23, p25, p26, p27, p28, p29 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&PlayingTime(id, \textrm{``2019-2020''}, \textrm{``GER''}, \textrm{``1. Bundesliga''}, p5, p6, p7, games, mnts, minutes\_per\_game, minutes\_pct, minutes\_90s, games\_starts, games\_complete, games\_subs, p17, unused\_subs, points\_per\_match, on\_goals\_for, on\_goals\_against, plus\_minus, p23, plus\_minus\_wowy, p25, p26, p27, p28, p29) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow PresenceStat(player\_name, games, mnts, minutes\_per\_game, minutes\_pct, minutes\_90s, games\_starts, games\_complete, games\_subs, unused\_subs, points\_per\_match, on\_goals\_for, on\_goals\_against, plus\_minus, plus\_minus\_wowy)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, games, mnts, minutes\_per\_game, minutes\_pct, minutes\_90s, games\_starts, games\_complete, games\_subs, unused\_subs, points\_per\_match, on\_goals\_for, on\_goals\_against, plus\_minus, plus\_minus\_wowy . \\
&\exists id, p5, p6, p7, p17, p23, p25, p26, p27, p28, p29 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&PlayingTime(id, \textrm{``2019-2020''}, \textrm{``ESP''}, \textrm{``1. La Liga''}, p5, p6, p7, games, mnts, minutes\_per\_game, minutes\_pct, minutes\_90s, games\_starts, games\_complete, games\_subs, p17, unused\_subs, points\_per\_match, on\_goals\_for, on\_goals\_against, plus\_minus, p23, plus\_minus\_wowy, p25, p26, p27, p28, p29) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow PresenceStat(player\_name, games, mnts, minutes\_per\_game, minutes\_pct, minutes\_90s, games\_starts, games\_complete, games\_subs, unused\_subs, points\_per\_match, on\_goals\_for, on\_goals\_against, plus\_minus, plus\_minus\_wowy)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, games, mnts, minutes\_per\_game, minutes\_pct, minutes\_90s, games\_starts, games\_complete, games\_subs, unused\_subs, points\_per\_match, on\_goals\_for, on\_goals\_against, plus\_minus, plus\_minus\_wowy . \\
&\exists id, p5, p6, p7, p17, p23, p25, p26, p27, p28, p29 \\
&\exists i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 . \\
&PlayingTime(id, \textrm{``2019-2020''}, \textrm{``ENG''}, \textrm{``1. Premier League''}, p5, p6, p7, games, mnts, minutes\_per\_game, minutes\_pct, minutes\_90s, games\_starts, games\_complete, games\_subs, p17, unused\_subs, points\_per\_match, on\_goals\_for, on\_goals\_against, plus\_minus, p23, plus\_minus\_wowy, p25, p26, p27, p28, p29) \\
&\wedge Info(id, i2, player\_name, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13) \\
&\rightarrow PresenceStat(player\_name, games, mnts, minutes\_per\_game, minutes\_pct, minutes\_90s, games\_starts, games\_complete, games\_subs, unused\_subs, points\_per\_match, on\_goals\_for, on\_goals\_against, plus\_minus, plus\_minus\_wowy)
\end{split}
$$

# GoalkeeperAbility

$$
\begin{split}
&\forall player\_name, tro, 1v1, han, cmd  . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25, f27, f28, f29, f30, f31, f32, f34, f35, f36, f37, f38, f39, f40, f41, f42, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f58, f59, f60, f61, f62, f63, f64 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``Italian Serie A''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25, tro, f27, f28, f29, f30, f31, f32, 1v1, f34, f35, f36, f37, f38, f39, f40, f41, f42, han, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, cmd, f58, f59, f60, f61, f62, f63, f64) \\
&\rightarrow GoalkeeperAbility(player\_name, tro, 1v1, han, cmd)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, tro, 1v1, han, cmd  . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25, f27, f28, f29, f30, f31, f32, f34, f35, f36, f37, f38, f39, f40, f41, f42, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f58, f59, f60, f61, f62, f63, f64 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``Bundesliga''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25, tro, f27, f28, f29, f30, f31, f32, 1v1, f34, f35, f36, f37, f38, f39, f40, f41, f42, han, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, cmd, f58, f59, f60, f61, f62, f63, f64) \\
&\rightarrow GoalkeeperAbility(player\_name, tro, 1v1, han, cmd)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, tro, 1v1, han, cmd  . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25, f27, f28, f29, f30, f31, f32, f34, f35, f36, f37, f38, f39, f40, f41, f42, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f58, f59, f60, f61, f62, f63, f64 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``Spanish First Division''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25, tro, f27, f28, f29, f30, f31, f32, 1v1, f34, f35, f36, f37, f38, f39, f40, f41, f42, han, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, cmd, f58, f59, f60, f61, f62, f63, f64) \\
&\rightarrow GoalkeeperAbility(player\_name, tro, 1v1, han, cmd)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, tro, 1v1, han, cmd  . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25, f27, f28, f29, f30, f31, f32, f34, f35, f36, f37, f38, f39, f40, f41, f42, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f58, f59, f60, f61, f62, f63, f64 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``English Premier Division''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25, tro, f27, f28, f29, f30, f31, f32, 1v1, f34, f35, f36, f37, f38, f39, f40, f41, f42, han, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, cmd, f58, f59, f60, f61, f62, f63, f64) \\
&\rightarrow GoalkeeperAbility(player\_name, tro, 1v1, han, cmd)
\end{split}
$$

# MentalAbility

$$
\begin{split}
&\forall player\_name, wor, vis, tea, ref, otb, ldr, fla, cnt, agg . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f20, f21, f23, f24, f25, f26, f28, f29, f30, f31, f32, f33, f35, f36, f37, f38, f40, f41, f42, f43, f44, f46, f47, f48, f49, f50, f51, f52, f53, f55, f56, f57, f58, f59, f60, f61, f63, f64 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``Italian Serie A''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, wor, vis, f20, f21, tea, f23, f24, f25, f26, ref, f28, f29, f30, f31, f32, f33, otb, f35, f36, f37, f38, ldr, f40, f41, f42, f43, f44, fla, f46, f47, f48, f49, f50, f51, f52, f53, cnt, f55, f56, f57, f58, f59, f60, f61, agg, f63, f64) \\
&\rightarrow MentalAbility(player\_name, wor, vis, tea, ref, otb, ldr, fla, cnt, agg)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, wor, vis, tea, ref, otb, ldr, fla, cnt, agg . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f20, f21, f23, f24, f25, f26, f28, f29, f30, f31, f32, f33, f35, f36, f37, f38, f40, f41, f42, f43, f44, f46, f47, f48, f49, f50, f51, f52, f53, f55, f56, f57, f58, f59, f60, f61, f63, f64 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``Bundesliga''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, wor, vis, f20, f21, tea, f23, f24, f25, f26, ref, f28, f29, f30, f31, f32, f33, otb, f35, f36, f37, f38, ldr, f40, f41, f42, f43, f44, fla, f46, f47, f48, f49, f50, f51, f52, f53, cnt, f55, f56, f57, f58, f59, f60, f61, agg, f63, f64) \\
&\rightarrow MentalAbility(player\_name, wor, vis, tea, ref, otb, ldr, fla, cnt, agg)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, wor, vis, tea, ref, otb, ldr, fla, cnt, agg . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f20, f21, f23, f24, f25, f26, f28, f29, f30, f31, f32, f33, f35, f36, f37, f38, f40, f41, f42, f43, f44, f46, f47, f48, f49, f50, f51, f52, f53, f55, f56, f57, f58, f59, f60, f61, f63, f64 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``Spanish First Division''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, wor, vis, f20, f21, tea, f23, f24, f25, f26, ref, f28, f29, f30, f31, f32, f33, otb, f35, f36, f37, f38, ldr, f40, f41, f42, f43, f44, fla, f46, f47, f48, f49, f50, f51, f52, f53, cnt, f55, f56, f57, f58, f59, f60, f61, agg, f63, f64) \\
&\rightarrow MentalAbility(player\_name, wor, vis, tea, ref, otb, ldr, fla, cnt, agg)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, wor, vis, tea, ref, otb, ldr, fla, cnt, agg . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f20, f21, f23, f24, f25, f26, f28, f29, f30, f31, f32, f33, f35, f36, f37, f38, f40, f41, f42, f43, f44, f46, f47, f48, f49, f50, f51, f52, f53, f55, f56, f57, f58, f59, f60, f61, f63, f64 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``English Premier Division''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, wor, vis, f20, f21, tea, f23, f24, f25, f26, ref, f28, f29, f30, f31, f32, f33, otb, f35, f36, f37, f38, ldr, f40, f41, f42, f43, f44, fla, f46, f47, f48, f49, f50, f51, f52, f53, cnt, f55, f56, f57, f58, f59, f60, f61, agg, f63, f64) \\
&\rightarrow MentalAbility(player\_name, wor, vis, tea, ref, otb, ldr, fla, cnt, agg)
\end{split}
$$

# PhysicalAbility

$$
\begin{split}
&\forall player\_name, str, sta, pac, jum, agi, aer, acc . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f26, f27, f28, f29, f30, f31, f33, f34, f35, f36, f37, f38, f39, f40, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, f62 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``Italian Serie A''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, str, sta, f26, f27, f28, f29, f30, f31, pac, f33, f34, f35, f36, f37, f38, f39, f40, jum, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, agi, f62, aer, acc) \\
&\rightarrow PhysicalAbility(player\_name, str, sta, pac, jum, agi, aer, acc)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, str, sta, pac, jum, agi, aer, acc . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f26, f27, f28, f29, f30, f31, f33, f34, f35, f36, f37, f38, f39, f40, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, f62 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``Bundesliga''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, str, sta, f26, f27, f28, f29, f30, f31, pac, f33, f34, f35, f36, f37, f38, f39, f40, jum, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, agi, f62, aer, acc) \\
&\rightarrow PhysicalAbility(player\_name, str, sta, pac, jum, agi, aer, acc)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, str, sta, pac, jum, agi, aer, acc . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f26, f27, f28, f29, f30, f31, f33, f34, f35, f36, f37, f38, f39, f40, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, f62 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``Spanish First Division''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, str, sta, f26, f27, f28, f29, f30, f31, pac, f33, f34, f35, f36, f37, f38, f39, f40, jum, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, agi, f62, aer, acc) \\
&\rightarrow PhysicalAbility(player\_name, str, sta, pac, jum, agi, aer, acc)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, str, sta, pac, jum, agi, aer, acc . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f26, f27, f28, f29, f30, f31, f33, f34, f35, f36, f37, f38, f39, f40, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, f62 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``English Premier Division''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, str, sta, f26, f27, f28, f29, f30, f31, pac, f33, f34, f35, f36, f37, f38, f39, f40, jum, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, agi, f62, aer, acc) \\
&\rightarrow PhysicalAbility(player\_name, str, sta, pac, jum, agi, aer, acc)
\end{split}
$$

# TechnicalAbility

$$
\begin{split}
&\forall player\_name, tec, tck, pen, pas, mar, lth, lon, hea, fir, fin, dri, cro, cor . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f22, f24, f25, f26, f27, f28, f29, f32, f33, f34, f35, f39, f40, f41, f43, f44, f45, f48, f50, f51, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``Italian Serie A''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, tec, f22, tck, f24, f25, f26, f27, f28, f29, pen, pas, f32, f33, f34, f35, mar, lth, lon, f39, f40, f41, hea, f43, f44, f45, fir, fin, f48, dri, f50, f51, cro, cor, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64) \\
&\rightarrow TechnicalAbility(player\_name, tec, tck, pen, pas, mar, lth, lon, hea, fir, fin, dri, cro, cor)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, tec, tck, pen, pas, mar, lth, lon, hea, fir, fin, dri, cro, cor . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f22, f24, f25, f26, f27, f28, f29, f32, f33, f34, f35, f39, f40, f41, f43, f44, f45, f48, f50, f51, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``Bundesliga''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, tec, f22, tck, f24, f25, f26, f27, f28, f29, pen, pas, f32, f33, f34, f35, mar, lth, lon, f39, f40, f41, hea, f43, f44, f45, fir, fin, f48, dri, f50, f51, cro, cor, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64) \\
&\rightarrow TechnicalAbility(player\_name, tec, tck, pen, pas, mar, lth, lon, hea, fir, fin, dri, cro, cor)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, tec, tck, pen, pas, mar, lth, lon, hea, fir, fin, dri, cro, cor . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f22, f24, f25, f26, f27, f28, f29, f32, f33, f34, f35, f39, f40, f41, f43, f44, f45, f48, f50, f51, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``Spanish First Division''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, tec, f22, tck, f24, f25, f26, f27, f28, f29, pen, pas, f32, f33, f34, f35, mar, lth, lon, f39, f40, f41, hea, f43, f44, f45, fir, fin, f48, dri, f50, f51, cro, cor, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64) \\
&\rightarrow TechnicalAbility(player\_name, tec, tck, pen, pas, mar, lth, lon, hea, fir, fin, dri, cro, cor)
\end{split}
$$

$$
\begin{split}
&\forall player\_name, tec, tck, pen, pas, mar, lth, lon, hea, fir, fin, dri, cro, cor . \\
&\exists f1, f2, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f22, f24, f25, f26, f27, f28, f29, f32, f33, f34, f35, f39, f40, f41, f43, f44, f45, f48, f50, f51, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64 . \\
&FM20(f1, player\_name, f3, f4, \textrm{``English Premier Division''}, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, tec, f22, tck, f24, f25, f26, f27, f28, f29, pen, pas, f32, f33, f34, f35, mar, lth, lon, f39, f40, f41, hea, f43, f44, f45, fir, fin, f48, dri, f50, f51, cro, cor, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64) \\
&\rightarrow TechnicalAbility(player\_name, tec, tck, pen, pas, mar, lth, lon, hea, fir, fin, dri, cro, cor)
\end{split}
$$