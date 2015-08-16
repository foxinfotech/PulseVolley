package com.foxinfotech.pulsevolley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    private static final String url = "http://pulse.foxinfotechs.com/rest_web_service/pre_sign_up.json";
    ProgressDialog pDialog;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Tag used to cancel the request

        textview=(TextView)findViewById(R.id.results);
        pDialog= new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();
        makeRequest();
    }


    public void makeRequest(){
        String tag_json_obj = "json_obj_req";
        MyCustomJSONRequest jsonObjReq = new MyCustomJSONRequest(Request.Method.POST,url,PreSignUpResponseGSON.class, null, responseListener,responseErrorListener);
        Cache cache = MyAplication.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(url);
        if(entry != null){
            try {
                String data = new String(entry.data, "UTF-8");
                PreSignUpResponseGSON pjson =(PreSignUpResponseGSON)jsonObjReq.parseGsonResponse(data);
                processWebserviceResponse(pjson,true);
                // handle data, like converting it to xml, json, bitmap etc.,
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else{
            // Cached response doesn't exists. Make network call here
            // Adding request to request queue
            MyAplication.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
        }
    }

    Response.Listener responseListener=new Response.Listener() {
        @Override
        public void onResponse(Object response) {
            PreSignUpResponseGSON pjson=(PreSignUpResponseGSON)response;
            processWebserviceResponse(pjson,false);
        }
    };

    Response.ErrorListener responseErrorListener=new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    };

    public void processWebserviceResponse(PreSignUpResponseGSON object,boolean isFromCache){
       textview.setText("Network Response: "+object.getROLES().size()+"");
       pDialog.dismiss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
