CREATE DATABASE Codding_school;

USE Codding_school;

CREATE TABLE Category (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) not null,
  `code` varchar(100) not null,
  `order` int,
  `description` text,
  `active` boolean,
  `icon_path` varchar(100),
  `color_code` varchar(100),
  `study_guide` text
);

CREATE TABLE Subcategory (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) not null,
  `code` varchar(100) not null,
  `order` int,
  `description` text,
  `active` boolean,
  `category_id` bigint not null,
  `study_guide` text,
  foreign key (category_id) references Category(id)
);

CREATE TABLE Course (
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
  foreign key (subcategory_id) references Subcategory(id)
);

CREATE TABLE Section (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) not null,
  `code` varchar(100) not null,
  `order` int,
  `active` boolean,
  `test` boolean,
  `course_id` bigint not null,
  foreign key (course_id) references Course(id)
);

CREATE TABLE Explanation (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `explanatory_text` text,
  `title` varchar(100) not null,
  `code` varchar(100),
  `active` boolean,
  `order` int,
  `section_id` bigint not null,
  foreign key (section_id) references Section(id)
);

CREATE TABLE Video (
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
  foreign key (section_id) references Section(id)
);

CREATE TABLE Question (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `statement` varchar(100),
  `question_type` ENUM('UNIQUE', 'MULTIPLE', 'TRUE_OR_FALSE'),
  `title` varchar(100) not null,
  `code` varchar(100),
  `active` boolean,
  `order` int,
  `section_id` bigint not null,
  foreign key (section_id) references Section(id)
);

CREATE TABLE Alternative (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `explanatory_text` varchar(100),
  `order` int,
  `correct` boolean,
  `justification` varchar(100),
  `question_id` bigint not null,
  foreign key (question_id) references Question(id)
);

DROP DATABASE codding_school;