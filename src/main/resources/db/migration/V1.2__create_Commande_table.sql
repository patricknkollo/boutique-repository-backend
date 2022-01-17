CREATE TABLE Commandes (
    numcmdid int NOT NULL AUTO_INCREMENT primary key,
    clientid int,
    datecmd date,
    etatcmd varchar(500),
    FOREIGN KEY (clientid) REFERENCES Client (clientid)
);