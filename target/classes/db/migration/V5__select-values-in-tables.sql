USE codding_school;

SELECT * FROM `category` where `active` = true ORDER BY `order`;

SELECT * FROM `subcategory` where `active` = true ORDER BY `order`;

SELECT * FROM `course` where `visible` = true;

SELECT `name` FROM `subcategory` where `description` = '';