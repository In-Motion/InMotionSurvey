package in.inmotion.inmotionsurvey;

import in.inmotion.inmotionsurvey.utils.AutoWala;
import in.inmotion.inmotionsurvey.utils.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class AddFragment extends Fragment{
	
	private static final int IMAGE_REQUEST = 1;  
	
	private View rootView;
	
	private ViewFlipper flipper;
	//Buttons
	private Button nextButton, prevButton, saveButton;
	//View 1
	private ImageView picView;
	private EditText adNoText, campText, nameText, ageText, autoNoText, contactText;
	//View 2
	private EditText addressText, eduText, expText, incomeText; //, boysText, girlsText;
	private Button addChildButton, removeChildButton;
	//View 3
	private EditText ownerText, ownerAddText, ownerContactText, refText;
	//View 4
	private CheckBox accountBox, insuranceBox, photoBox, adBox, tobaccoBox;
	
	private GestureDetector mDetector;
	private List<EditText> childrenAgeList;
	private List<RadioGroup> childrenSexList;
	
	private int id = 0;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(false);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		rootView = inflater.inflate(R.layout.fragment_add, container, false);
		
		Toast.makeText(getActivity(), MainActivity.user, Toast.LENGTH_LONG).show();
		initControls();	
		setEventHandlers();
		
		return rootView;
	}
	
	private void initControls(){
		
		flipper = (ViewFlipper) rootView.findViewById(R.id.flipper);
		
		nextButton = (Button) rootView.findViewById(R.id.btn_nxt);
		prevButton = (Button) rootView.findViewById(R.id.btn_prev);
		saveButton = (Button) rootView.findViewById(R.id.btn_save);
		
		picView = (ImageView) rootView.findViewById(R.id.iv_add_pic);
		adNoText = (EditText) rootView.findViewById(R.id.et_ad_no);
		campText = (EditText) rootView.findViewById(R.id.et_camp);
		nameText = (EditText) rootView.findViewById(R.id.et_name);
		ageText = (EditText) rootView.findViewById(R.id.et_age);
		autoNoText = (EditText) rootView.findViewById(R.id.et_auto_num);
		contactText = (EditText) rootView.findViewById(R.id.et_phone);
		
		eduText = (EditText) rootView.findViewById(R.id.et_edu);
		expText = (EditText) rootView.findViewById(R.id.et_driving);
		incomeText = (EditText) rootView.findViewById(R.id.et_income);
		addressText = (EditText) rootView.findViewById(R.id.et_add);
		addChildButton = (Button) rootView.findViewById(R.id.btn_add_child);
		removeChildButton = (Button) rootView.findViewById(R.id.btn_remove_child);
		
		ownerText = (EditText) rootView.findViewById(R.id.et_owner_name);
		ownerAddText = (EditText) rootView.findViewById(R.id.et_owner_address);
		ownerContactText = (EditText) rootView.findViewById(R.id.et_owner_phone);
		refText = (EditText) rootView.findViewById(R.id.et_ref);
		
		accountBox = (CheckBox) rootView.findViewById(R.id.cb_account);
		insuranceBox = (CheckBox) rootView.findViewById(R.id.cb_insuarance);
		photoBox = (CheckBox) rootView.findViewById(R.id.cb_photo);
		adBox = (CheckBox) rootView.findViewById(R.id.cb_ad);
		tobaccoBox = (CheckBox) rootView.findViewById(R.id.cb_tobacco);
		
		mDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                float velocityY) {
                final int SWIPE_MIN_DISTANCE = 120;
                final int SWIPE_MAX_OFF_PATH = 250;
                final int SWIPE_THRESHOLD_VELOCITY = 200;
                try {
                    if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                        return false;
                    if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                        if (flipper.getDisplayedChild() != 3) {							
							flipper.setInAnimation(getActivity(), R.anim.in_right);
							flipper.setOutAnimation(getActivity(), R.anim.out_left);
							flipper.showNext();
                        }
                    } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                        if (flipper.getDisplayedChild() != 0){							
							flipper.setInAnimation(getActivity(), R.anim.in_left);
							flipper.setOutAnimation(getActivity(), R.anim.out_right);
							flipper.showPrevious();
                        }
                    }
                } catch (Exception e) {
                    // do nothing
                }	
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
		
		childrenAgeList = new ArrayList<EditText>();
		childrenSexList = new ArrayList<RadioGroup>();
	}
	
	private void setEventHandlers(){
		rootView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return mDetector.onTouchEvent(event);
			}
		});
		picView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
			}
		});
		nextButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(flipper.getDisplayedChild() != 3) {
					flipper.setInAnimation(getActivity(), R.anim.in_right);
					flipper.setOutAnimation(getActivity(), R.anim.out_left);
					flipper.showNext();
				}
			}
		});
		prevButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (flipper.getDisplayedChild() != 0) {	
					flipper.setInAnimation(getActivity(), R.anim.in_left);
					flipper.setOutAnimation(getActivity(), R.anim.out_right);
					flipper.showPrevious();
				}
			}
		});
		addChildButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				addChildView();
			}
		});
		removeChildButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				removeChildView();
			}
		});
		
		saveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {				
				if(isValid()){
					AutoWala autoWala = new AutoWala();
					autoWala.setId(MainActivity.user + "_" + System.currentTimeMillis()/1000);
					autoWala.setName(nameText.getText().toString());
					autoWala.setAddress(addressText.getText().toString());
					autoWala.setContact(contactText.getText().toString());
					autoWala.setAge(ageText.getText().toString());
					autoWala.setAutoNumber(autoNoText.getText().toString());
					autoWala.setEducation(eduText.getText().toString());
					autoWala.setExperience(expText.getText().toString());
					autoWala.setIncome(incomeText.getText().toString());
//					autoWala.setBoys(boysText.getText().toString());
//					autoWala.setGirls(girlsText.getText().toString());7
					autoWala.setOwner(ownerText.getText().toString());
					autoWala.setOwnerAddress(ownerAddText.getText().toString());
					autoWala.setOwnerContact(ownerContactText.getText().toString());
					autoWala.setAccountState(String.valueOf(accountBox.isChecked()));
					autoWala.setInsuranceState(String.valueOf(insuranceBox.isChecked()));
					autoWala.setPhotoState(String.valueOf(photoBox.isChecked()));
					autoWala.setAdState(String.valueOf(adBox.isChecked()));
					autoWala.setTobaccoState(String.valueOf(tobaccoBox.isChecked()));
					autoWala.setReferences(refText.getText().toString());
					autoWala.setCampaign(campText.getText().toString());
					autoWala.setAdNumber(adNoText.getText().toString());
					
					DatabaseHandler db = new DatabaseHandler(getActivity());
					db.addAutoWala(autoWala);
					Log.d("Inserted", autoWala.getName()+autoWala.getAutoNumber());
					
					for(int i=0; i<childrenAgeList.size(); i++) {
						Log.d("AGE ", i+ " "+childrenAgeList.get(i).getText().toString());
						RadioGroup rg1 = childrenSexList.get(i);
						int id= rg1.getCheckedRadioButtonId();
					    View radioButton = rg1.findViewById(id);
					    int radioId = rg1.indexOfChild(radioButton);
					    RadioButton btn = (RadioButton) rg1.getChildAt(radioId);
					    String selection = (String) btn.getText();
						Log.d("SEX ", i+ " "+selection);
					}
//					getActivity().getFragmentManager().beginTransaction().remove(AddFragment.this).commit();
					getFragmentManager().beginTransaction()
		            .replace(R.id.container, new ViewFragment())
//		            .addToBackStack("view_add")
		            .commit();
				} else {
					// invalid >_<		
				}
			}
		});		
	}
	private void addChildView() {
		final LinearLayout layout = (LinearLayout) getActivity().findViewById(R.id.kidsLayout);
		
		LinearLayout li=new LinearLayout(getActivity());
		EditText et=new EditText(getActivity());
		RadioGroup group = new RadioGroup(getActivity());
		RadioButton boy = new RadioButton(getActivity());
		RadioButton girl = new RadioButton(getActivity());
		
		et.setHint("Child's Age");
		et.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
		et.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		
		boy.setText("Boy");		
		girl.setText("Girl");
		
		group.addView(boy);
		group.addView(girl);
		group.check(boy.getId());
		group.setOrientation(RadioGroup.HORIZONTAL);
		
		li.addView(group);
		li.addView(et);
		li.setId(id++);
		
		childrenAgeList.add(et);
		childrenSexList.add(group);
		
		layout.addView(li);
	}
	private void removeChildView() {
		final LinearLayout layout = (LinearLayout) getActivity().findViewById(R.id.kidsLayout);			
		int last = layout.getChildCount()-1;
		if(last!=0){
			layout.removeViews(last, 1);
			--id;
		}		
	}
	private boolean isValid(){
		if(nameText.getText().toString().equals(""))
			return false;	
		return true;
	}
}
