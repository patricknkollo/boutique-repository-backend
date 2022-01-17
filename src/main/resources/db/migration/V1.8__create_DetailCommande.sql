CREATE TABLE Detail_Commande(
    lignecmdid int NOT NULL AUTO_INCREMENT primary key,
    numcmdid int,
    prix_unitaire_sortie double,
    prix_vente_total double,
    produitid int,
    quantite_sortie int,
    FOREIGN KEY (numcmdid) REFERENCES Commandes (numcmdid),
    FOREIGN KEY (produitid) REFERENCES Produit (produitid)
);