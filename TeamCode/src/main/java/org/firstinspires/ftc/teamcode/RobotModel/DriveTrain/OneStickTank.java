package org.firstinspires.ftc.teamcode.RobotModel.DriveTrain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Extensions.GamepadExtensions;

public class OneStickTank extends DriveTrain
{
    // these can be declared Final because once they are initialized they should not be changed.
    private final DcMotor left, right;

    /**
     * Initialize the Tank Drive with Configuration motors named:
     * left -> "leftTread"
     * right -> "rightTread"
     * @param hardwareMap pass down from OpMode.
     */
    public OneStickTank(HardwareMap hardwareMap)
    {
        left = hardwareMap.get(DcMotor.class, "leftTread");
        right = hardwareMap.get(DcMotor.class, "rightTread");
    }

    @Override
    public void drive(Gamepad gamepad)
    {
        float throttle = GamepadExtensions.GetLeftStickY(gamepad);
        float turnBias = GamepadExtensions.GetLeftStickX(gamepad);
        float extraTurnBias = GamepadExtensions.GetRightStickX(gamepad);

        if( (extraTurnBias < 0 && turnBias < 0) ||
            (extraTurnBias > 0 && turnBias > 0) )
        {
            turnBias += extraTurnBias;
            if(Math.abs(turnBias) > 1)
                throttle = Math.max(Math.abs(throttle), Math.abs(turnBias) - 1);
        }

        left.setPower(calculateLeftPower(throttle, turnBias));
        right.setPower(calculateRightPower(throttle, turnBias));
    }

    private float calculateRightPower(float throttle, float turnBias)
    {
        if(turnBias <= 0)
            return throttle;

        return throttle * (1 - turnBias);
    }
    private float calculateLeftPower(float throttle, float turnBias)
    {
        if(turnBias >= 0)
            return throttle;

        return throttle * (1 + turnBias);
    }
}
