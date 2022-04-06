// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class Reverse extends CommandBase {
  /** Creates a new SuperShoot. */
  public Reverse() {
//Requires these subsystems
    addRequirements(Robot.m_shooter);
    addRequirements(Robot.indexer);
    addRequirements(Robot.intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

//Sets motors to these values
  @Override
  public void execute() {
    Robot.m_shooter.ShooterOn(-.4);
    Robot.indexer.IndexOn(-.4);
    Robot.intake.IntakeOn(-.4);
  }

//Sets motors to zero wheb command ends
  @Override
  public void end(boolean interrupted) {
    Robot.m_shooter.ShooterOn(0.0);
    Robot.indexer.IndexOn(0.0);
    Robot.intake.IntakeOn(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
