// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class HookToggle extends CommandBase {
//Creates boolean and sets its value to false
  boolean bDone = false;
  public HookToggle() {
//Requires these subsystems
    addRequirements(Robot.climber);
  }

//When command is first started, set value to false and calls the HoodToggle function
  @Override
  public void initialize() {
    bDone = false;
    Robot.climber.HookToggle();
  }

//Sets the value of bDOne to true, effectively ending the command
  @Override
  public void execute() {
   bDone = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

//Ends command once bDone equals true, which happens to be instantly in the first loop
  @Override
  public boolean isFinished() {
    return bDone;
  }
}
