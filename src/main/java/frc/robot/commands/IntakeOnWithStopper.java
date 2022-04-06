// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IntakeOnWithStopper extends CommandBase {
  /** Creates a new IntakeOnWithStopper. */
  public IntakeOnWithStopper() {
//Requires these subsystems
    addRequirements(Robot.intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

//Runs IntakeOnWithStopper command with this parameter value
  @Override
  public void execute() {
    Robot.intake.IntakeOnWithStopper(1.0);
  }

//Sets motors to zero at command end
  @Override
  public void end(boolean interrupted) {
    Robot.intake.IntakeOnWithStopper(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
