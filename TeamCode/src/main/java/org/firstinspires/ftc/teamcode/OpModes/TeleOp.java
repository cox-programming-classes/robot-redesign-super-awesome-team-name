package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotModel.Robot;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp", group= "Example")
public class TeleOp extends LinearOpMode {


    Robot robot;

    @Override
    public void runOpMode()
            throws InterruptedException
    {
        robot = new Robot(hardwareMap);
    }
}
