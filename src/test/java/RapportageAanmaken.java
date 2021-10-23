import org.junit.jupiter.api.*;
import reserveringsysteem.reservering.adapters.ReserveringRESTService;
import reserveringsysteem.reservering.adapters.RapportageRESTService;
import reserveringsysteem.reservering.application.RapportageApplicationService;
import reserveringsysteem.reservering.application.ReserveringApplicationService;
import reserveringsysteem.reservering.domain.RapportageRepository;
import reserveringsysteem.reservering.domain.RapportageTijdbestek;
import reserveringsysteem.reservering.domain.Rapportage;
import reserveringsysteem.reservering.domain.ReserveringRepository;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RapportageAanmaken 
{
	static ReserveringRepository resRep;
	static ReserveringApplicationService resApp;
	static ReserveringRESTService resRest;

	static RapportageRepository rapRep;
	static RapportageApplicationService rapApp;
	static RapportageRESTService rapRest;

	@BeforeAll
	public static void setUp()
	{
		resRep = new ReserveringRepository();
		resApp = new ReserveringApplicationService(resRep);
		resRest = new ReserveringRESTService(resApp);

		rapRep = new RapportageRepository();
		rapApp = new RapportageApplicationService(rapRep);
		rapRest = new RapportageRESTService(rapApp);
	}

	//Aanmaken rapportage. CreateRapportage is een boolean dus er wordt met assertEquals gekeken of ze gelijk zijn.
	@Test
	@Order(1)
	public void rapportageAanmaken() throws ParseException
	{
        Assertions.assertEquals(true, rapRest.createRapportage(new SimpleDateFormat("dd/MM/yyyy").parse("24/11/2021"),
        	new SimpleDateFormat("dd/MM/yyyy").parse("26/11/2021"),7));
    }
}