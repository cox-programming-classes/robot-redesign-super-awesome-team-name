package org.firstinspires.ftc.teamcode.AutonStrategies;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** Lambda Expression Syntax */
public interface IAutonomousStrategy
{
    ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    void execute();
}
