package com.jongjava.alvin.kuisgame.model;

public class DataItem{
	private String pilihanA;
	private String pilihanC;
	private String pilihanB;
	private String pilihanD;
	private String namaSetting;
	private String namaJenisRumus;
	private String namaJenisBangunan;
	private String kunciJawaban;
	private String rumus;
	private String showrumus;
	private String idPertanyaan;
	private String nomer;
	private String namaLevel;
	private String judul;
	private String pertanyaan;
	private String url;
	private String filename;

//	public DataItem(String pilihanA, String pilihanC, String pilihanB, String pilihanD, String namaSetting, String namaJenisRumus, String namaJenisBangunan, String kunciJawaban, String rumus, String idPertanyaan, String nomer, String namaLevel, String judul, String pertanyaan) {
//		this.pilihanA = pilihanA;
//		this.pilihanC = pilihanC;
//		this.pilihanB = pilihanB;
//		this.pilihanD = pilihanD;
//		this.namaSetting = namaSetting;
//		this.namaJenisRumus = namaJenisRumus;
//		this.namaJenisBangunan = namaJenisBangunan;
//		this.kunciJawaban = kunciJawaban;
//		this.rumus = rumus;
//		this.idPertanyaan = idPertanyaan;
//		this.nomer = nomer;
//		this.namaLevel = namaLevel;
//		this.judul = judul;
//		this.pertanyaan = pertanyaan;
//	}
//


	public DataItem() {
		super();
	}

	public DataItem(String pilihanA, String pilihanC, String pilihanB, String pilihanD, String pertanyaan, String kunciJawaban, String judul,String rumus,String namaLevel,String showrumus, String url) {
		this.pilihanA = pilihanA;
		this.pilihanC = pilihanC;
		this.pilihanB = pilihanB;
		this.pilihanD = pilihanD;
		this.pertanyaan = pertanyaan;
		this.kunciJawaban = kunciJawaban;
		this.judul = judul;
		this.rumus = rumus;
		this.namaLevel = namaLevel;
		this.showrumus = showrumus;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setPilihanA(String pilihanA){
		this.pilihanA = pilihanA;
	}

	public String getPilihanA(){
		return pilihanA;
	}

	public void setPilihanC(String pilihanC){
		this.pilihanC = pilihanC;
	}

	public String getPilihanC(){
		return pilihanC;
	}

	public void setPilihanB(String pilihanB){
		this.pilihanB = pilihanB;
	}

	public String getPilihanB(){
		return pilihanB;
	}

	public void setPilihanD(String pilihanD){
		this.pilihanD = pilihanD;
	}

	public String getPilihanD(){
		return pilihanD;
	}

	public void setNamaSetting(String namaSetting){
		this.namaSetting = namaSetting;
	}

	public String getNamaSetting(){
		return namaSetting;
	}

	public void setNamaJenisRumus(String namaJenisRumus){
		this.namaJenisRumus = namaJenisRumus;
	}

	public String getNamaJenisRumus(){
		return namaJenisRumus;
	}

	public void setNamaJenisBangunan(String namaJenisBangunan){
		this.namaJenisBangunan = namaJenisBangunan;
	}

	public String getNamaJenisBangunan(){
		return namaJenisBangunan;
	}

	public void setKunciJawaban(String kunciJawaban){
		this.kunciJawaban = kunciJawaban;
	}

	public String getKunciJawaban(){
		return kunciJawaban;
	}

	public void setRumus(String rumus){
		this.rumus = rumus;
	}

	public String getRumus(){
		return rumus;
	}

	public void setShowRumus(String showRumus){
		this.showrumus = showRumus;
	}

	public String getShowRumus(){
		return showrumus;
	}

	public void setIdPertanyaan(String idPertanyaan){
		this.idPertanyaan = idPertanyaan;
	}

	public String getIdPertanyaan(){
		return idPertanyaan;
	}

	public void setNomer(String nomer){
		this.nomer = nomer;
	}

	public String getNomer(){
		return nomer;
	}

	public void setNamaLevel(String namaLevel){
		this.namaLevel = namaLevel;
	}

	public String getNamaLevel(){
		return namaLevel;
	}

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
	}

	public void setPertanyaan(String pertanyaan){
		this.pertanyaan = pertanyaan;
	}

	public String getPertanyaan(){
		return pertanyaan;
	}

	@Override
 	public String toString(){
		return pertanyaan;
		}
}
