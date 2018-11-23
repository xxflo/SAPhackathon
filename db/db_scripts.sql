create database hackathon;
use hackathon;

DROP TABLE users;
CREATE TABLE users(name VARCHAR(128), pwd VARCHAR(64), email VARCHAR(256), home VARCHAR(256), inumber VARCHAR(256), teamname VARCHAR(256)); 

TRUNCATE TABLE users;
INSERT INTO users VALUES ('Abid', 'winwin', 'abid.salahi.esfahani@sap.com', '','','');
INSERT INTO users VALUES ('Floris', 'winwin', 'floris.huang@sap.com', '','','');
INSERT INTO users VALUES ('Heesu', 'winwin', 'hee.su.kim@sap.com', '','','');
INSERT INTO users VALUES ('Tanya', 'winwin', 'tanya.zhou@sap.com', '','','');
INSERT INTO users VALUES ('Peng', 'winwin', 'zhen.peng.zhu@sap.com', '','','');

