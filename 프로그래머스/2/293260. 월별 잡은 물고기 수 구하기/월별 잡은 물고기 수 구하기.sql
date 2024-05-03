-- 코드를 작성해주세요
select count(Month(time)) as fish_count, Month(time) as month
from fish_info
group by month
order by month