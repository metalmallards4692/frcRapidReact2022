// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IndexWithStopper extends CommandBase {
//Declares varible for IR 
  double IR;
  public IndexWithStopper() {
//Requires these subsystems
    addRequirements(Robot.indexer);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

//Updates the varible IR with the current sensor reading from the Color Sensor and sets index motor value to whatever number is set. It also displays the current IR value on smartdashboard for debug purposes
  @Override
  public void execute() {
    IR = Robot.indexer.getSensor().getProximity();
    Robot.indexer.IndexOn(.4);
    SmartDashboard.putNumber("Proximity", IR);
  }
//When command ends, set motors to zero
  @Override
  public void end(boolean interrupted) {
    Robot.indexer.IndexOn(0.0);
  }

//Ends the command when IR greater than or equal to 250. This means if something goes in front of the sensor, the value will meet this condition and end the command
  @Override
  public boolean isFinished() {
    return (IR >=250);
  }
}
