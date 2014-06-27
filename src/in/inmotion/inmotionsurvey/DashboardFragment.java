package in.inmotion.inmotionsurvey;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DashboardFragment extends Fragment{
	
	private View rootView;
	
	private ImageView addButton;
	private ImageView viewButton;
	
	public DashboardFragment() {
		//
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		rootView = inflater.inflate(R.layout.fragment_main, container, false);
		
		addButton = (ImageView) rootView.findViewById(R.id.iv_add);
		addButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final FragmentTransaction ft = getFragmentManager().beginTransaction();
				ft.replace(R.id.container, new AddFragment());
				ft.addToBackStack(null);
				ft.commit();
			}
		});
		viewButton = (ImageView) rootView.findViewById(R.id.iv_list);
		viewButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final FragmentTransaction ft = getFragmentManager().beginTransaction();
				ft.replace(R.id.container, new ViewFragment());
				ft.addToBackStack(null);
				ft.commit();
			}
		});
		return rootView;
	}
	
	
}
