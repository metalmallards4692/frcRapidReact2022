// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ArmDown extends CommandBase {
  /** Creates a new ArmIn. */
  public ArmDown() {
//Requires Climber Subsystem
    addRequirements(Robot.climber);
  }

  //Everything here will only run once when the command is orignally scheduled
  @Override
  public void initialize() {}

  //Everything will run constantly as long as the command is running true
  @Override
  public void execute() {
    Robot.climber.ArmIn();
  }

  //Everything here will run once the command ends or is interupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end. - You can put any custom conditions in place of the false. 
  @Override
  public boolean isFinished() {
    return false;
  }
}
