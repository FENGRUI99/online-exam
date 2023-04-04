drop database if exists online_exam;
create database online_exam;
use online_exam;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

drop table if exists user;
create table user(
    id int auto_increment not null,
    username varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    password varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    real_name varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    class_id  int NOT NULL,
    primary key (id) using btree,
    unique index username (username) using btree
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

drop table if exists tea_user;
create table tea_user(
    id int auto_increment NOT NULL,
    username varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    password varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    real_name varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    class_id int NOT NULL,
    primary key (id) using btree,
    unique index username (username) using btree
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

drop table if exists course;
create table course(
    id int auto_increment NOT NULL,
    course_name varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    primary key (id) using btree
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

drop table if exists class;
create table class(
    id int auto_increment NOT NULL,
    class_name varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    primary key (id) using btree
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

drop table if exists question;
create table question(
    id int auto_increment NOT NULL,
    question_content varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    option_a varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    option_b varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    option_c varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    option_d varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    answer varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    course_id int NOT NULL,
    primary key (id) using btree,
    UNIQUE INDEX question_content(question_content) USING BTREE,
    INDEX `fk_relationship_4`(course_id) USING BTREE,
    CONSTRAINT `fk_relationship_4` FOREIGN KEY (course_id) REFERENCES course (id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

drop table if exists exam;
create table exam(
    id int auto_increment NOT NULL,
    exam_name varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    course_id int NULL DEFAULT NULL,
    tea_user_id int NULL DEFAULT NULL,
    class_id int NULL DEFAULT NULL,
    question_number int NULL DEFAULT NULL,
    single_score varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    start_time date NULL DEFAULT NULL,
    end_time date NULL DEFAULT NULL,
    during int NULL DEFAULT NULL,
    primary key (id) using btree,
    INDEX `fk_relationship_1`(tea_user_id) USING BTREE,
    INDEX `fk_relationship_2`(class_id) USING BTREE,
    INDEX `fk_relationship_3`(course_id) USING BTREE,
    CONSTRAINT `fk_relationship_1` FOREIGN KEY (tea_user_id) REFERENCES `tea_user` (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk_relationship_2` FOREIGN KEY (class_id) REFERENCES class (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk_relationship_3` FOREIGN KEY (course_id) REFERENCES course (id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

drop table if exists exam_question_media;
create table exam_question_media(
    id int auto_increment NOT NULL,
    exam_id int NOT NULL,
    question_id int NOT NULL,
    course_id int NOT NULL,
    question_content varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    option_a varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    option_b varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    option_c varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    option_d varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    answer varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    primary key (id) using btree,
    INDEX `fk_relationship_12`(exam_id) USING BTREE,
    INDEX `fk_relationship_13`(question_id) USING BTREE,
    CONSTRAINT `fk_relationship_12` FOREIGN KEY (exam_id) REFERENCES exam (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk_relationship_13` FOREIGN KEY (question_id) REFERENCES question (id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

drop table if exists exam_user_media;
create table exam_user_media(
    id int auto_increment NOT NULL,
    user_id int NOT NULL,
    class_id int NOT NULL,
    exam_id int NOT NULL,
    exam_name varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    score int NOT NULL,
    total_score int NOT NULL,
    time date NOT NULL,
    primary key (id) using btree,
    INDEX `fk_relationship_5`(user_id) USING BTREE,
    INDEX `fk_relationship_6`(class_id) USING BTREE,
    INDEX `fk_relationship_7`(exam_id) USING BTREE,
    CONSTRAINT `fk_relationship_5` FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk_relationship_6` FOREIGN KEY (class_id) REFERENCES class (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk_relationship_7` FOREIGN KEY (exam_id) REFERENCES `exam` (id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS user_question;
CREATE TABLE user_question  (
  id int NOT NULL AUTO_INCREMENT,
  exam_user_media_id int(11) NOT NULL,
  user_id int(11) NOT NULL,
  exam_id int(11) NOT NULL,
  question_id int(11) NOT NULL,
  student_answer varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (id) USING BTREE,
  INDEX `fk_relationship_8`(exam_user_media_id) USING BTREE,
  INDEX `fk_relationship_9`(user_id) USING BTREE,
  INDEX `fk_relationship_10`(exam_id) USING BTREE,
  INDEX `fk_relationship_11`(question_id) USING BTREE,
  CONSTRAINT `fk_relationship_10` FOREIGN KEY (exam_id) REFERENCES exam (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_relationship_11` FOREIGN KEY (question_id) REFERENCES `question` (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_relationship_8` FOREIGN KEY (exam_user_media_id) REFERENCES exam_user_media (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_relationship_9` FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;


SET FOREIGN_KEY_CHECKS = 1;



insert into user (username, password, real_name, class_id)
values('1', '1', '1', 1),
      ('2', '2', '2', 1),
      ('3', '3', '3', 2),
      ('4', '4', '4', 2);

insert into class (class_name)
values('class1'),('class2');

insert into tea_user(username, password, real_name, class_id)
values('1', '1', '1', 1),('2', '2', '2', 2);

insert into course (course_name)
values('math'),('english');

insert into question(question_content, option_a, option_b, option_c, option_d, answer, course_id)
values('1', '1', '2', '3', '4', 'A', 1),
      ('2', '1', '2', '3', '4', 'A', 1),
      ('3', '1', '2', '3', '4', 'A', 2),
      ('4', '1', '2', '3', '4', 'A', 2),
      ('5', '1', '2', '3', '4', 'A', 2);