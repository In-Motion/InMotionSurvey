package in.inmotion.inmotionsurvey;

import in.inmotion.inmotionsurvey.utils.AutoWala;
import in.inmotion.inmotionsurvey.utils.DatabaseHandler;
import in.inmotion.inmotionsurvey.utils.ListArrayAdapter;

import java.util.List;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ViewFragment extends ListFragment {
	
	private List<AutoWala> autoWalas; 
	ListArrayAdapter mAdapter;
	
	public ViewFragment() {
		//
	}	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setHasOptionsMenu(true);
	}



	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);
		DatabaseHandler db = new DatabaseHandler(getActivity());
		
		this.autoWalas = db.getAllAutoWale();
		
		mAdapter = new ListArrayAdapter(getActivity(), autoWalas);
		setListAdapter(mAdapter);
		registerForContextMenu(getListView());
	}



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		View rootView = inflater.inflate(R.layout.fragment_view, container, false);
		
		return rootView;
	}

	@Override
	public void onListItemClick(ListView listView, View view, int position, long id) {
		super.onListItemClick(listView, view, position, id);
		
		AutoWala autoWala = this.autoWalas.get(position);
		InfoFragment fragment = new InfoFragment();
		Bundle bundle = new Bundle();
		
		bundle.putString("ID", autoWala.getId());
		fragment.setArguments(bundle);
		
		final FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.container, fragment);
		ft.addToBackStack(null);
		ft.commit();
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("Baka");
		menu.add(0, v.getId(), 0, "delete");
		menu.add(0, v.getId(), 0, "SO da");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		
		Toast.makeText(getActivity(), item.getItemId()+" "+info.position, Toast.LENGTH_SHORT).show();
		
		if(item.getTitle().equals("delete")){
			DatabaseHandler db = new DatabaseHandler(getActivity());
			AutoWala autoWala = this.autoWalas.get(info.position);
			db.deleteAutoWala(autoWala);
			mAdapter.remove(autoWala);
			mAdapter.notifyDataSetChanged();
		} else {
			
		}
		
		return super.onContextItemSelected(item);
	}
		 
    @Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.main, menu);
	}

	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.menu_add) {
        	getFragmentManager().beginTransaction()
            .add(R.id.container, new AddFragment())
            .commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
	
}
