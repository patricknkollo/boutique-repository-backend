CREATE TABLE client (
    clientid int NOT NULL AUTO_INCREMENT primary key,
     prenom varchar(255),
	nom varchar(255),
	rue varchar(255),
	email varchar(255),
	phone varchar(255),
	ville varchar(255),
	numero int,
	post_code varchar(255),
	pays varchar(255)
   
);