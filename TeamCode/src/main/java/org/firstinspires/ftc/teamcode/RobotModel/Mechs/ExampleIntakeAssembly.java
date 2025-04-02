package org.firstinspires.ftc.teamcode.RobotModel.Mechs;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ExampleIntakeAssembly extends MechAssembly
{
    private final SpinnyIntake intake;

    public ExampleIntakeAssembly(HardwareMap hardwareMap)
    {
        intake = new SpinnyIntake(hardwareMap, "spinner",
                new SpinnyIntake.SpinnyIntakeControlStrategy() {
                    @Override
                    public void nomNomNom(DcMotor motor, Gamepad gamepad) {
                           if(gamepad.a)
                               motor.setPower(1);
                           else if(gamepad.b)
                               motor.setPower(-1);
                           else
                               motor.setPower(0);
                    }
                });
    }

    @Override
    public void giveInstructions(Gamepad gamepad) {

    }
}
