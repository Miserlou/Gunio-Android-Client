package io.gun.gunbot;

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

public class FreelanceListViewActivity extends Activity {

  ContractsArrayListAdapter adapter;
  ListView lv;
  String u;
  ImageView headerButton;
  Animation rotate;
  GetContractsDataTask getDataTask;

  String careersURL = "http://gun.io/secretapi/v1/contracts/?format=json";
  // For an opensource activity all that would need to change is the URL
  //String careersURL = "http://gun.io/secretapi/v2/open/?format=json";

  View lastTouched;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.detailed_menu_list);    	

    final Context context = this;

    TextView title = (TextView)findViewById(R.id.title_bar);
    title.setText("Gun.io - Freelance Jobs");

    ArrayList<Contract> l = new ArrayList<Contract>();
    final Contracts ca = new Contracts();
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

    lv.setOnItemClickListener(new OnItemClickListener() {

      public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

        final Intent i = new Intent(context, IndividualItemActivity.class);
        Contract c = ca.getContracts().get(arg2);
        c = (Contract) adapter.getContract(arg2);

        if(c.getTitle().equals("Loading..")){
          return;
        }

        boolean hasMarkup = ((c.getRequirements_mkd() != null && c.getRequirements_mkd() != "")
          && ( c.getDescription_mkd() != null && c.getDescription_mkd() != "" ));

        if(hasMarkup) {
          i.putExtra("requirements", c.getRequirements_mkd());
          i.putExtra("proof", c.getProof_mkd());
          i.putExtra("description", c.getDescription_mkd());
        } else {
          i.putExtra("requirements", c.getRequirements());
          i.putExtra("proof", c.getProof());
          i.putExtra("description", c.getDescription());
        }
        i.putExtra("post_type", IndividualItemActivity.POST_TYPE_CONTRACT);
        i.putExtra("has_markup", hasMarkup);
        i.putExtra("title", c.getTitle());
        i.putExtra("tags", c.getTags());
        i.putExtra("date_posted", c.getDate_posted());
        i.putExtra("awarded", c.isAwarded());
        i.putExtra("date_expired", c.getDate_expired());
        i.putExtra("value", c.getValue());
        i.putExtra("apply_url", c.getProject_homepage());
        i.putExtra("id", c.getId());
        i.putExtra("slug", c.getSlug());

        startActivity(i); 

      }});
  }
}
