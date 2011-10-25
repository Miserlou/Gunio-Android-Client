package io.gun.gunbot;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpParams;

import com.google.gson.Gson;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

public class Utilities {
    
    public static String queryRESTurl(String url) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        System.out.println(url);
        HttpResponse response;
        
        try {
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                String result = convertStreamToString(instream);
                instream.close();
                return result;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    public static String convertStreamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
 
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    
    public static void writeStringToFile(String filename, String contents, Context c) {
        System.out.println("Writing to local file: " + filename); 
        
        // Something's gone wrong.
        if(contents == null || contents == "")
            return;
        
        try
        {
            FileOutputStream fos = c.openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(contents.getBytes());
            fos.close();
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace(); 
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
         
    }
    
    public static String readStringFromFile(String filename, Context c) {
        System.out.println("Reading from local file: " + filename); 
        InputStream fis;
        try {
            fis = c.openFileInput(filename);
        } catch (FileNotFoundException e) {
            // File doesn't exist (first time view is rendered - use local copy.)
            AssetManager am = c.getAssets();
            try {
                fis = am.open(filename);
            } catch (IOException e1) {
                //Something had gone disasterously wrong.
                e1.printStackTrace();
                return "";
            }
        }
        DataInputStream dis = new DataInputStream(fis);
        String ret = "";
        String strline = "";
        try {
            while((strline = dis.readLine()) != null) {
                ret = ret + strline;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return ret;
    }
    
    public static String cleanString(String in) { 
        in = in.replaceAll("&nbsp;", " "); 
          in = in.replaceAll("&#8217;", "'"); 
          in = in.replaceAll("&#39;", "'");
          in = in.replaceAll("\\\\r", " "); 
          in = in.replaceAll("\\\\", ""); 
          return in; 
      }
    
    public static String getMonthFromString(String in) {
        String month = "invalid";
        int m = Integer.parseInt(in);
        m--;
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (m >= 0 && m <= 11 ) {
            month = months[m];
        }
        return month;
    }
    
    public static String monthFromDateString(String d) { 
        String date_pieces[] = d.split("[-T]"); 
        return date_pieces[1]; 
    }
    
    public static String dayFromDateString(String d) { 
        String date_pieces[] = d.split("[-T]"); 
        return date_pieces[2]; 
    }
    
    public static String getHourFromTimestamp(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
        try {
            Date d = formatter.parse(s);
            int hr = d.getHours();
            String am = "AM";
            if(hr > 12) {
                hr = hr-12;
                am = "PM";
            }
            String mins = new Integer(d.getMinutes()).toString();
            if(mins.equals("0")) {
                mins = "00";
            }
            return new Integer(hr).toString() + ":" + mins + am;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return "0";
    }
    
    public static String getHourFromTimestampWithoutZ(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        try {
            Date d = formatter.parse(s);
            int hr = d.getHours();
            String am = "AM";
            if(hr > 12) {
                hr = hr-12;
                am = "PM";
            }
            String mins = new Integer(d.getMinutes()).toString();
            
            if(mins.length() == 1) {
                mins = "0" + mins;
            }
            return new Integer(hr).toString() + ":" + mins + am;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return "0";
    }

    public final static String encodeStringForWebView(String html) {
                StringBuilder buf = new StringBuilder(html.length());
                for (char c : html.toCharArray()) {
                    switch (c) {
//                      case '#':  buf.append("%23"); break;
//                      case '%':  buf.append("%25"); break;
//                      case '\'': buf.append("%27"); break;
//                      case '?':  buf.append("%3f"); break;    
//                      case '\\': buf.append(" "); break; 
                      case '\n': buf.append(" "); break; 
                      case '\r': buf.append(" "); break; 
                      case ';': buf.append(","); break; 
                      case '"': buf.append("'"); break; 
                      default:
                        buf.append(c);
                        break;
                    }
                }
                return buf.toString();
        }
    
    public static Careers getCareers(String json){
    	return new Gson().fromJson(json, Careers.class);
    }
    public static Contracts getContracts(String json){
    	return new Gson().fromJson(json, Contracts.class);
    }
    public static City getCity(String json){
    	return new Gson().fromJson(json, City.class);
    }
    
//    PUBLIC STATIC LIST<EVENT> GETEVENTS(STRING JSON){
//    	TYPE LISTTYPE = NEW TYPETOKEN<LIST<EVENT>>() {}.GETTYPE(); 
//    	RETURN NEW GSON().FROMJSON(JSON, LISTTYPE);
//    }
    
    public static String sanitize(String ess){
    	return android.text.Html.fromHtml(ess).toString();
    }
    

}
