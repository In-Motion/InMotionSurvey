package in.inmotion.inmotionsurvey;

import in.inmotion.inmotionsurvey.utils.AutoWala;
import in.inmotion.inmotionsurvey.utils.DatabaseHandler;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InfoFragment extends Fragment{

	
	
	private View rootView;
	private TextView name, age, autoNumber, contact;
	private TextView education, experience, income, address, owner, camp;
	private String id;
	
	public InfoFragment() {
		// do nothing
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {		
		
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		DatabaseHandler db = new DatabaseHandler(getActivity());		
		
		rootView = inflater.inflate(R.layout.fragment_info, container, false);
		Bundle bundle = this.getArguments();
		if(bundle!=null){
			this.id = bundle.getString("ID");
			Log.v("ID", id);
		}
		AutoWala autoWala = db.getAutoWala(id);
		
		name = (TextView) rootView.findViewById(R.id.tv_in_name);
		age = (TextView) rootView.findViewById(R.id.tv_in_age);
		autoNumber = (TextView) rootView.findViewById(R.id.tv_in_auto_number);
		contact = (TextView) rootView.findViewById(R.id.tv_in_contact);
		education = (TextView) rootView.findViewById(R.id.tv_in_education);
		experience = (TextView) rootView.findViewById(R.id.tv_in_exp);
		income = (TextView) rootView.findViewById(R.id.tv_in_income);
		address = (TextView) rootView.findViewById(R.id.tv_in_address);
		owner = (TextView) rootView.findViewById(R.id.tv_in_owners_name);
		camp =  (TextView) rootView.findViewById(R.id.tv_in_camp);
		
		name.setText(autoWala.getName());
		age.setText(autoWala.getAge());
		autoNumber.setText(autoWala.getAutoNumber());
		contact.setText(autoWala.getContact());
		education.setText(autoWala.getEducation());
		experience.setText(autoWala.getExperience());
		income.setText(autoWala.getIncome());
		address.setText(autoWala.getAddress());
		owner.setText(autoWala.getOwner());
		camp.setText(autoWala.getCampaign()) ;

		return rootView;
	}
}
