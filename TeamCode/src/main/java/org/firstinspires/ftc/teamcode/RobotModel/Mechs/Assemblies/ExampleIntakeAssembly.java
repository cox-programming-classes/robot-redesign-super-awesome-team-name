package org.firstinspires.ftc.teamcode.RobotModel.Mechs.Assemblies;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotModel.Mechs.Components.Claw;
import org.firstinspires.ftc.teamcode.RobotModel.Mechs.Components.SpinnyIntake;

public class ExampleIntakeAssembly extends MechAssembly
{
    private final SpinnyIntake intake;
    private final Claw claw;
    public ExampleIntakeAssembly(HardwareMap hardwareMap)
    {
        intake = new SpinnyIntake(hardwareMap, "spinner",
                (motor, gamepad) -> {
                       if(gamepad.a)
                           motor.setPower(1);
                       else if(gamepad.b)
                           motor.setPower(-1);
                       else
                           motor.setPower(0);
                });

        claw = new Claw(hardwareMap, "claw",
                (servo, gamepad) ->
                {
                    if(gamepad.left_bumper)
                        servo.setPosition(1);
                    if(gamepad.right_bumper)
                        servo.setPosition(0);
                },
                (servo, telemetry) -> {});
    }
    @Override
    public void giveInstructions(Gamepad gamepad) {
        intake.move(gamepad);
        claw.move(gamepad);
    }

    @Override
    public void updateTelemetry(Telemetry telemetry) {
        
    }
}
