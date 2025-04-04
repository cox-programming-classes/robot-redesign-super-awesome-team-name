package org.firstinspires.ftc.teamcode.RobotModel.Robots;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.RobotModel.DriveTrain.DriveTrain;
import org.firstinspires.ftc.teamcode.RobotModel.Mechs.MechAssembly;

public abstract class Robot
{
    protected DriveTrain driveTrain;
    protected MechAssembly mechAssembly;

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
