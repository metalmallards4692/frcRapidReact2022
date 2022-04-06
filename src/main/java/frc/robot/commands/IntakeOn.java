// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IntakeOn extends CommandBase {
  /** Creates a new IntakeOn. */
  public IntakeOn() {
//Requires these subsystems
    addRequirements(Robot.intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

//Sets intake motors to this value
  @Override
  public void execute() {
    Robot.intake.IntakeOn(1.0);
  }
//When command ends, set motor to zero
  @Override
  public void end(boolean interrupted) {
    Robot.intake.IntakeOn(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
