package org.firstinspires.ftc.teamcode.RobotModel;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotModel.DriveTrain.DriveTrain;

import java.lang.reflect.Type;

public abstract class Robot
{
    protected DriveTrain driveTrain;

    /**
     * update the robot state!  Pass along the gamepads to the different modules.
     * @param gamepad1 driver gamepad
     * @param gamepad2 mech gamepad
     */
    public void update(Gamepad gamepad1, Gamepad gamepad2)
    {
        driveTrain.drive(gamepad1);
    }
}
