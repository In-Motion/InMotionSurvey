package in.inmotion.inmotionsurvey;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridDashboardFragment extends Fragment {
	
	private View rootView;
	GridView dashBoard;
	
	public GridDashboardFragment() {
		//
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.fragment_dasboard, container, false);
		
		dashBoard = (GridView)rootView.findViewById(R.id.dashboard_grid);
        dashBoard.setAdapter(new ImageAdapter(getActivity()));
        dashBoard.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int pos,
					long id) {
				activityHandler(pos);				
			}
		});
 
		return rootView;
	}
		
	 
	private class ImageAdapter extends BaseAdapter {
	    private Context mContext;
	 
	    // Keep all Images in array
	    public Integer[] mThumbIds = {
	            R.drawable.ic_launcher, 
	            R.drawable.ic_launcher, 
	            R.drawable.ic_launcher, 
	            R.drawable.ic_launcher, 
	            R.drawable.ic_launcher, 	            
	    };
	 
	    // Constructor
	    public ImageAdapter(Context c){
	        mContext = c;
	    }
	 
	    @Override
	    public int getCount() {
	        return mThumbIds.length;
	    }
	 
	    @Override
	    public Object getItem(int position) {
	        return mThumbIds[position];
	    }
	 
	    @Override
	    public long getItemId(int position) {
	        return 0;
	    }
	 
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	    	
	        ImageView imageView = new ImageView(mContext);
	        imageView.setImageResource(mThumbIds[position]);
	        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	        imageView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT,GridView.AUTO_FIT));
	        return imageView;
	    }	 
	}
	
	private void activityHandler(int item){
		
		Intent intent = null;
		switch (item) {
		case 0:
//			intent = new Intent(getActivity(),InsertActivity.class); 
			break;
		case 1:
//			intent = new Intent(getActivity(),ShowActivity.class); 
			break;

		default:
			break;
		}
		
		startActivity(intent);
	}
}