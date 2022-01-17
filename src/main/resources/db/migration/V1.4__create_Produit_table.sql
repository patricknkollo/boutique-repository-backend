CREATE TABLE Produit (
    produitid int NOT NULL AUTO_INCREMENT primary key,
    designation varchar(1000),
    famille_produitid int,
    prix_de_vente double,
    stock_alerte varchar(1000),
    stock_inventaire int,
     FOREIGN KEY (famille_produitid) REFERENCES Famille (famille_produitid)
);