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
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.util.Log;
import us.feras.mdv.MarkdownView;
import android.graphics.Color;

public class IndividualItemActivity extends Activity {

  final public static int POST_TYPE_CAREER = 0;
  final public static int POST_TYPE_CONTRACT = 1;
  final public static int POST_TYPE_OPEN = 2;

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
    setContentView(R.layout.detailed_markup_item);
    Intent i = this.getIntent(); 
    
    if ( i.getBooleanExtra("has_markup", false) ) {
      LinearLayout llayout = (LinearLayout) findViewById(R.id.info_layout);
      MarkdownView mdv = new MarkdownView(this);
      mdv.setBackgroundColor(Color.TRANSPARENT);
      if( llayout == null ) {
        Log.d("gun.io","Couldn't fetch layout view");
        finish();
      }
      llayout.addView(mdv, 0, new ViewGroup.LayoutParams(-1, -1));
      String mdData = i.getStringExtra("mdv_data");
      mdv.loadMarkDownData(mdData);
      return;
    }

    setContentView(R.layout.detailed_item);


    /** Assign layouts to views. */
    TextView title = (TextView)findViewById(R.id.title);
    TextView header = (TextView)findViewById(R.id.title_bar);

    TextView title2 = (TextView)findViewById(R.id.title2);

    TextView header1 = (TextView)findViewById(R.id.header1);
    TextView text1 = (TextView)findViewById(R.id.text1);

    TextView header2 = (TextView)findViewById(R.id.header2);
    TextView text2 = (TextView)findViewById(R.id.text2);

    TextView header3 = (TextView)findViewById(R.id.header3);
    TextView text3 = (TextView)findViewById(R.id.text3);

    TextView apply_button = (TextView)findViewById(R.id.apply_button);
    apply_button.setOnClickListener(new ApplyButtonListener());

    accounts = AccountManager.get(this).getAccounts();
    TextView email_button = (TextView)findViewById(R.id.remind_button);
    email_button.setOnClickListener(new EmailButtonListener());
  }

  private class EmailButtonListener implements OnClickListener {
    /* Create the Intent */
    final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

    @Override
    public void onClick(View v) {
      /* Fill intent with Data */
      emailIntent.setType("plain/text");

      String e = "";
      for (Account account : accounts) {
        String possibleEmail = account.name;
        if(possibleEmail.contains("@")) {
          e = possibleEmail;
          break;
        }
      }
    }

    private void sendEmail() {
      emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{});

      emailIntent.putExtra(
          android.content.Intent.EXTRA_SUBJECT, 
          "Remember to apply to " 
         // + title2_s 
          + "!");

      emailIntent.putExtra(
          android.content.Intent.EXTRA_TEXT,
      //    "Hey!\n\nDon't forget to apply to " + title2
      //    + "!\n\nhttp://gun.io/careers/" + id + "/" + slug 
           "\n\nLove!,\nTeam Gun.io");

      /* Send it off to the Activity-Chooser */
      startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    }
  }

  private class ApplyButtonListener implements OnClickListener{
    @Override
    public void onClick(View v) {
      Intent i = new Intent(Intent.ACTION_VIEW);
      i.setData(Uri.parse(apply_url));
      startActivity(i);
    }
  }
}
