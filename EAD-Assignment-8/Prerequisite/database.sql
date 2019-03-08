
CREATE TABLE admin
(	username varchar(20) PRIMARY_KEY,
	password varchar(15) NOT_NULL
);

INSERT INTO admin VALUES("metacube" , "metacube");

CREATE TABLE user 
( id int PRIMARY KEY AUTO_INCREMENT,
  first_name varchar(20) NOT NULL,
  last_name varchar(20) NOT NULL,
  contact_number varchar(10) NOT NULL,
  email varchar(50) NOT NULL
);