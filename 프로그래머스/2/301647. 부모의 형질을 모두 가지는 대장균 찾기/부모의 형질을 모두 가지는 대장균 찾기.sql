-- 코드를 작성해주세요
select c.id as 'ID', c.genotype as 'GENOTYPE', p.genotype as 'PARENT_GENOTYPE'
from ecoli_data as c
join ecoli_data as p on p.id = c.parent_id
where (c.genotype & p.genotype) = p.genotype
order by c.id asc