USE codding_school;

SELECT * FROM `Category` where `active` = true ORDER BY `order`;

SELECT * FROM `Subcategory` where `active` = true ORDER BY `order`;

SELECT * FROM `Course` where `visible` = true;

SELECT `name` FROM `Subcategory` where `description` = '';