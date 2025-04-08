package org.firstinspires.ftc.teamcode.RobotModel.Mechs.Components;

import android.text.method.Touch;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

public  class DoublyLimitedMotor extends MechComponent{

    public interface DoublyLimitedMotorControlStrategy extends IControlStrategy{
        public void move(Gamepad gamepad, DoublyLimitedMotor doublyLimitedMotor);
    }
    private DcMotor motor;
    private TouchSensor forwardSensor;
    private TouchSensor reverseSensor;
    private DoublyLimitedMotorControlStrategy strategy;

    protected DoublyLimitedMotor(
            HardwareMap hardwareMap,
            String motorName,
            String forwardSensorName,
            String reverseSensorName,
            DoublyLimitedMotorControlStrategy strategy
            ) {
        super(strategy);
        motor = hardwareMap.get(DcMotor.class, motorName);
        forwardSensor = hardwareMap.get(TouchSensor.class, forwardSensorName);
        reverseSensor = hardwareMap.get(TouchSensor.class, reverseSensorName);
        this.strategy = strategy;

    }

    protected void setPower(double power){

        if ((power > 0 && !canGoForward() )|| (power > 0 && !canGoReverse())) {
            power = 0;
        }

        motor.setPower(power);
    }

    @Override
    void move(Gamepad gamepad) {
        strategy.move(gamepad, this);

    }

    /**
     *
     * @return true if the forward sensor is not pressed
     */
    protected boolean canGoForward()
    {
        return ! forwardSensor.isPressed();
    }

    /**
     *
     * @return true if the reverse sensor is not pressed
     */
    protected boolean canGoReverse()
    {
        return ! reverseSensor.isPressed();
    }
}
