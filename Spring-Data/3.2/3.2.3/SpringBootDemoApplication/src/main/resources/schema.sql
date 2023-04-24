CREATE TABLE COURSES
(
    id int not null AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    category varchar(20) NOT NULL,
    rating int(1) NOT NULL,
    description varchar(1000) NOT NULL,
    PRIMARY KEY (id)
);