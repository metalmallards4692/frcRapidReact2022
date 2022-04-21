// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class FenderShot extends CommandBase {
  /** Creates a new FenderShot. */
  public FenderShot() {
//Requires these subsystems
    addRequirements(Robot.m_shooter);
    addRequirements(Robot.indexer);
  }

//When the command first gets called, set hood to the down position, since it starts in the forward, the toggle command works just fine.
  @Override
  public void initialize() {
    Robot.m_shooter.HoodToggle();
  }

//it will run the index and shooter motors at these values for as long as the command is running.
  @Override
  public void execute() {
  Robot.indexer.IndexOn(.5);
   Robot.m_shooter.ShooterOn(.5); //.4
  }

//When the command ends, it will set motors to these values to stop them from spinning forever.
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
