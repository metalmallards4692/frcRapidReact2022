// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class ChangeSpeed extends CommandBase {
  boolean bDone = false;
  /** Creates a new ChangeSpeed. */
  public ChangeSpeed() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    bDone = false;
    if(Constants.METERS_PER_SECOND_DIVIDED == 1){
      Constants.METERS_PER_SECOND_DIVIDED = 2;
    }else{
      Constants.METERS_PER_SECOND_DIVIDED = 1;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    bDone = true;

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return bDone;
  }
}
