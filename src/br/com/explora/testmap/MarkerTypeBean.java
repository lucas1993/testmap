package br.com.explora.testmap;

import android.util.Log;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class MarkerTypeBean {
	public float mColor;
	public int id;
	public String name;
	private static int idCount = 0;
	
	public static final float RED = BitmapDescriptorFactory.HUE_RED;
	public static final float GREEN = BitmapDescriptorFactory.HUE_GREEN;
	public static final float BLUE = BitmapDescriptorFactory.HUE_AZURE;
	
	private MarkerTypeBean(float color, int newId, String newName) {
		mColor = color;
		id = newId;
		name = newName;
	}
	
	public static MarkerTypeBean getInstance(float color, String newName, int id) {
		MarkerTypeBean markTp = new MarkerTypeBean(color, id, newName);
		idCount++;
		return markTp;
	}
	
	public void setVisible(boolean visible) {
		MarkerBean.hideShowByTipe(this.id, visible);		
	}	

}
