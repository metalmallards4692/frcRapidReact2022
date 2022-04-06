// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class WrongBall extends CommandBase {

  public WrongBall() {
//Requires these subsystems
    addRequirements(Robot.m_shooter);
    addRequirements(Robot.indexer);
  }

//When command is first called, lower the hood
  @Override
  public void initialize() {
    Robot.m_shooter.HoodToggle();
  }

///Set the value of the motors to whatever numbers are there
  @Override
  public void execute() {
    Robot.indexer.IndexOn(.3);
    Robot.m_shooter.ShooterOn(.3);
  }

//When the command ends, return hood to original position and set motors back to zero.
  @Override
  public void end(boolean interrupted) {
    Robot.indexer.IndexOn(0.0);
    Robot.m_shooter.ShooterOn(0.0);
    Robot.m_shooter.HoodToggle();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
