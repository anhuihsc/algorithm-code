package com.hsc.study.leetcode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wansong
 */
public class Test {
    private static int x=100;
    public static int aMethod(int i)throws Exception
    {
        try{
            return i / 10;
        }
        catch (Exception ex)
        {
            throw new Exception("exception in a Method");
        } finally{
            System.out.printf("finally");
        }
    }

    public  String Test()
    {
        return "";
    }
    public static void main(String [] args)
    {
        Test.x--;
        try
        {
            aMethod(0);
        }
        catch (Exception ex)
        {
            System.out.printf("exception in main");
        }
        System.out.printf("finished");
    }
}
