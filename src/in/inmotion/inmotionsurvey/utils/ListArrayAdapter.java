package in.inmotion.inmotionsurvey.utils;

import in.inmotion.inmotionsurvey.R;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListArrayAdapter extends ArrayAdapter<AutoWala> {
	
	private final Context context;
	private final List<AutoWala> autoWalas;

	public ListArrayAdapter(Context context,List<AutoWala> autoWalas) { //, int[] resId) {
		super(context, R.layout.list_row, autoWalas);
		
		this.context = context;
		this.autoWalas = autoWalas;
	}
		
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = inflater.inflate(R.layout.list_row, parent, false);;
		
		TextView nameTextView = (TextView)rowView.findViewById(R.id.list_name);
		TextView descTextView = (TextView)rowView.findViewById(R.id.list_auto);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.list_icon);
		
		AutoWala autoWala = this.autoWalas.get(position);
		if(autoWala!=null){
			nameTextView.setText(autoWala.getName());
			descTextView.setText(autoWala.getId());		
			imageView.setImageResource(R.drawable.add);
		}
		
		return rowView;
	}
}
