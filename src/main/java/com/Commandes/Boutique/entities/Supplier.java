package com.Commandes.Boutique.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Supplier {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long supplierid;
  private String name;
  private String country;
  private String email;
  private String phone;
  //@Column(name = "CONNECTION_DATE")
  /*
  * je note ici que pour cette attribut au depart j'avais connectionDate et le faite d'avoir un "D"
  * majuscule n'a pas causer de probleme au niveau de la persitence de la table Supplier car H2 contenait
  * bien la table avec l'attribut CONNECTIONDATE...mais le probleme se trouvais plutôt au niveau du FETCH des data
  * car a ce niveau au lieu de select connectionDate, spring fait select connection_date qu'il trouve pas dans la base
  * de données tant que le D n'est pas en miniscule*/
  private Timestamp connectiondate;
  /*
  @OneToMany(cascade = CascadeType.ALL)
  private Client client;*/

  public Supplier(Long supplierid, String name, String country, String email, String phone, Timestamp connectiondate) {
    this.supplierid = supplierid;
    this.name=name;
    this.country = country;
    this.email = email;
    this.phone = phone;
    this.connectiondate = connectiondate;
  }
  public Supplier() {
  }

  public Long getSupplierid() {
    return supplierid;
  }

  public void setSupplierid(Long supplierid) {
    this.supplierid = supplierid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Timestamp getConnectiondate() {
    return connectiondate;
  }

  public void setConnectiondate(Timestamp connectionDate) {
    this.connectiondate = connectionDate;
  }

  @Override
  public String toString() {
    return "Supplier{" +
        "supplierId=" + supplierid +
        ", name='" + name + '\'' +
        ", country='" + country + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", connectionDate=" + connectiondate +
        '}';
  }
}
