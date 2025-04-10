package org.firstinspires.ftc.teamcode.RobotModel.DriveTrain.Mecanum;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotModel.DriveTrain.DriveTrain;

public class MecanumDrive extends DriveTrain
{
    // these can be declared Final because once they are initialized they should not be changed.
    private final DcMotor LB;
    private final DcMotor LF;
    private final DcMotor RB;
    private final DcMotor RF;

    public MecanumDrive(HardwareMap hardwareMap)
    {
        LB = hardwareMap.get(DcMotor.class, "LBMotor");
        LF = hardwareMap.get(DcMotor.class, "LFMotor");
        RB = hardwareMap.get(DcMotor.class, "RBMotor");
        RF = hardwareMap.get(DcMotor.class, "RFMotor");
    }

    @Override
    public void drive(Gamepad gamepad)
    {
        double vertical;
        double horizontal;
        double turn;

        vertical = gamepad.left_stick_y;
        horizontal = gamepad.left_stick_x;
        turn = gamepad.right_stick_x;

        RF.setPower(turn + (- vertical + horizontal));
        RB.setPower(turn + (- vertical - horizontal));
        LF.setPower(turn + (- vertical - horizontal));
        LB.setPower(turn + (- vertical + horizontal));
    }


    /**
     * Don't need anything here yet, might be useful in the future
     * @param telemetry
     */
    @Override
    public void updateTelemetry(Telemetry telemetry)
    {

    }
}
