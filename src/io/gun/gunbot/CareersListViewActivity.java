package io.gun.gunbot;

import io.gun.gunbot.Careers.Career;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class CareersListViewActivity extends Activity{
    
    CareersArrayListAdapter adapter;
    ListView lv;
    ArrayList<ArrayList<HashMap<String, String>>> mal;
    Context c;
    String u;
    ImageView headerButton;
    Animation rotate;
    GetCareersDataTask getDataTask;
    
    String careersURL = "http://gun.io/secretapi/v1/careers/?format=json";
    
    View lastTouched;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.detailed_menu_list);    	
        
        TextView title = (TextView)findViewById(R.id.title_bar);
        title.setText("Gun.io - Careers");
        
        ArrayList<Career> l = new ArrayList<Career>();
        final Careers ca = new Careers();
        Career career = ca.new Career();
        career.setTitle("Loading..");
        City lo = new City();
        lo.setName("Please wait..");
        career.setCity(lo);
        career.setCompany_name("");
        l.add(career);
        ca.setObjects(l);

        //Setup the adapter views;
        adapter = new CareersArrayListAdapter(this, R.layout.list_view_row);
        adapter.setItems(ca.getCareers());
        adapter.setContext(getBaseContext());
        adapter.setParent(this);
        lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
        
        //Create an AsyncTask to update that data;
        getDataTask = new GetCareersDataTask();
        getDataTask.setContext(this);
        getDataTask.setAdapter(adapter);
        getDataTask.execute(careersURL, careersURL);
        
        final CareersListViewActivity c = CareersListViewActivity.this;
        lv.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                   final Intent i = new Intent(c, IndividualItemActivity.class);
                   Career c = ca.getCareers().get(arg2);
                   c = (Career) adapter.getCareer(arg2);
                   
                   if(c.getTitle().equals("Loading..")){
                	   return;
                   }
                   
                   i.putExtra("title", c.getTitle());
                   i.putExtra("company_name", c.getCompany_name());
                   i.putExtra("job_description", c.getJob_mkd());
                   i.putExtra("about", c.getAbout_mkd());
                   i.putExtra("skills", c.getSkills_mkd());
                   i.putExtra("apply_url", c.getHomepage());
                   i.putExtra("id", c.getId());
                   i.putExtra("slug", c.getSlug());
                   startActivity(i); 
                
            }});
        
    }
    
    public void onResume() {
        super.onResume();
        ///XXX HACK CHANGE THIS OMG
        if(lastTouched != null) {
            lastTouched.setBackgroundColor(Color.WHITE);
        }
    }

}
