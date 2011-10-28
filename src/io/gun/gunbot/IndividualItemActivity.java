package io.gun.gunbot;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

	private String apply_url;

	private Account[] accounts;
	
	
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
        final String title2_s = getIntent().getExtras().getString("company_name");
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
        
        TextView apply_button = (TextView)findViewById(R.id.apply_button);
        apply_button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(apply_url));
				startActivity(i);
				
			}});
        apply_url = getIntent().getExtras().getString("apply_url");
        
        final String id = getIntent().getExtras().getString("id");
        final String slug = getIntent().getExtras().getString("slug");
        accounts = AccountManager.get(this).getAccounts();
        TextView email_button = (TextView)findViewById(R.id.remind_button);
        email_button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				/* Create the Intent */
				final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

				/* Fill it with Data */
				emailIntent.setType("plain/text");
				
				String e = "";
				for (Account account : accounts) {
					String possibleEmail = account.name;
					if(possibleEmail.contains("@")) {
						e = possibleEmail;
						break;
					}
				}
				
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{e});
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Remember to apply to " + title2_s + "!");
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey!\n\nDon't forget to apply to " + title2_s + "!\n\nhttp://gun.io/careers/" + id + "/" + slug + "\n\nLove!,\nTeam Gun.io");

				/* Send it off to the Activity-Chooser */
				startActivity(Intent.createChooser(emailIntent, "Send mail..."));
				
			}});

        
    }
}