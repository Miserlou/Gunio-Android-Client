package io.gun.gunbot;

import io.gun.gunbot.Careers.Career;
import io.gun.gunbot.Contracts.Contract;

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

public class FreelanceListViewActivity extends Activity{
    
    ContractsArrayListAdapter adapter;
    ListView lv;
    ArrayList<ArrayList<HashMap<String, String>>> mal;
    Context c;
    String u;
    ImageView headerButton;
    Animation rotate;
    GetContractsDataTask getDataTask;
    
    String careersURL = "http://gun.io/secretapi/v1/contracts/?format=json";
    
    View lastTouched;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.detailed_menu_list);    	
        
        TextView title = (TextView)findViewById(R.id.title_bar);
        title.setText("Gun.io - Freelance Jobs");
        
        ArrayList<Contract> l = new ArrayList<Contract>();
        Contracts ca = new Contracts();
        Contract contract = ca.new Contract();
        contract.setTitle("Loading..");
        contract.setValue(-1);
        l.add(contract);
        ca.setObjects(l);

        //Setup the adapter views;
        adapter = new ContractsArrayListAdapter(this, R.layout.list_view_row);
        adapter.setItems(ca.getContracts());
        adapter.setContext(getBaseContext());
        adapter.setParent(this);
        lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
        
        //Create an AsyncTask to update that data;
        getDataTask = new GetContractsDataTask();
        getDataTask.setContext(this);
        getDataTask.setAdapter(adapter);
        getDataTask.execute(careersURL, careersURL);
        
        final FreelanceListViewActivity c = FreelanceListViewActivity.this;
        lv.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ArrayList<HashMap<String, String>> in = mal.get(arg2);
                HashMap<String, String> shmap = in.get(0);
 
                if(shmap.containsKey("head") && shmap.get("head").equals("true")) {
                    //fuck
                }

                
            }});
        
    }
    
}
