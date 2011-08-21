package io.gun.gunbot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageButton;

public class MainMenuActivity extends Activity {
	
	Context c;
	
	ImageButton careers;
	ImageButton contracts;
	ImageButton opensource;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        
        c = this;
        
        careers = (ImageButton)findViewById(R.id.careers);
        contracts = (ImageButton)findViewById(R.id.contracts);
        opensource = (ImageButton)findViewById(R.id.opensource);
        
        careers.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				careers.setImageResource(R.drawable.careersblur);
				contracts.setImageResource(R.drawable.contracts);
				opensource.setImageResource(R.drawable.opensource);
				
                Intent i = new Intent(c, CareersListViewActivity.class);
                startActivity(i);
                
			}});
        contracts.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				contracts.setImageResource(R.drawable.contractsblur);
				careers.setImageResource(R.drawable.careers);
				opensource.setImageResource(R.drawable.opensource);
			}});
        opensource.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				opensource.setImageResource(R.drawable.opensourceblur);
				careers.setImageResource(R.drawable.careers);
				contracts.setImageResource(R.drawable.contracts);
			}});
        

        careers.setOnFocusChangeListener(new OnFocusChangeListener(){

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					careers.setImageResource(R.drawable.careersblur);
					contracts.setImageResource(R.drawable.contracts);
					opensource.setImageResource(R.drawable.opensource);
				}
				else{
					careers.setImageResource(R.drawable.careers);
					contracts.setImageResource(R.drawable.contracts);
					opensource.setImageResource(R.drawable.opensource);
				}
				
			}});
        contracts.setOnFocusChangeListener(new OnFocusChangeListener(){

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					careers.setImageResource(R.drawable.careers);
					contracts.setImageResource(R.drawable.contractsblur);
					opensource.setImageResource(R.drawable.opensource);
				}
				else{
					careers.setImageResource(R.drawable.careers);
					contracts.setImageResource(R.drawable.contracts);
					opensource.setImageResource(R.drawable.opensource);
				}
				
			}});
        opensource.setOnFocusChangeListener(new OnFocusChangeListener(){

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					careers.setImageResource(R.drawable.careers);
					contracts.setImageResource(R.drawable.contracts);
					opensource.setImageResource(R.drawable.opensourceblur);
				}
				else{
					careers.setImageResource(R.drawable.careers);
					contracts.setImageResource(R.drawable.contracts);
					opensource.setImageResource(R.drawable.opensource);
				}
				
			}});
        
        
    }
}