package io.gun.gunbot;

import io.gun.gunbot.Contracts.Contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContractsArrayListAdapter extends ArrayAdapter{

    public ContractsArrayListAdapter(Context c, int i) {
        super(c, i);
        r = c.getResources();
        rightArrow = r.getDrawable(R.drawable.rightarrow);
        smRightArrow = r.getDrawable(R.drawable.sm_rightarrow);
    }

    List<Contract> items;
    Context c;
    Activity parentActivity;
    Resources r;
    Drawable rightArrow;
    Drawable smRightArrow;

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        
        if(convertView == null) {

            LayoutInflater inflater = parentActivity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_view_row, null);
            
            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.toptext);
            holder.desc = (TextView) convertView.findViewById(R.id.bottomtext);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Bind the data efficiently with the holder.
        if(items.size() <= 0) {
            convertView.setVisibility(View.GONE);
            LinearLayout ll = (LinearLayout) convertView.findViewById(R.id.rsmr_ll);
            ll.setVisibility(View.GONE);
            return convertView;
        }
        Contract r = items.get(position);
        holder.text.setText(r.getTitle());
        String d;
        if(r.getValue() == -1){
        	d= "Please wait..";
        }
        else{
        	d = "$" + r.getValue() + ". Posted by " + r.getUser().getUsername() +".";
        }

        if(d != null && d != "null") {
            holder.desc.setText(d);
        }
        else {
            holder.desc.setText("No description available");
        }

            LinearLayout ll = (LinearLayout) convertView.findViewById(R.id.rsmr_ll);
            holder.text.setTextColor(Color.parseColor("#111111"));
            holder.desc.setVisibility(View.VISIBLE);
            ll.setBackgroundColor(Color.WHITE);
            holder.text.setCompoundDrawablesWithIntrinsicBounds(null, null, smRightArrow, null);
        
        return convertView;
    }
    
      public void setContext(Context co) {
      c = co;
    }
      
   public void setParent(Activity a) {
       parentActivity = a;
   }
   
   public void setItems(List<Contract> al) {
       if(items == null) {
           items = al;
       }
       else {
           items.clear();
           Iterator i = al.iterator();
           while(i.hasNext()) {
               items.add((Contract) i.next());
           }
       }
   }
   
   private class ViewHolder {
       TextView text;
       TextView desc;
   }

public int getCount() {
    return items.size();
}

public Contract getContract(int i){
  return items.get(i);
}

public long getItemId(int position) {
    return 0;
}

}
