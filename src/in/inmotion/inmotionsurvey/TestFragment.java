package in.inmotion.inmotionsurvey;

import java.util.List;

import in.inmotion.inmotionsurvey.utils.AutoWala;
import in.inmotion.inmotionsurvey.utils.DatabaseHandler;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TestFragment extends Fragment{
	public TestFragment() {
		// do nothing
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_main, container, false);

		DatabaseHandler db = new DatabaseHandler(getActivity());
		
		// Inserting Contacts
		Log.d("Insert: ", "Inserting .."); 
//		db.addAutoWala(new AutoWala("Ravi", "9100000000"));        
//		db.addAutoWala(new AutoWala("Srinivas", "9199999999"));
//		db.addAutoWala(new AutoWala("Tommy", "9522222222"));
//		db.addAutoWala(new AutoWala("Karthik", "9533333333"));

		// Reading all contacts
		Log.d("Reading: ", "Reading all contacts.."); 
		List<AutoWala> autoWala = db.getAllAutoWale();       

		for (AutoWala cn : autoWala) {
			String log = "Id: "+cn.getId()+" ,Name: " + cn.getName();
			// Writing Contacts to log
			Log.d("Name: ", log);

		}
		return rootView;

	}
}