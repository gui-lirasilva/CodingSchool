CREATE DATABASE codding_school;

USE codding_school;

CREATE TABLE categories (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) not null,
  `code` varchar(100) not null,
  `order` int,
  `description` text,
  `active` boolean,
  `iconPath` varchar(100),
  `colorCode` varchar(100),
  `study_guide` text
);

CREATE TABLE subcategories (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) not null,
  `code` varchar(100) not null,
  `order` int,
  `description` text,
  `active` boolean,
  `category_id` bigint not null,
  `study_guide` text,
  foreign key (category_id) references categories(id)
);

CREATE TABLE courses (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) not null,
  `code` varchar(100) not null,
  `estimated_time` int,
  `visible` boolean,
  `target` text,
  `instructor` varchar(100),
  `description` text,
  `developed_skills` text,
  `subcategory_id` bigint not null,
  `study_guide` text,
  foreign key (subcategory_id) references subcategories(id)
);

CREATE TABLE sections (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) not null,
  `code` varchar(100) not null,
  `order` int,
  `active` boolean,
  `test` boolean,
  `course_id` bigint not null,
  foreign key (course_id) references courses(id)
);

CREATE TABLE explanations (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `explanatory_text` text,
  `title` varchar(100) not null,
  `code` varchar(100),
  `active` boolean,
  `order` int,
  `section_id` bigint not null,
  foreign key (section_id) references sections(id)
);

CREATE TABLE videos (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `url` varchar(100),
  `video_time` int,
  `transcription` varchar(100),
  `activity` int,
  `title` varchar(100) not null,
  `code` varchar(100),
  `active` boolean,
  `order` int,
  `section_id` bigint not null,
  foreign key (section_id) references sections(id)
);

CREATE TABLE questions (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `statement` varchar(100),
  `question_type` ENUM('UNIQUE', 'MULTIPLE', 'TRUE_OR_FALSE')
  `title` varchar(100) not null,
  `code` varchar(100),
  `active` boolean,
  `order` int,
  `section_id` bigint not null,
  foreign key (section_id) references sections(id)
);

CREATE TABLE alternatives (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `explanatory_text` varchar(100),
  `order` int,
  `correct` boolean,
  `justification` varchar(100),
  `question_id` bigint not null,
  foreign key (question_id) references questions(id)
);

DROP DATABASE codding_school;