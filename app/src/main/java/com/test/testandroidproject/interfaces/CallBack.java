package com.test.testandroidproject.interfaces;

public interface CallBack {

    /**
     * The interface method implemented in the java files
     * @param data the result returned by the web service
     * @param tasksID the ID to differential multiple webservice calls
     * @return none
     */
    public void onResult(String data, int tasksID);
}
