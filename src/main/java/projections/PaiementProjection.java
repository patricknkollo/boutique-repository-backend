package projections;

import java.sql.Date;

public interface PaiementProjection {

	public Long getPaiementid() ;

	public Date getDatepaiement();
	
	public double getMontant();
	
}
