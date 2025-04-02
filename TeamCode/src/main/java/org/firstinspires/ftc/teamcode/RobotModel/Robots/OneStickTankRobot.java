package org.firstinspires.ftc.teamcode.RobotModel.Robots;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotModel.DriveTrain.OneStickTank;
import org.firstinspires.ftc.teamcode.RobotModel.Mechs.ExampleIntakeAssembly;

public class OneStickTankRobot extends Robot
{
    public OneStickTankRobot(HardwareMap hardwareMap)
    {
        mechAssembly = new ExampleIntakeAssembly(hardwareMap);
        driveTrain = new OneStickTank(hardwareMap);
    }
}
