package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AutonStrategies.ExampleAutonomousStrategies;
import org.firstinspires.ftc.teamcode.AutonStrategies.IAutonomousStrategy;
import org.firstinspires.ftc.teamcode.RobotModel.Robots.MecanumRobot;


@Autonomous(name="Auton Example")
public class AutonomousExample extends LinearOpMode
{
    private MecanumRobot robot;
    private IAutonomousStrategy autonStrategy;

    public AutonomousExample()
    {
        robot = new MecanumRobot(hardwareMap);
        autonStrategy = ExampleAutonomousStrategies.MecanumAutonDance(robot.getAutonomousRobot());
    }

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        autonStrategy.execute();
    }
}
