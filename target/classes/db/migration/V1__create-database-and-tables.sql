CREATE DATABASE codding_school;
USE codding_school;
CREATE TABLE category (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) not null,
  `code` varchar(100),
  `order` int,
  description text,
  active boolean,
  iconPath varchar(100),
  colorCode varchar(100),
  study_guide text
);
CREATE TABLE subcategory (
  id int PRIMARY KEY AUTO_INCREMENT,
  name varchar(100) not null,
  code varchar(100),
  `order` int,
  description text,
  active boolean,
  category int,
  study_guide text,
  foreign key (category) references category(id)
);
CREATE TABLE course (
  id int PRIMARY KEY AUTO_INCREMENT,
  name varchar(100) not null,
  code varchar(100),
  estimated_time int,
  visible boolean,
  target text,
  instructor varchar(100),
  description text,
  developed_skills text,
  subcategory int,
  study_guide text,
  foreign key (subcategory) references subcategory(id)
);
CREATE TABLE section (
  id int PRIMARY KEY AUTO_INCREMENT,
  name varchar(100) not null,
  code varchar(100),
  `order` int,
  active boolean,
  test boolean,
  course int,
  foreign key (course) references course(id)
);
CREATE TABLE explanation(
  id int PRIMARY KEY AUTO_INCREMENT,
  explanatory_text text,
  title varchar(100) not null,
  code varchar(100),
  active boolean,
  `order` int,
  section int,
  foreign key (section) references section(id)
);
CREATE TABLE video(
  id int PRIMARY KEY AUTO_INCREMENT,
  url varchar(100),
  video_time int,
  transcription varchar(100),
  activity int,
  title varchar(100) not null,
  code varchar(100),
  active boolean,
  `order` int,
  section int,
  foreign key (section) references section(id)
);
CREATE TABLE question(
  id int PRIMARY KEY AUTO_INCREMENT,
  statement varchar(100),
  question_type ENUM('UNIQUE', 'MULTIPLE', 'TRUE_OR_FALSE')
  title varchar(100) not null,
  code varchar(100),
  active boolean,
  `order` int,
  section int,
  foreign key (section) references section(id)
);
CREATE TABLE alternative(
  id int PRIMARY KEY AUTO_INCREMENT,
  explanatory_text varchar(100),
  `order` int,
  correct boolean,
  justification varchar(100),
  question int,
  foreign key (question) references question(id)
);
DROP DATABASE codding_school;