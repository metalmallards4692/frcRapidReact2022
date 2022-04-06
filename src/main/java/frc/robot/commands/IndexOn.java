// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IndexOn extends CommandBase {
  /** Creates a new IndexOn. */
  public IndexOn() {
//Requires these subsystems
    addRequirements(Robot.indexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

//Sets index motors to this value and stays on until command ends
  @Override
  public void execute() {
    Robot.indexer.IndexOn(.5);
  }

//When command ends, set motors to zero to stop them from spinning
  @Override
  public void end(boolean interrupted) {
    Robot.indexer.IndexOn(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
