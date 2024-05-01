-- 코드를 작성해주세요
select year(a.DIFFERENTIATION_DATE) as 'YEAR',
    b.ms - a.size_of_colony as 'YEAR_DEV',
    a.ID as 'ID'
from ecoli_data as a
join (select 
    year(DIFFERENTIATION_DATE) as "y",
    max(size_of_colony) as "ms"
from ecoli_data
group by year(DIFFERENTIATION_DATE)) as b
on b.y = year(a.DIFFERENTIATION_DATE)
order by year(a.DIFFERENTIATION_DATE) asc, b.ms - a.size_of_colony asc




