package io.gun.gunbot;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.webkit.WebView;
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
    setContentView(R.layout.detailed_item);
    
    final Intent i = this.getIntent(); 
    final LinearLayout llayout = (LinearLayout) findViewById(R.id.info_layout);

    WebView wView;    // This is the view that the data is loaded into
    String data = ""; // This is the container for the data

    /**
     * This code below is sloppy, but I wanted to stick
     * with the original design of keeping a single activity to handle
     * all the data in case there were future design ideas based around
     * this. I also thought about moving code away from the onCreate
     * method but I figured it would be best not to abstract this
     * further until a final decision regarding this design is made.
     */

    final int type = i.getIntExtra("post_type", -1);
    Log.d("gun.io","Type is: "+type);
    if(type == POST_TYPE_CAREER) { // BEGIN CAREER LAYOUT
      data = "##"+i.getStringExtra("title") + "\n"
        + "###" + i.getStringExtra("company_name") + "\n"
        + "###" + i.getStringExtra("city") + "\n"
        + i.getStringExtra("about") + "\n"
        + i.getStringExtra("job_description") +"\n"
        + i.getStringExtra("skills") + "\n";

      /** If the intent contains markup data */
      /** Load the markup view */
      if ( i.getBooleanExtra("has_markup", false) ) { 
        // Prepare the markup view
        MarkdownView mdv = new MarkdownView(this);
        mdv.loadMarkDownData(data);
        wView = mdv;
      } else {
        TextView title = new TextView(this);
        TextView header = new TextView(this);
        TextView title2 =  new TextView(this);
        wView = new WebView(this);

        title.setText(i.getStringExtra("title"));
        title.setTextSize(22.0f);
        title.setTextColor(Color.BLACK);
        title.setPadding(10,0,10,10);
        llayout.addView(title, -1, -1);

        title2.setText(i.getStringExtra("company_name"));
        title2.setTextSize(20.0f);
        title2.setTextColor(Color.BLACK);
        title2.setPadding(10,0,10,10);
        llayout.addView(title2, -1, -1);

        header.setText(i.getStringExtra("city"));
        header.setTextSize(20.0f);
        header.setTextColor(Color.BLACK);
        header.setPadding(10,0,10,10);
        llayout.addView(header, -1, -1);

        wView.loadData(data, "text/html", "UTF-8");
      }
      wView.setBackgroundColor(Color.TRANSPARENT);
      llayout.addView(wView, -1, -1);

      /** Add an apply button */
      LayoutInflater inflater = this.getLayoutInflater();
      View apply_button= inflater.inflate(R.layout.apply_to_job, null);
      apply_button.setOnClickListener(new ApplyButtonListener());
      llayout.addView(apply_button, -1, -1);

      accounts = AccountManager.get(this).getAccounts();
      TextView email_button = (TextView)findViewById(R.id.remind_button);
      email_button.setOnClickListener(new EmailButtonListener());
    } // END CAREER LAYOUT
    if(type == POST_TYPE_CONTRACT) { // BEGIN CONTRACT LAYOUT

      data = "##"+i.getStringExtra("title") + "\n"
        + "###$" + i.getIntExtra("value", -1) + "\n"
        + i.getStringExtra("description") + "\n"
        + i.getStringExtra("requirements") +"\n"
        + i.getStringExtra("proof") + "\n";

      /** If the intent contains markup data */
      /** Load the markup view */
      if ( i.getBooleanExtra("has_markup", false) ) { 
        // Prepare the markup view
        MarkdownView mdv = new MarkdownView(this);
        mdv.loadMarkDownData(data);
        wView = mdv;
      } else {
        TextView title = new TextView(this);
        TextView header = new TextView(this);
        TextView title2 =  new TextView(this);
        wView = new WebView(this);

        title.setText(i.getStringExtra("title"));
        title.setTextSize(22.0f);
        title.setTextColor(Color.BLACK);
        title.setPadding(10,0,10,10);
        llayout.addView(title, -1, -1);

        title2.setText(i.getStringExtra("value"));
        title2.setTextSize(20.0f);
        title2.setTextColor(Color.BLACK);
        title2.setPadding(10,0,10,10);
        llayout.addView(title2, -1, -1);

        wView.loadData(data, "text/html", "UTF-8");
      }
      wView.setBackgroundColor(Color.TRANSPARENT);
      llayout.addView(wView, -1, -1);
    } // END CONTRACT LAYOUT
    if(type == POST_TYPE_OPEN) { // BEGIN OPEN LAYOUT
      data = "##"+i.getStringExtra("title") + "\n"
        + "###$" + i.getIntExtra("value", -1) + "\n"
        + i.getStringExtra("description") + "\n"
        + i.getStringExtra("requirements") +"\n"
        + i.getStringExtra("proof") + "\n";

      /** If the intent contains markup data */
      /** Load the markup view */
      if ( i.getBooleanExtra("has_markup", false) ) { 
        // Prepare the markup view
        MarkdownView mdv = new MarkdownView(this);
        mdv.loadMarkDownData(data);
        wView = mdv;
      } else {
        TextView title = new TextView(this);
        TextView header = new TextView(this);
        TextView title2 =  new TextView(this);
        wView = new WebView(this);

        title.setText(i.getStringExtra("title"));
        title.setTextSize(22.0f);
        title.setTextColor(Color.BLACK);
        title.setPadding(10,0,10,10);
        llayout.addView(title, -1, -1);

        title2.setText(i.getStringExtra("value"));
        title2.setTextSize(20.0f);
        title2.setTextColor(Color.BLACK);
        title2.setPadding(10,0,10,10);
        llayout.addView(title2, -1, -1);

        wView.loadData(data, "text/html", "UTF-8");
      }
      wView.setBackgroundColor(Color.TRANSPARENT);
      llayout.addView(wView, -1, -1);
    } // END OPEN LAYOUT
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
