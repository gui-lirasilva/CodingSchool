SELECT distinct s.name, s.order
FROM subcategories s
INNER JOIN courses c
ON c.subcategory_id = s.id
WHERE `active`
ORDER BY `order`;

SELECT c.instructor as 'Instructor name',
COUNT(*) as 'Courses number'
FROM courses c
GROUP BY c.instructor
ORDER BY COUNT(*) DESC LIMIT 1;

select ca.`name` as 'Category name', count(co.`id`) as 'Courses number', coalesce(sum(co.estimated_time), 0) as 'Hours'
from categories ca
left join subcategories su on ca.`id` = su.category_id
left join courses co on su.`id` = co.subcategory_id
where ca.`active`
group by ca.`name`;