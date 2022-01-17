CREATE TABLE Details_produits (
    detail_produitid int NOT NULL AUTO_INCREMENT primary key,
    date_entree date,
    produitid int,
    qte_entree int,
    qte_sortie int,
    FOREIGN KEY (produitid) REFERENCES Produit (produitid)
);