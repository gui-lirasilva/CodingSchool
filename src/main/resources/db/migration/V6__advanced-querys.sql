SELECT distinct s.name, s.order
FROM Subcategory s
INNER JOIN Course c
ON c.subcategory_id = s.id
WHERE `active`
ORDER BY `order`;

SELECT c.instructor as 'Instructor name',
COUNT(*) as 'Courses number'
FROM Course c
GROUP BY c.instructor
ORDER BY COUNT(*) DESC LIMIT 1;

select ca.`name` as 'Category name', count(co.`id`) as 'Courses number', coalesce(sum(co.estimated_time), 0) as 'Hours'
from Category ca
left join Subcategory su on ca.`id` = su.category_id
left join Course co on su.`id` = co.subcategory_id
where ca.`active`
group by ca.`name`;