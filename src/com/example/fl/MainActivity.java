package com.example.fl;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public boolean ClickOnShowAds(MenuItem item) {
		return false; 
    }

    
    public void ToggleFlash(View v)
    {
    	ToggleButton button = (ToggleButton)findViewById(R.id.FlashToggle);
    	Camera cam = null;
    	try {
    	cam = Camera.open();
    	}
    	catch (RuntimeException e)
    	{
    		Log.e("FL", "No camera on the device - can not open camera");
    	}
    	
        if (cam == null){
        	Log.e("FL", "No camera on the device");
        	button.setClickable(false);
        	return;
        }
        Parameters p = cam.getParameters();
        
    	
    	if (button.isChecked())
    	{
    		Log.i("FL", "Button is checked, flashlight on");
    		p.setFlashMode(Parameters.FLASH_MODE_TORCH);
        	cam.setParameters(p);
        	cam.startPreview();
    	}
    	else 
    	{
    		Log.i("FL", "Button is not checked, flashlight off");
    		cam.stopPreview();
    	}
     
    	
    }


    
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            {
             Intent myIntent = new Intent(this, Preferences.class);
             startActivity(myIntent);
            }

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
        
}