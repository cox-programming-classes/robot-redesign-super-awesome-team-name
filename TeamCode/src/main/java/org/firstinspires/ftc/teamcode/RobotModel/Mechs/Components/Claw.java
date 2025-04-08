package org.firstinspires.ftc.teamcode.RobotModel.Mechs.Components;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw extends MechComponent
{
    public interface ClawControlStrategy extends IControlStrategy
    {
        public void chomp(Servo servo, Gamepad gamepad);
    }
    public Servo servo;

    protected ClawControlStrategy strategy;
    public Claw(HardwareMap hardwareMap,
                String servoName,
                ClawControlStrategy strategy)
    {
        super(strategy);
        servo = hardwareMap.get(Servo.class, servoName);
        this.strategy = strategy;
    }

    public void move(Gamepad gamepad)
    {
        strategy.chomp(servo, gamepad);
    }

}
