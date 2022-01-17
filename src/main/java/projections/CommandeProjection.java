package projections;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public interface CommandeProjection {

 //   private Long numCMDid;
	
 //   private Long clientid;
	
	@Value("#{target.numCMDid+ '  ' +target.clientid}")
	String getCommandAndClientIds ();
}
