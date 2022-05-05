CREATE TABLE `Category` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `code` varchar(255) NOT NULL,
    `order_in_system` int DEFAULT NULL,
    `description` text,
    `active` tinyint(1) DEFAULT NULL,
    `icon_path` varchar(255) DEFAULT NULL,
    `color_code` varchar(255) DEFAULT NULL,
    `study_guide` text,
    PRIMARY KEY (`id`)
);

CREATE TABLE `Profile` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `name` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
);

CREATE TABLE `User` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `Subcategory` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `name` varchar(255) NOT NULL,
   `code` varchar(255) NOT NULL,
   `order_in_system` int DEFAULT NULL,
   `description` text,
   `active` boolean DEFAULT NULL,
   `category_id` bigint NOT NULL,
   `study_guide` text,
   PRIMARY KEY (`id`),
   FOREIGN KEY (`category_id`) REFERENCES `Category` (`id`)
);

CREATE TABLE `user_profile` (
    `user_id` bigint NOT NULL,
    `profile_id` bigint NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`id`),
    FOREIGN KEY (`profile_id`) REFERENCES `Profile` (`id`)
);

CREATE TABLE `Course` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `code` varchar(255) NOT NULL,
    `estimated_time` int DEFAULT NULL,
    `visible` tinyint(1) DEFAULT NULL,
    `target` text,
    `instructor` varchar(255) DEFAULT NULL,
    `description` text,
    `developed_skills` text,
    `subcategory_id` bigint NOT NULL,
    `study_guide` text,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`subcategory_id`) REFERENCES `Subcategory` (`id`)
);

CREATE TABLE `Section` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `code` varchar(255) NOT NULL,
    `order_in_system` int DEFAULT NULL,
    `active` tinyint(1) DEFAULT NULL,
    `test` tinyint(1) DEFAULT NULL,
    `course_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`course_id`) REFERENCES `Course` (`id`)
);

CREATE TABLE `Video` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `url` varchar(255) DEFAULT NULL,
    `video_time` int DEFAULT NULL,
    `transcription` varchar(255) DEFAULT NULL,
    `activity` int DEFAULT NULL,
    `title` varchar(255) NOT NULL,
    `code` varchar(255) DEFAULT NULL,
    `active` tinyint(1) DEFAULT NULL,
    `order_in_system` int DEFAULT NULL,
    `section_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`section_id`) REFERENCES `Section` (`id`)
);

CREATE TABLE `Explanation` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `explanatory_text` text,
    `title` varchar(255) NOT NULL,
    `code` varchar(255) DEFAULT NULL,
    `active` tinyint(1) DEFAULT NULL,
    `order_in_system` int DEFAULT NULL,
    `section_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`section_id`) REFERENCES `Section` (`id`)
);


CREATE TABLE `Question` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `statement` varchar(255) DEFAULT NULL,
    `question_type` varchar(255) DEFAULT NULL,
    `title` varchar(255) NOT NULL,
    `code` varchar(255) DEFAULT NULL,
    `active` tinyint(1) DEFAULT NULL,
    `order_in_system` int DEFAULT NULL,
    `section_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`section_id`) REFERENCES `Section` (`id`)
);

CREATE TABLE `Alternative` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `explanatory_text` varchar(100) DEFAULT NULL,
    `order_in_system` int DEFAULT NULL,
    `correct` tinyint(1) DEFAULT NULL,
    `justification` varchar(100) DEFAULT NULL,
    `question_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`question_id`) REFERENCES `Question` (`id`)
);