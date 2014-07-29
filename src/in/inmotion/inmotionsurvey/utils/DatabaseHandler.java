package in.inmotion.inmotionsurvey.utils;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "inmotion";
	private static final String TABLE_NAME = "survey";
	
	private static final String KEY_ID = "_id";
	private static final String KEY_NAME = "name";
	private static final String KEY_ADDRESS = "address";
	private static final String KEY_CONTACT = "contact";
	private static final String KEY_AGE = "age";
	private static final String KEY_AUTO_NUMBER = "auto_number";
	private static final String KEY_EDU = "education";
	private static final String KEY_EXP = "experience";
	private static final String KEY_INCOME = "incom";
	private static final String KEY_KIDS_BOYS = "boys";
	private static final String KEY_KIDS_GIRLS = "girls";
	private static final String KEY_KIDS = "kids";
	private static final String KEY_NAME_OWNER = "owner";
	private static final String KEY_CONTACT_OWNER = "owner_contact";
	private static final String KEY_ADDRESS_OWNER = "owner_address";
	private static final String KEY_CHK_ACCOUNT = "chk_account";
	private static final String KEY_CHK_INSURANCE = "chk_insurance";
	private static final String KEY_CHK_PHOTO = "chk_photo";
	private static final String KEY_CHK_AD = "chk_ad";
	private static final String KEY_CHK_TOBACCO = "chk_tobacco";
	private static final String KEY_REFERENCE = "reference";
	private static final String KEY_AD_NO = "ad_no";
	private static final String KEY_CAMPAIGN = "campaign";
	
	public static int tempId = 0;
	
	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " TEXT PRIMARY KEY, " 
				+ KEY_NAME + " TEXT, "
				+ KEY_ADDRESS + " TEXT, "
				+ KEY_CONTACT + " TEXT, "
				+ KEY_AGE + " TEXT, "
				+ KEY_AUTO_NUMBER + " TEXT, "
				+ KEY_EDU + " TEXT, "
				+ KEY_EXP + " TEXT, "
				+ KEY_INCOME + " TEXT, "
				+ KEY_KIDS_BOYS + " TEXT, "
				+ KEY_KIDS_GIRLS + " TEXT, "
				+ KEY_KIDS + " TEXT, "
				+ KEY_NAME_OWNER + " TEXT, "
				+ KEY_CONTACT_OWNER + " TEXT, "
				+ KEY_ADDRESS_OWNER + " TEXT, "
				+ KEY_CHK_ACCOUNT + " TEXT, "
				+ KEY_CHK_INSURANCE + " TEXT, "
				+ KEY_CHK_PHOTO + " TEXT, "
				+ KEY_CHK_AD + " TEXT, "
				+ KEY_CHK_TOBACCO + " TEXT, "
				+ KEY_REFERENCE + " TEXT, "
				+ KEY_AD_NO + " TEXT, "
				+ KEY_CAMPAIGN + " TEXT"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		 
        onCreate(db);

	}
	
	public void addAutoWala(AutoWala autoWala) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_ID, autoWala.getId());
		values.put(KEY_NAME, autoWala.getName());
		values.put(KEY_ADDRESS, autoWala.getAddress());
		values.put(KEY_CONTACT, autoWala.getContact());
		values.put(KEY_AGE, autoWala.getAge());
		values.put(KEY_AUTO_NUMBER, autoWala.getAutoNumber());
		values.put(KEY_EDU, autoWala.getEducation());
		values.put(KEY_EXP, autoWala.getExperience());
		values.put(KEY_INCOME, autoWala.getIncome());
		values.put(KEY_KIDS_BOYS, autoWala.getBoys());
		values.put(KEY_KIDS_GIRLS, autoWala.getGirls());
		values.put(KEY_KIDS, autoWala.getKids());
		values.put(KEY_NAME_OWNER, autoWala.getOwner());
		values.put(KEY_ADDRESS_OWNER, autoWala.getOwnerAddress());
		values.put(KEY_CONTACT_OWNER, autoWala.getOwnerContact());
		values.put(KEY_CHK_ACCOUNT, autoWala.getAccountState());
		values.put(KEY_CHK_INSURANCE, autoWala.getInsuranceState());
		values.put(KEY_CHK_PHOTO, autoWala.getPhotoState());
		values.put(KEY_CHK_AD, autoWala.getAdState());
		values.put(KEY_CHK_TOBACCO, autoWala.getTobaccoState());
		values.put(KEY_REFERENCE, autoWala.getReferences());
		values.put(KEY_AD_NO, autoWala.getAdNumber());
		values.put(KEY_CAMPAIGN, autoWala.getCampaign());
		
		db.insert(TABLE_NAME, null, values);
		db.close();
	}

	public AutoWala getAutoWala(String id){
		SQLiteDatabase db = this.getReadableDatabase();
		
		String[] columns = {
				KEY_ID,
				KEY_NAME,
				KEY_ADDRESS,
				KEY_CONTACT,
				KEY_AGE,
				KEY_AUTO_NUMBER,
				KEY_EDU,
				KEY_EXP,
				KEY_INCOME,
				KEY_KIDS_BOYS,
				KEY_KIDS_GIRLS,
				KEY_KIDS,
				KEY_NAME_OWNER,
				KEY_CONTACT_OWNER,
				KEY_ADDRESS_OWNER,
				KEY_CHK_ACCOUNT,
				KEY_CHK_INSURANCE,
				KEY_CHK_PHOTO,
				KEY_CHK_AD,
				KEY_CHK_TOBACCO,
				KEY_REFERENCE,
				KEY_AD_NO,
				KEY_CAMPAIGN
		};
		Cursor cursor = db.query(TABLE_NAME, 
				columns, KEY_ID + "=?", new String[] {id},
				null, null, null, null);
		
		if(cursor!=null)
			cursor.moveToFirst();
		
		int iId = cursor.getColumnIndex(KEY_ID);
		int iName = cursor.getColumnIndex(KEY_NAME);
		int iAddress = cursor.getColumnIndex(KEY_ADDRESS);
//		int iContact = cursor.getString(columnIndex)
		
		AutoWala autoWala = new AutoWala(cursor.getString(iId),cursor.getString(iName));
		
		autoWala.setAddress(cursor.getString(iAddress));
		autoWala.setContact(cursor.getString(3));
		autoWala.setAge(cursor.getString(4));
		autoWala.setAutoNumber(cursor.getString(5));
		autoWala.setEducation(cursor.getString(6));
		autoWala.setExperience(cursor.getString(7));
		autoWala.setIncome(cursor.getString(8));
		autoWala.setKids(cursor.getString(11));
		autoWala.setOwner(cursor.getString(12));
		
		cursor.close();
		db.close();
		return autoWala;
	}
	
	public List<AutoWala> getAllAutoWale(){
		List<AutoWala> list = new ArrayList<AutoWala>();
		
		String query = "SELECT * FROM " + TABLE_NAME;
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		
		int iId = cursor.getColumnIndex(KEY_ID);
		int iName = cursor.getColumnIndex(KEY_NAME);
		
		if(cursor.moveToFirst()){
			do {
				AutoWala autoWala = new AutoWala();
				autoWala.setId(cursor.getString(iId));
				autoWala.setName(cursor.getString(iName));
				
				list.add(autoWala);
			} while(cursor.moveToNext());
		}
		cursor.close();
		db.close();
		return list;
	}
	
	public int getAutoWaleCount() {
		String query = "SELECT * FROM " + TABLE_NAME;
		SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.close();
        db.close();
		return cursor.getCount();
	}
	
	public int updateAutoWala(AutoWala autoWala){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_ID, autoWala.getId());
		values.put(KEY_NAME, autoWala.getName());
		
		int count = db.update(TABLE_NAME, values, KEY_ID + "=?", new String[] {autoWala.getId()});
		db.close();
		return count;
	}
	
	public void deleteAutoWala(AutoWala autoWala){
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NAME, KEY_ID + "=?", new String[] {autoWala.getId()});
		db.close();
	}
}