INSERT INTO K_SITE (ID_SITE, DS_CODE, DS_NAME, DT_CREATION, DT_MODIFIED, DS_USER_CREATION, DS_USER_MODIFIED)
values 
(1, 'SITE001', 'Sitio A', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx'),
(2, 'SITE002', 'Sitio B', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx');


INSERT INTO K_IT_SERVICE (ID_IT_SERVICE, DS_CODE, DS_NAME, DT_CREATION, DT_MODIFIED, DS_USER_CREATION, DS_USER_MODIFIED)
values 
(1, 'ITS001', 'IT Service A', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx'),
(2, 'ITS002', 'IT Service B', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx'),
(3, 'ITS003', 'IT Service C', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx');


INSERT INTO K_SERVER (ID_SERVER, DS_CODE, DS_NAME, DT_CREATION, DT_MODIFIED, DS_USER_CREATION, DS_USER_MODIFIED)
values 
(1, 'SERV001', 'Server0001', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx'),
(2, 'SERV002', 'Server0002', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx'),
(3, 'SERV003', 'Server0003', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx'),
(4, 'SERV004', 'Server0004', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx'),
(5, 'SERV005', 'Server0005', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx'),
(6, 'SERV006', 'Server0006', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx');


INSERT INTO K_APPLICATION (ID_APPLICATION, ID_SITE, ID_IT_SERVICE, DS_CODE, DS_NAME, DS_COMMENT, DT_CREATION, DT_MODIFIED, DS_USER_CREATION, DS_USER_MODIFIED)
values 
(1, 1, 1, 'APP001', 'Aplicacion A', 'Lorem ipsum dolor sit amet', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx'),
(2, 1, 2, 'APP002', 'Aplicacion B', 'Lorem ipsum dolor sit amet', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx'),
(3, 2, 3, 'APP003', 'Aplicacion C', 'Lorem ipsum dolor sit amet', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx'),
(4, 2, 1, 'APP004', 'Aplicacion D', 'Lorem ipsum dolor sit amet', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx'),
(5, 1, 2, 'APP005', 'Aplicacion E', 'Lorem ipsum dolor sit amet', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx'),
(6, 1, 3, 'APP006', 'Aplicacion F', 'Lorem ipsum dolor sit amet', '2020-11-11 12:00:01', '2020-11-11 12:00:01', 'user@prosa.com.mx', 'user@prosa.com.mx');

INSERT INTO K_APPLICATION_X_SERVER(ID_APPLICATION, ID_SERVER)
values
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 1),
(3, 2),
(3, 3),
(3, 4),
(4, 3),
(4, 4),
(5, 5),
(5, 6),
(6, 5),
(6, 6);


DROP SEQUENCE IF EXISTS SEQ_APPLICATION;
DROP SEQUENCE IF EXISTS SEQ_IT_SERVICE;
DROP SEQUENCE IF EXISTS SEQ_SERVER;
DROP SEQUENCE IF EXISTS SEQ_SITE;

CREATE SEQUENCE IF NOT EXISTS seq_application START WITH 21;
CREATE SEQUENCE IF NOT EXISTS seq_it_service START WITH 21;
CREATE SEQUENCE IF NOT EXISTS seq_server START WITH 21;
CREATE SEQUENCE IF NOT EXISTS seq_site START WITH 21;


ALTER TABLE K_APPLICATION
ADD FOREIGN KEY (ID_SITE) REFERENCES K_SITE(ID_SITE);

ALTER TABLE K_APPLICATION
ADD FOREIGN KEY (ID_IT_SERVICE) REFERENCES K_IT_SERVICE(ID_IT_SERVICE);

ALTER TABLE K_APPLICATION_X_SERVER
ADD FOREIGN KEY (ID_APPLICATION) REFERENCES K_APPLICATION(ID_APPLICATION);
ALTER TABLE K_APPLICATION_X_SERVER
ADD FOREIGN KEY (ID_SERVER) REFERENCES K_SERVER(ID_SERVER);
