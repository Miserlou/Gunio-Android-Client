package io.gun.gunbot;

import io.gun.gunbot.Careers.Career;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.JSONException;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GetContractsDataTask extends AsyncTask<String, String, String>{
	
    String url;
    Context c;
    String resultString;
    ImageView spinner;
    Boolean finished = false;
    Contracts careers;
    String city;
    
    TextView nowPlayingContent;
    TextView title;
    TextView artist;
    
    ContractsArrayListAdapter adapter;
    
    @Override
    protected String doInBackground(String... urls) {
        resultString = Utilities.queryRESTurl(urls[0]);
        careers = Utilities.getContracts(resultString);
        //Utilities.writeStringToFile(urls[1], resultString, c);
        return null;
    }
    
    protected void onProgressUpdate(Integer... progress) {
    }

    protected void onPostExecute(String result) {
    	
    	System.out.println(careers);
    	System.out.println(careers.getTotal_count());
    	
    	adapter.setItems(careers.getContracts());
    	adapter.notifyDataSetChanged();

    } 
    
    public void setContext(Context co){
        c = co;
    }
    
    public void setSpinner(ImageView iv) {
        spinner = iv;
    }
    
    public boolean isFinished() {
        return finished;
    }

	public TextView getNowPlayingContent() {
		return nowPlayingContent;
	}

	public void setNowPlayingContent(TextView nowPlayingContent) {
		this.nowPlayingContent = nowPlayingContent;
	}

	public TextView getTitle() {
		return title;
	}

	public void setTitle(TextView title) {
		this.title = title;
	}

	public TextView getArtist() {
		return artist;
	}

	public void setArtist(TextView artist) {
		this.artist = artist;
	}

	public void setAdapter(ContractsArrayListAdapter a) {
		adapter = a;
		
	}
    
}
