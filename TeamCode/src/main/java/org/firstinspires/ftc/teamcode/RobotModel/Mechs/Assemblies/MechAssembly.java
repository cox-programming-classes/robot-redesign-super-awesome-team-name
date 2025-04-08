package org.firstinspires.ftc.teamcode.RobotModel.Mechs.Assemblies;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Mech Assembly is a Composite of all the mech components
 * in a robot.  Inheritors should have discrete Mech Component
 * implementations that it hands down instructions to.
 */
public abstract class MechAssembly
{
    /**
     * Pass along gamepad instructions to subcomponents.
     * @param gamepad the Gamepad
     */
    public abstract void giveInstructions(Gamepad gamepad);
}
