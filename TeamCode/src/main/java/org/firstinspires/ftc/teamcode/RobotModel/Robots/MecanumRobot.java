package org.firstinspires.ftc.teamcode.RobotModel.Robots;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotModel.DriveTrain.MecanumDrive;

public class MecanumRobot extends Robot
{
    public MecanumRobot(HardwareMap hardwareMap)
    {
        driveTrain = new MecanumDrive(hardwareMap);
    }
}
