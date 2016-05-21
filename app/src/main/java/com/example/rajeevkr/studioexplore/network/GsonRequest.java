package com.example.rajeevkr.studioexplore.network;

import android.support.v4.util.ArrayMap;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * BaseRequest for the app
 * Created by rajeevkr on 5/21/16.
 */

public class GsonRequest<T> extends Request<T> {
    private final Gson gson = new Gson();
    private final Class<T> mClazz;
    private final Map<String, String> headers;
    private final Response.Listener<T> mListener;

    public GsonRequest(int method, String url, Response.ErrorListener listener, Class<T> clazz, ArrayMap<String,
            String> headers, Response.Listener<T> successListener) {
        super(method, url, listener);
        mClazz = clazz;
        mListener = successListener;
        this.headers = headers;
    }


    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String data = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(gson.fromJson(data, mClazz), HttpHeaderParser.parseCacheHeaders(response));

        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
        } catch (JsonSyntaxException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {

        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(T response) {
        if (mListener != null) {
            mListener.onResponse(response);
        }
    }
}
