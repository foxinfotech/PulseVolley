package com.foxinfotech.pulsevolley;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created by Surender on 8/15/2015.
 */
public class MyCustomJSONRequest<T> extends JsonRequest<T> {

    private final Gson gson = new Gson();
    private final Class<T> gsonResponseClass;

    public MyCustomJSONRequest(int method, String url, Class<T> gsonResponseClass,JSONObject jsonRequest, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, (jsonRequest == null) ? null : jsonRequest.toString(),listener, errorListener);
        this.gsonResponseClass=gsonResponseClass;
   }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
            T parsedObject=(T)parseGsonResponse(jsonString);
            return Response.success(parsedObject,HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (Exception je) {
            return Response.error(new ParseError(je));
        }
    }

    public T parseGsonResponse(String jsonString){
        T parsedObject=null;
        try {
            JSONObject jsonResponse = new JSONObject(jsonString).getJSONObject("RESPONSE");
            parsedObject = gson.fromJson(jsonResponse.toString(), gsonResponseClass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parsedObject;
    }

}
