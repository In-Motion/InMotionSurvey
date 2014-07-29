package in.inmotion.inmotionsurvey.utils;

public class AutoWala {
	private String id;
	private String name;
	private String address;
	private String contact;
	private String age;
	private String autoNumber;
	private String education;
	private String experience;
	private String income;
	private String boys;
	private String girls;
	private String kids;
	private String owner;
	private String ownerContact;
	private String ownerAddress;
	private String chkAccount;
	private String chkInsurance;
	private String chkPhoto;
	private String chkAd;
	private String chkTobacco;
	private String reference;
	private String adNumber;
	private String campaign;
	
	
	public AutoWala() {
		// do nothing
	}
	
	public AutoWala(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public AutoWala(String id, String name, String add, String contact, String age,
			String autoNo, String edu, String exp, String in, String b, String g,
			String o, String oCon, String oAdd, String cAcc, String cIns, String cPic,
			String cAd, String cToba, String ref, String adNo, String camp) {
		this.id = id;
		this.name = name;
		this.address = add;
		this.contact = contact;
		this.age = age;
		this.autoNumber = autoNo;
		this.education = edu;
		this.experience = exp;
		this.income = in;
		this.boys = b;
		this.girls = g;
		this.owner = o;
		this.ownerContact = oCon;
		this.ownerAddress = oAdd;
		this.chkAccount = cAcc;
		this.chkInsurance = cIns;
		this.chkPhoto = cPic;
		this.chkAd = cAd;
		this.chkTobacco = cToba;
		this.reference = ref;
		this.adNumber = adNo;
		this.campaign = camp;
	}
	
	/* Setters */
	public void setId(String id){
		this.id = id;  
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setContact(String contact){
		this.contact = contact;
	}
	
	public void setAge(String age){
		this.age = age;
	}
	
	public void setAutoNumber(String num){
		this.autoNumber = num;
	}
	
	public void setEducation(String edu){
		this.education = edu;
	}
	
	public void setExperience(String exp){
		this.experience = exp;
	}
	
	public void setIncome(String income){
		this.income = income;
	}
	
	public void setBoys(String boys){
		this.boys = boys;
	}
	
	public void setGirls(String girls){
		this.girls = girls;
	}
	
	public void setKids(String kids){
		this.kids = kids;
	}
	
	public void setOwner(String owner){
		this.owner = owner;
	}
	
	public void setOwnerAddress(String oAddress){
		this.ownerAddress = oAddress;
	}
	
	public void setOwnerContact(String oContact){
		this.ownerContact = oContact;
	}
	
	public void setAccountState(String cAccount){
		this.chkAccount = cAccount;
	}
	
	public void setInsuranceState(String  cInsurance){
		this.chkInsurance = cInsurance;
	}
	
	public void setPhotoState(String cPhoto){
		this.chkPhoto = cPhoto;
	}
	
	public void setAdState(String cAd){
		this.chkAd = cAd;
	}
	
	public void setTobaccoState(String cTobacco){
		this.chkTobacco = cTobacco;
	}
	
	public void setCampaign(String camp){
		this.campaign = camp;
	}
	
	public void setReferences(String ref){
		this.reference = ref;
	}
	
	public void setAdNumber(String adNo){
		this.adNumber = adNo;
	}
	
	/* Getters */
	public String getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getContact(){
		return this.contact;
	}
	
	public String getAge(){
		return this.age;
	}
	
	public String getAutoNumber(){
		return this.autoNumber;
	}
	
	public String getEducation(){
		return this.education;
	}
	
	public String getExperience(){
		return this.experience;
	}
	
	public String getIncome(){
		return this.income;
	}
	
	public String getBoys(){
		return this.boys;
	}
	
	public String getGirls(){
		return this.girls;
	}
	
	public String getKids(){
		return this.kids;
	}
	
	public String getOwner(){
		return this.owner;
	}
	
	public String getOwnerAddress(){
		return this.ownerAddress;
	}
	
	public String getOwnerContact(){
		return this.ownerContact;
	}
	
	public String getAccountState(){
		return this.chkAccount;
	}
	
	public String getInsuranceState(){
		return this.chkInsurance;
	}
	
	public String getPhotoState(){
		return this.chkPhoto;
	}
	
	public String getAdState(){
		return this.chkAd;
	}
	
	public String getTobaccoState(){
		return this.chkTobacco;
	}
	
	public String getCampaign(){
		return this.campaign;
	}
	
	public String getReferences(){
		return this.reference;
	}
	
	public String getAdNumber(){
		return this.adNumber;
	}
	
	public AutoWala getAutoWala(){
		return this;
	}
		
}
