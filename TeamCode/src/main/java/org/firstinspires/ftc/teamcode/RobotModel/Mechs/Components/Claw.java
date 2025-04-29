package org.firstinspires.ftc.teamcode.RobotModel.Mechs.Components;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Claw extends MechComponent
{

    public interface ClawControlStrategy extends IControlStrategy
    {
        public void chomp(Servo servo, Gamepad gamepad);
    }

    public interface ClawTelemetryStrategy
    {
        public void update(Servo servo, Telemetry telemetry);
    }
    public Servo servo;

    protected ClawControlStrategy strategy;
    protected ClawTelemetryStrategy telemetryStrategy;

    public Claw(HardwareMap hardwareMap,
                String servoName,
                ClawControlStrategy strategy,
                ClawTelemetryStrategy telemetryStrategy)
    {
        super(strategy);
        servo = hardwareMap.get(Servo.class, servoName);
        this.strategy = strategy;
        this.telemetryStrategy = telemetryStrategy;
    }

    public class AutonomousClawBehaviors extends AutonomousComponentBehaviors {
        public void setPosition(double position) {
            servo.setPosition(position);
        }
        public void open() {
            servo.setPosition(1);
        }
        public void close() {
            servo.setPosition(0);
        }
    }
    @Override
    public <T extends AutonomousComponentBehaviors> T getAutonomousBehaviors() {
        return null;
    }

    public void move(Gamepad gamepad)
    {
        strategy.chomp(servo, gamepad);
    }

    @Override
    public void update(Telemetry telemetry)
    {
        telemetryStrategy.update(servo, telemetry);
    }

}
