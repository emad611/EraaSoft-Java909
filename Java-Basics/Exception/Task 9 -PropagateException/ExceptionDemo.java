package com.model.service;

public class ExceptionDemo {
    public void riskyMethod()throws Exception{
        throw new Exception("Something went wrong!");// structure --> throw + new + Exception +("الرسالة")
    }
    public void CallDemo() throws Exception{
        riskyMethod();
    }
}
