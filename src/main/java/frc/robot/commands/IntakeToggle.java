// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IntakeToggle extends CommandBase {
//Decalres new boolean value and sets to false
  boolean bDone = false;
  /** Creates a new IntakeToggle. */
  public IntakeToggle() {
//Requires these subsystems
    addRequirements(Robot.intake);
  }

//Set value of boolean to false and runs the IntakeToggle function
  @Override
  public void initialize() {
    bDone = false;
    Robot.intake.IntakeToggle();
  }

//Sets value of bDone to true each loop. Which triggers the isFinsihed function ending the command on the first loop
  @Override
  public void execute() {
    bDone = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

//When bDOne equals true, end command
  @Override
  public boolean isFinished() {
    return bDone;
  }
}
