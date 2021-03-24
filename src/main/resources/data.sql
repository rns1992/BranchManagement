DROP TABLE IF EXISTS branch;
DROP TABLE IF EXISTS vaccine;
DROP TABLE IF EXISTS vaccine_by_branch;
DROP TABLE IF EXISTS branch_availability;


CREATE TABLE branch (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE vaccine (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE vaccine_by_branch (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  branch_id INT NOT NULL,
  vaccine_id INT NOT NULL,
  quantity INT NOT NULL
);

CREATE TABLE branch_availability (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  branch_id INT NOT NULL,
  vaccine_id INT NOT NULL,
  start_time int not null,
  end_time int not null
);


-- Branch name sample values
INSERT INTO branch (id, name) VALUES (1, 'Bridgeport');
INSERT INTO branch (id, name) VALUES (2, 'Wilmington');
INSERT INTO branch (id, name) VALUES (3, 'Jacksonville');
INSERT INTO branch (id, name) VALUES (4, 'Little Rock');
INSERT INTO branch (id, name) VALUES (5, 'Baltimore');
INSERT INTO branch (id, name) VALUES (6, 'Detroit');
INSERT INTO branch (id, name) VALUES (7, 'Minneapolis');

-- Vaccine name sample values
INSERT INTO vaccine (id, name) VALUES (1, 'Covishield');
INSERT INTO vaccine (id, name) VALUES (2, 'Covaxin');

-- Vaccine name sample values
INSERT INTO vaccine_by_branch (id, branch_id, vaccine_id, quantity) VALUES (1, 1, 1, 100);
INSERT INTO vaccine_by_branch (id, branch_id, vaccine_id, quantity) VALUES (2, 2, 1, 100);
INSERT INTO vaccine_by_branch (id, branch_id, vaccine_id, quantity) VALUES (3, 3, 1, 100);
INSERT INTO vaccine_by_branch (id, branch_id, vaccine_id, quantity) VALUES (4, 4, 2, 100);
INSERT INTO vaccine_by_branch (id, branch_id, vaccine_id, quantity) VALUES (5, 5, 2, 100);
INSERT INTO vaccine_by_branch (id, branch_id, vaccine_id, quantity) VALUES (6, 6, 2, 100);
INSERT INTO vaccine_by_branch (id, branch_id, vaccine_id, quantity) VALUES (7, 7, 2, 100);
INSERT INTO vaccine_by_branch (id, branch_id, vaccine_id, quantity) VALUES (8, 1, 2, 100);
INSERT INTO vaccine_by_branch (id, branch_id, vaccine_id, quantity) VALUES (9, 2, 2, 100);
INSERT INTO vaccine_by_branch (id, branch_id, vaccine_id, quantity) VALUES (10, 3, 2, 100);

-- Branch available timings
INSERT INTO branch_availability (id, branch_id, vaccine_id, start_time, end_time) VALUES (1, 1, 1, 9, 15);
INSERT INTO branch_availability (id, branch_id, vaccine_id, start_time, end_time) VALUES (2, 1, 2, 9, 15);
INSERT INTO branch_availability (id, branch_id, vaccine_id, start_time, end_time) VALUES (3, 2, 1, 9, 15);
INSERT INTO branch_availability (id, branch_id, vaccine_id, start_time, end_time) VALUES (4, 2, 2, 9, 15);
INSERT INTO branch_availability (id, branch_id, vaccine_id, start_time, end_time) VALUES (5, 3, 1, 9, 15);
INSERT INTO branch_availability (id, branch_id, vaccine_id, start_time, end_time) VALUES (6, 3, 2, 9, 15);
INSERT INTO branch_availability (id, branch_id, vaccine_id, start_time, end_time) VALUES (7, 4, 1, 9, 15);