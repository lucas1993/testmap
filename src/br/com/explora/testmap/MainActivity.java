package br.com.explora.testmap;

import java.util.ArrayList;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends Activity {

	// Google Map
    private GoogleMap googleMap;
    private ArrayList<MarkerTypeBean> typeArray;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        try {
            // Loading map
            initilizeMap();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        CheckBox c1 = (CheckBox) findViewById(R.id.checkbox1);        
        c1.setOnClickListener(new OnClickListener() {
        	@Override
			public void onClick(View v) {        		
       			typeArray.get(0).setVisible(((CheckBox) v).isChecked());
				
			}
        });

        CheckBox c2 = (CheckBox) findViewById(R.id.checkbox2);        
        c2.setOnClickListener(new OnClickListener() {
        	@Override
			public void onClick(View v) {        		
       			typeArray.get(1).setVisible(((CheckBox) v).isChecked());
				
			}
        });
        
        CheckBox c3 = (CheckBox) findViewById(R.id.checkbox3);        
        c3.setOnClickListener(new OnClickListener() {
        	@Override
			public void onClick(View v) {        		
       			typeArray.get(2).setVisible(((CheckBox) v).isChecked());
				
			}
        });
    }
 
    /**
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {
    	typeArray = new ArrayList<MarkerTypeBean>();
    	
    	MarkerTypeBean mrkTp = null;
    	mrkTp = MarkerTypeBean.getInstance(MarkerTypeBean.RED, "Tipo 1", 0);
    	typeArray.add(mrkTp);
    	mrkTp = MarkerTypeBean.getInstance(MarkerTypeBean.GREEN, "Tipo 2", 1);
    	typeArray.add(mrkTp);
    	mrkTp = MarkerTypeBean.getInstance(MarkerTypeBean.BLUE, "Tipo 3", 2);
    	typeArray.add(mrkTp);
    	
    	
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();
 
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            } else {
            	MarkerBean.setMap(googleMap);                       

	        	MarkerBean.insertMarker((float) -15.780, (float) -47.930, "Brasília", typeArray.get(0));       	
	        	MarkerBean.insertMarker((float) -23.5475000, (float) -46.6361100, "São Paulo", typeArray.get(1));        	
	        	MarkerBean.insertMarker((float) -22.9027800, (float) -43.2075000, "Rio de Janeiro", typeArray.get(2));  	
            }
        	
           
        }
              
        
    }
 
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
