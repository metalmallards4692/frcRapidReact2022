// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IndexWithStopper extends CommandBase {
  /** Creates a new IndexWithStopper. */
  double IR;
  public IndexWithStopper() {
    // Use addRequirements() here to declare subsystem dependencies.
   
    addRequirements(Robot.indexer);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    IR = Robot.indexer.getSensor().getProximity();
    /*
    if (IR >= 200) {
      Robot.indexer.IndexOn(0.0);
    } else { 
      Robot.indexer.IndexOn(.5);
    } 
    SmartDashboard.putNumber("Proximity", IR);
  }
*/
    Robot.indexer.IndexOn(.5);
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.indexer.IndexOn(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (IR >=150);
  }
}
