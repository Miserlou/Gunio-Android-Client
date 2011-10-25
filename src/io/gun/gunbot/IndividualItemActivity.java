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
import android.widget.TextView;

public class IndividualItemActivity extends Activity {
	
	Context c;
	
	ImageButton careers;
	ImageButton contracts;
	ImageButton opensource;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.detailed_item);
        
        c = this;

        TextView title = (TextView)findViewById(R.id.title);
        String title_s = getIntent().getExtras().getString("title");
        title.setText(title_s);
        TextView header = (TextView)findViewById(R.id.title_bar);
        header.setText(title_s);
        
        TextView title2 = (TextView)findViewById(R.id.title2);
        String title2_s = getIntent().getExtras().getString("company_name");
        title2.setText(title2_s);
        
        TextView header1 = (TextView)findViewById(R.id.header1);
        header1.setText("Job Description");
        TextView text1 = (TextView)findViewById(R.id.text1);
        String text1_s = getIntent().getExtras().getString("job_description");
        if(text1_s != null && !text1_s.equals("")){
        	// genius. :(
        	text1.setText(text1_s.replace("\n\n", "SQUIRTLE").replace(" *", "BULBASAUR").replace("\n", " ").replace("SQUIRTLE", "\n\n").replace("BULBASAUR", "\n*"));
        }
        else{
        	header1.setVisibility(View.GONE);
        }
        
        TextView header2 = (TextView)findViewById(R.id.header2);
        header2.setText("Skill Requirements");
        TextView text2 = (TextView)findViewById(R.id.text2);
        String text2_s = getIntent().getExtras().getString("skills");
        if(text2_s != null && !text2_s.equals("")){
        	text2.setText(text2_s);
        }
        else{
        	header2.setVisibility(View.GONE);
        	text2.setVisibility(View.GONE);
        }
        
        TextView header3 = (TextView)findViewById(R.id.header3);
        header3.setText("About " + getIntent().getExtras().getString("company_name"));
        TextView text3 = (TextView)findViewById(R.id.text3);
        String text3_s = getIntent().getExtras().getString("about");
        if(text3_s != null && !text3_s.equals("")){
        	text3.setText(text3_s);
        }
        else{
        	header3.setVisibility(View.GONE);
        	text3.setVisibility(View.GONE);
        }
        
    }
}