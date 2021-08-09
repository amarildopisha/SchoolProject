public class Model {
	
	//Ne kete klase ndodhen gjith variablat e klases model ku te dhenat jane private.
	//Dhe aksesohen vetem nepermjet funksioneve publik.
	private String emri;
	private String mbiemri;
	private String statusi;
	private float sasiaKilovat;
	private float shumaPara;
	private float tvsh;
	private float shumaPaTvsh;

	//Funksionet e meposhtme therriten dhe kthejne vlera.
	public String merrEmrin() {
		return emri;
	}
	
	public String merrMbiemrin() {
		return mbiemri;
	}
	
	public String merrStatusin() {
		return statusi;
	}
	
	public float merrSasiaKilovat() {
		return sasiaKilovat;
	}
	
	public float merrShumenPara() {
		return shumaPara;
	}
	
	public float merrTvsh() {
		return tvsh;
	}
	
	public float merrShumenPaTvsh() {
		return shumaPaTvsh;
	}
	
	//Funksionet e meposthem regjistrojen te dhenat ne objektin Model.
	//Keto funksione perdoren pasi krijohet objekti.
	public void regjistroEmrin(String emri) {
		this.emri = emri;
	}
	
	public void regjistroMbiemrin(String mbiemri) {
		this.mbiemri = mbiemri;
	}
	
	public void regjistroStatusin(String statusi) {
		this.statusi = statusi;
	}
	
	public void regjistroSasiaKilovat(float sasiaKilovat) {
		this.sasiaKilovat = sasiaKilovat;
	}
	
	public void regjistroShumenPara(float shumaPara) {
		this.shumaPara = shumaPara;
	}
	
	public void regjistroTvsh(float tvsh) {
		this.tvsh = tvsh;
	}
	
	public void regjistroShumenPaTvsh(float shumaPaTvsh) {
		this.shumaPaTvsh = shumaPaTvsh;
	}
}
