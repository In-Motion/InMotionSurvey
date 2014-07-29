package in.inmotion.inmotionsurvey;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private static final String IM_SURVEY = "";
	public static String user;
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        preferences = getSharedPreferences(IM_SURVEY, Activity.MODE_PRIVATE);
        editor = preferences.edit();
        user = preferences.getString("USER", "");
        if(user.equals("")){
        	addUser();
        }
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ViewFragment())
                    .commit();
        }
    }
    
    public void addUser(){
    	final View dialogView = getLayoutInflater().inflate(R.layout.dialog_user, null);
    	
    	new AlertDialog.Builder(MainActivity.this)
    		.setTitle("Add UID")
    		.setView(dialogView)
    		.setNeutralButton("OK", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					EditText uid = (EditText) dialogView.findViewById(R.id.et_uid);
					user = uid.getText().toString();
					editor.putString("USER", user);
					editor.commit();
				}
			})
			.show();
    }
    
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.menu_add) {
//        	getFragmentManager().beginTransaction()
//            .add(R.id.container, new AddFragment())
//            .commit();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }    

}
