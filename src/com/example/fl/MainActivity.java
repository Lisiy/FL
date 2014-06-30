package com.example.fl;

import android.support.v7.app.ActionBarActivity;
import android.app.Fragment;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity {

	
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
    
    public void ToggleFlash(View v)
    {
    	Camera cam = Camera.open();
        if (cam == null) return;
        Parameters p = cam.getParameters();
        
    	ToggleButton button = (ToggleButton)findViewById(R.id.FlashToggle);
    	if (button.isChecked())
    	{
    		Log.i("FL", "Button is checked, flashlight on");
    		p.setFlashMode(Parameters.FLASH_MODE_TORCH);
    	}
    	else 
    	{
    		Log.i("FL", "Button is not checked, flashlight off");
    		p.setFlashMode(Parameters.FLASH_MODE_OFF);
    	}
     
    	cam.setParameters(p);
    	cam.startPreview();
    }


}