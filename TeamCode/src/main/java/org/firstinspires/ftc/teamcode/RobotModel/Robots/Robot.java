package org.firstinspires.ftc.teamcode.RobotModel.Robots;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotModel.DriveTrain.DriveTrain;
import org.firstinspires.ftc.teamcode.RobotModel.Mechs.Assemblies.MechAssembly;

public abstract class Robot
{
    public abstract class AutonomousRobot
    {
        public AutonomousRobot(DriveTrain.AutonomousDriving driveTrain, MechAssembly.AutonomousMechBehaviors mechAssembly)
        {

        }
    }

    public abstract <T extends AutonomousRobot> T getAutonomousRobot();

    protected DriveTrain driveTrain;
    protected MechAssembly mechAssembly;

    public void updateTelemetry(Telemetry telemetry){
        driveTrain.updateTelemetry(telemetry);
        mechAssembly.updateTelemetry(telemetry);
    }

    /**
     * update the robot state!  Pass along the gamepads to the different modules.
     * @param gamepad1 driver gamepad
     * @param gamepad2 mech gamepad
     */
    public void update(Gamepad gamepad1, Gamepad gamepad2)
    {
        driveTrain.drive(gamepad1);
        mechAssembly.giveInstructions(gamepad2);
    }
}
