package org.firstinspires.ftc.teamcode.RobotModel.Mechs;

import com.qualcomm.robotcore.hardware.Gamepad;

public abstract class MechComponent
{
    /**
     * Override with an implemenation that applies to the Mech in question.
     */
    protected interface IControlStrategy { }

    protected IControlStrategy strategy;

    protected MechComponent(IControlStrategy strategy)
    {
        this.strategy = strategy;
    }

    /**
     *
     * @param gamepad
     */
    abstract void move(Gamepad gamepad);
}
