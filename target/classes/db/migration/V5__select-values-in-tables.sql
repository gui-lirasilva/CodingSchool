USE codding_school;

SELECT * FROM `categories` where `active` = true ORDER BY `order`;

SELECT * FROM `subcategories` where `active` = true ORDER BY `order`;

SELECT * FROM `courses` where `visible` = true;

SELECT `name` FROM `subcategories` where `description` = '';