package org.firstinspires.ftc.teamcode.Extensions;

public class ThreadExtensions {
    public static boolean TrySleep(long milliseconds) {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e)
        {
            return false;
        }
        return true;
    }
}
