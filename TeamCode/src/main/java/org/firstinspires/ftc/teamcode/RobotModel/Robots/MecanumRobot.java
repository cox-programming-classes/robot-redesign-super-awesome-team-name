package org.firstinspires.ftc.teamcode.RobotModel.Robots;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotModel.DriveTrain.DriveTrain;
import org.firstinspires.ftc.teamcode.RobotModel.DriveTrain.Mecanum.MecanumDrive;
import org.firstinspires.ftc.teamcode.RobotModel.Mechs.Assemblies.CascadeArm;
import org.firstinspires.ftc.teamcode.RobotModel.Mechs.Assemblies.MechAssembly;

public class MecanumRobot extends Robot
{
    public MecanumRobot(HardwareMap hardwareMap)
    {
        driveTrain = new MecanumDrive(
                hardwareMap,
                new MecanumDrive.OrientationConfiguration(
                        DcMotorSimple.Direction.REVERSE,
                        DcMotorSimple.Direction.FORWARD,
                        DcMotorSimple.Direction.FORWARD,
                        DcMotorSimple.Direction.REVERSE
                    )
                );
        mechAssembly = new CascadeArm(hardwareMap);
        auton = new AutonomousMecanumRobot(driveTrain.getAutonomousDriving(), mechAssembly.getAutonomousBehaviors());
    }

    public class AutonomousMecanumRobot extends AutonomousRobot{
        public final MecanumDrive.AutonomousMecanumDrive driveTrain;
        public final CascadeArm.AutonomousCascadeArmBehaviors mechAssembly;

        public AutonomousMecanumRobot(
                MecanumDrive.AutonomousMecanumDrive driveTrain,
                CascadeArm.AutonomousCascadeArmBehaviors mechAssembly
        )
        {
            super(driveTrain, mechAssembly);
            this.driveTrain = driveTrain;
            this.mechAssembly = mechAssembly;
        }
    }


    private final AutonomousMecanumRobot auton;

    @Override
    public AutonomousMecanumRobot getAutonomousRobot() {
        return auton;
    }
}
