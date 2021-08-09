import java.time.format.DateTimeFormatter;  //Paketa Date dhe time importohen me qellim per te verifikuar daten e fatures.
import java.time.LocalDateTime;  

//Nga Klasa kontroller krijohet nje objekt dhe me ane te tij manipulohen te dhenat,
//qe regjistrohen ne objektin Model.
public class Controller {
	
	private Model model; 
	//Kur krijohet objekti Controller ai merr si parameter nje tjeter objekt ne kete rast objektin Model.
	public Controller(Model m) {
		model = m;
	}
	
	//Ky funksion ben te mundur regjistrimin e te dhenave si dhe ekzekutimin e dy funksioneve qe paraqiten me poshte.
	public void regjistroTeDhenat(String emri, String mbiemri, float sasia, boolean statusi) {
		model.regjistroEmrin(emri);
		model.regjistroMbiemrin(mbiemri);
		model.regjistroSasiaKilovat(sasia);
		regjistroStatusin(statusi);
		llogaritShumen();
		
	}
	
	//Brenda funksionit llogaritShumen() eshte ndertuar llogjika e kalkulimit te vleres ne LEK
	//te kilovateve te harxhuar. Pasi perfundon llogaritja regjistrohen te dhenat ne Objektin Model.
	//Ky funksion therritet brenda funksionit regjistroTeDhenat()
	public void llogaritShumen() {
		float shumaPaTvsh = 0;
		float tvsh = 0;
		float shumaTotal = 0;
		if (model.merrStatusin().equals("familjar")) {
			if (model.merrSasiaKilovat() < 300) {
				shumaPaTvsh =  (model.merrSasiaKilovat() * 7);
				tvsh = shumaPaTvsh * 20 / 100;
				shumaTotal = shumaPaTvsh + tvsh;
			} else {
				shumaPaTvsh =  (model.merrSasiaKilovat() * 13);
				tvsh = shumaPaTvsh * 20 / 100;
				shumaTotal = shumaPaTvsh + tvsh;
			}
		} else if(model.merrStatusin().equals("biznes")) {
			if (model.merrSasiaKilovat() < 300) {
				shumaPaTvsh =  (model.merrSasiaKilovat() * 11);
				tvsh = shumaPaTvsh * 20 / 100;
				shumaTotal = shumaPaTvsh + tvsh;
			} else {
				shumaPaTvsh =  (model.merrSasiaKilovat() * 15);
				tvsh = shumaPaTvsh * 20 / 100;
				shumaTotal = shumaPaTvsh + tvsh;
			}
		}
		model.regjistroShumenPaTvsh(shumaPaTvsh);
		model.regjistroTvsh(tvsh);
		model.regjistroShumenPara(shumaTotal);
	}
	
	//Funksioni regjistro statusin ben te mundur konvertimin e vleres boolean
	//qe e marrim nga radioButoni qe gjendet ne view.
	//Nese radio butoni eshte true, atherehe regjistrohet ne model, vlera familjar
	//Ne te kundert vlera biznes.
	public void regjistroStatusin(boolean statusi) {
		if(statusi == true) {
			model.regjistroStatusin("familjar");
		} else {
			model.regjistroStatusin("biznes");
		}
	}
	
	//Funksioni perdoret per te modeluar tekstin ne menyre estetike si te ishte nje fature e vertete,
	//qellimi ne kete rast nuk eshte vetem funnksional por edhe estetik.
	//Ky funksion kthen si vlere nje string qe me pas printohet ne Objektin view ne componentin JTextPane.
	//Ne kete funksion eshte perfshire data dhe ora kur fatura printohet.
	//Dy objektet e meposhtme formatojne daten e me pas japin date dhe oren aktuale.
	public String afishoFaturen() {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();
		return     ("----------------------FATURA----------------------\n"
				   +"- Emri: "+model.merrEmrin()+"\n"
		           +"- Mbiemri: "+model.merrMbiemrin()+"\n"
				   +"- Sasia e konsumuar: "+model.merrSasiaKilovat()+" kWh\n"
		           +"- Statusi: "+model.merrStatusin()+"\n"
		           +"- Totali konsumuar ne LEK: "+model.merrShumenPaTvsh()+" LEK\n"
		           +"- TVSH: "+model.merrTvsh()+" LEK\n"
		           +"- Totali me TVSH: "+model.merrShumenPara()+" LEK\n"
		           +"- Data: "+dtf.format(now)+"\n"
		           +"- Ju faleminderit!\n"
				   +"-----------------------------------------------------");
	}
	
}
