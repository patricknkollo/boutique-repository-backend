CREATE TABLE PAIEMENT (
     paiementid int NOT NULL AUTO_INCREMENT primary key,
     datepaiement date,
     modeid int,
     montant int,
     numcmdid int,
     FOREIGN KEY (modeid) REFERENCES Mode_Reglement (modeid),
     FOREIGN KEY (numcmdid) REFERENCES Commandes (numcmdid)
);