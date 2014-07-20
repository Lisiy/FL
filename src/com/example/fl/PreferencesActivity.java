package com.example.fl;

import android.app.Activity;
import android.os.Bundle;

public class PreferencesActivity extends Activity {
    
    private SettingsFragment fragment;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment = new SettingsFragment();
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, fragment)
                .commit();
    }
    
    protected void onUpdate() {

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, fragment)
                .commit();
    }
    
    @Override
    public void onBackPressed() {
    	// TODO Auto-generated method stub
    	getFragmentManager().beginTransaction().detach(fragment).commit();
    	super.onBackPressed();
    }


}

