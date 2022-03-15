SELECT distinct s.name, s.order
FROM subcategories s
INNER JOIN courses c
ON c.subcategory_id = s.id
WHERE `active`
ORDER BY `order`;

SELECT c.instructor'Instructor name',
COUNT(*)'Courses number'
FROM courses c
GROUP BY c.instructor
ORDER BY COUNT(*) DESC LIMIT 1;

select ca.`name`'Category name', count(co.`id`)'Courses number', coalesce(sum(co.estimated_time), 0)'Hours'
from categories ca
left join subcategories su on ca.`id` = su.category_id
left join courses co on su.`id` = co.subcategory_id
where ca.`active`
group by ca.`name`;