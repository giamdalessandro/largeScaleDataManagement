select 
    named_struct("personalData.name", info.name) as personalData
    -- info.position as footballData.position,
    -- info.foot as footballData.foot,
    -- cast(info.height as double) as personalData.height,
    -- cast(info.weight as double) as personalData.weight,
    -- cast(fm.Age as integer) as personalData.age,
    -- info.dob as personalData.dob,
    -- info.cityob as personalData.cityOb,
    -- info.countryob as personalData.countryOb,
    -- cast(fm.Value as double) as fictionalData.economic.value,
    -- cast(fm.Wage as double) as fictionalData.economic.wage,
    -- cast(fm.CA as double) as fictionalData.ability.ca,
    -- cast(fm.PA as double) as fictionalData.ability.pa
from Fm20 fm, FbrefInfo info
where (fm.Name = info.name)






