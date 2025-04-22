package org.firstinspires.ftc.teamcode.Extensions;

public class ThreadExtensions
{
    public static boolean TrySleep(long millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {
            return false;
        }
        return true;
    }
}
