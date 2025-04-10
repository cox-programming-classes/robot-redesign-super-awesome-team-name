package org.firstinspires.ftc.teamcode.RobotModel.Robots;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotModel.DriveTrain.Mecanum.MecanumDrive;
import org.firstinspires.ftc.teamcode.RobotModel.Mechs.Assemblies.CascadeArm;

public class MecanumRobot extends Robot
{
    public MecanumRobot(HardwareMap hardwareMap)
    {
        driveTrain = new MecanumDrive(hardwareMap);
        mechAssembly = new CascadeArm(hardwareMap); 
    }
}
