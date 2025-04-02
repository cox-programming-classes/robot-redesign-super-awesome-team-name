package org.firstinspires.ftc.teamcode.RobotModel.DriveTrain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Extensions.GamepadExtensions;

public class StandardTankDrive extends DriveTrain
{
    // these can be declared Final because once they are initialized they should not be changed.
    private final DcMotor left, right;

    /**
     * Initialize the Tank Drive with Configuration motors named:
     * left -> "leftTread"
     * right -> "rightTread"
     * @param hardwareMap pass down from OpMode.
     */
    public StandardTankDrive(HardwareMap hardwareMap)
    {
        left = hardwareMap.get(DcMotor.class, "leftTread");
        right = hardwareMap.get(DcMotor.class, "rightTread");
    }

    @Override
    public void drive(Gamepad gamepad)
    {
        float leftDrive = GamepadExtensions.GetLeftStickY(gamepad);
        float rightDrive = GamepadExtensions.GetRightStickY(gamepad);
        left.setPower(leftDrive);
        right.setPower(rightDrive);
    }

}
