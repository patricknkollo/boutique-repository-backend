package projections;

import org.springframework.beans.factory.annotation.Value;

public interface ClientProjectionNameAndVorname {

	String getNom();
	String getPrenom();
	
//	@Value("#{target.pays+ '  ' + target.ville}")
//	String getCompleteAdress();
}
