-- 코드를 작성해주세요
select year(a.ym) as year, round(avg(a.pm_val1), 2) as pm10, round(avg(a.pm_val2), 2) as 'pm2.5'
from (select * 
from air_pollution
where location2 = '수원') as a
group by year(a.ym)
order by year(a.ym)


