package org.firstinspires.ftc.teamcode.RobotModel.Mechs;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw implements IMechComponent{

    public Servo servo;

    public Claw(Servo clawServo)
    {
        servo = clawServo;
    }

    public void move(Gamepad gamepad)
    {
        if (gamepad.left_bumper)
        {
            servo.setPosition(1.0);
        }
        if (gamepad.right_bumper)
        {
            servo.setPosition(0.0);
        }
    }

}
