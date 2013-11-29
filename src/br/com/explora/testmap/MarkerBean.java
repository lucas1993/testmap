package br.com.explora.testmap;

import java.util.ArrayList;

import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MarkerBean {
	private Marker mMarker;
	private MarkerTypeBean mType;
	public String title;
	private static GoogleMap mMap;
	private static ArrayList<MarkerBean> markerArray = null;
	
	private MarkerBean(Marker marker, MarkerTypeBean type, String tlt) {
		this.mMarker = marker;
		this.mType = type;
		this.title = tlt;
	}

	public static void setMap(GoogleMap map) {
		mMap = map;
	}
	
	public static Marker insertMarker(float latitude, float longitude, String title, MarkerTypeBean type) {
		if(markerArray == null) {
			markerArray = new ArrayList<MarkerBean>();			
		}
		
		if(mMap != null) { 
			Marker marker = mMap.addMarker(new MarkerOptions()
		     .position(new LatLng(latitude, longitude))
		     .title(title)
		     .icon(BitmapDescriptorFactory.defaultMarker(type.mColor)));
			
			 MarkerBean mark = new MarkerBean(marker, type, title);
			 
			 markerArray.add(mark);
			 
			 return marker;
		} else {
			return null;
		}
		
	}
	
	public Marker getMarkerOptions() {
		return mMarker;
	}
	
	public static void hideShowByTipe(int type, boolean setVisible) {
		for(MarkerBean mrkB : markerArray) {
			if(mrkB.mType.id == type) {
				mrkB.mMarker.setVisible(setVisible);
			}
		}
	}
	

}
