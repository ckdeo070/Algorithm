-- 코드를 작성해주세요
select count(*) as COUNT
from ecoli_data
where (genotype & 5) and !(genotype & 2);