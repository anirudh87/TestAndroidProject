package com.test.testandroidproject.async;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.test.testandroidproject.interfaces.CallBack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class GetWebServiceData extends AsyncTask<String, Void, String> {

    String url;
    Context context;
    CallBack callbackObj;

    int tasksID;

    /**
     * Constructor
     *
     * @param contextObj The Context from where the method is called
     * @param Url        Web Service URL to be called
     * @param listnerObj object of interface CallBack
     * @param tasksID    the ID to differential multiple webservice calls
     */

    public GetWebServiceData(Context contextObj, String Url, CallBack listnerObj, int tasksID) {
        this.context = contextObj;
        this.url = Url;
        this.callbackObj = listnerObj;
        this.tasksID = tasksID;
    }

    /**
     * The method executes before the background processing starts and
     * shows the loader in case its visibility is set as true
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected String doInBackground(String... params) {
        InputStream inStream = openHttpConnection(this.url);
        String result = null;
        try {
            if (inStream != null) {
                result = convertInputStreamToString(inStream);
            }
        } catch (Exception e) {
            Log.e("Error", "Conversion error in Input Stream");
        }
        return result;
    }

    private InputStream openHttpConnection(String urlStr) {
        InputStream in;
        try {
            URL url = new URL(urlStr);
            URLConnection urlConnection = url.openConnection();
            in = urlConnection.getInputStream();
            return in;
        } catch (MalformedURLException e) {
            Log.e("MalformedURLException", ">" + e);
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("IOException", ">" + e);
            e.printStackTrace();
        } catch (Exception e) {
            Log.e("Exception", ">" + e);
            e.printStackTrace();
        }
        return null;
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        String result = "";
        while ((line = bufferedReader.readLine()) != null) {
            result += line;
        }

        /* Close Stream */
        if (inputStream != null) {
            inputStream.close();
        }
        return result;
    }

    /**
     * The method executes after the background processing ends
     *
     * @param result the parsed string output from the provided URL
     */

    @Override
    protected void onPostExecute(String result) {

        callbackObj.onResult(result, tasksID);
    }
}
