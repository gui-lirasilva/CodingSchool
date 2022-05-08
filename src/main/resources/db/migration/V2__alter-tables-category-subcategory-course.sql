ALTER TABLE `Category` ADD CONSTRAINT unique_name_and_code UNIQUE (`name`, `code`);
ALTER TABLE `Subcategory` ADD CONSTRAINT unique_name_and_code UNIQUE (`name`, `code`);
ALTER TABLE `Course` ADD CONSTRAINT unique_name_and_code UNIQUE (`name`, `code`);