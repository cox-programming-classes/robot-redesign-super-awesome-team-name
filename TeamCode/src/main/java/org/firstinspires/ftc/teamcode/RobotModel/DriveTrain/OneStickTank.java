package org.firstinspires.ftc.teamcode.RobotModel.DriveTrain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Extensions.GamepadExtensions;


public class OneStickTank extends DriveTrain
{
    private class LeroyState
    {
        ElapsedTime _stateTimer;
        double _chargeTime;
        boolean _isActive;

        /**
         * Instantiate a Leroy Jenkins state
         * @param chargeTime duration of the blind charge in seconds
         */
        public LeroyState(double chargeTime)
        {
            _stateTimer = new ElapsedTime(ElapsedTime.Resolution.SECONDS);
            _chargeTime = chargeTime;
            _isActive = false;
        }

        /**
         * LEROY JEEENKINS~!
         */
        public void activate()
        {
            left.setPower(1);
            right.setPower(1);
            _stateTimer.reset();
            _isActive = true;
        }

        /**
         * Are we still Charging?
         * @return
         */
        public boolean isCompleted()
        {
            if(!_isActive)
                return true;

            double duration = _stateTimer.time();
            if(duration < _chargeTime)
                return false;

            left.setPower(0);
            right.setPower(0);
            _isActive = false;
            return true;
        }
    }

    // these can be declared Final because once they are initialized they should not be changed.
    private final DcMotor left, right;
    private final LeroyState leroyState = new LeroyState(10);
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
        if(!leroyState.isCompleted())
            return; // Leroy is in control!

        if(gamepad.left_bumper && gamepad.right_bumper)
        {
            // LEROY JENKINS!
            leroyState.activate();
            return;
        }

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
