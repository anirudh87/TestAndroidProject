package com.test.testandroidproject.managers;

import android.content.Context;

import com.test.testandroidproject.async.GetWebServiceData;
import com.test.testandroidproject.interfaces.CallBack;


public class CommunicationManager {

    private Context context;

    GetWebServiceData gwsdObj;

    /**
     * Constructor
     * @param contextObj  The Context from where the method is called
     * @return none
     */

    public CommunicationManager(Context contextObj) {
        this.context = contextObj;
    }

    /**
     * Call the required web service based on the URL
     * @param contextObj The Context from where the method is called
     * @param Url Web Service URL to be called
     * @param listnerObj object of interface CallBack
     * @param tasksID the ID to differential multiple webservice calls
     * @return none
     */
    public void CallWebService(Context contextObj, String Url, CallBack listnerObj, int tasksID)
    {
        gwsdObj = new GetWebServiceData(contextObj, Url, listnerObj, tasksID);
        gwsdObj.execute();
    }

    public void CancelWebServiceCall() {
        if(!gwsdObj.isCancelled()) {
            gwsdObj.cancel(true);
        }
    }
    
    
}
