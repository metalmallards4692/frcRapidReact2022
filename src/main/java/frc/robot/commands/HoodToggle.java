// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class HoodToggle extends CommandBase {
//Okay so this method of creating a togglable is copied from our InfiniteRecharge repository. I will test removing all the booleans to see if it works the same, but for now just leave it be.

  boolean bDone = false;
  public HoodToggle() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_shooter);
  }

//Sets value of bDone to false, even though it was already == to false. Then it runs the HoodToggle command which toggles the hood cylinder value
  @Override
  public void initialize() {
    bDone = false;
    Robot.m_shooter.HoodToggle();
  }

// Upon the first loop, it will set the value of bDone to true, ending the command.
  @Override
  public void execute() {
    bDone = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

//Ends command when the value of bDone == true
  @Override
  public boolean isFinished() {
    return bDone;
  }
}
