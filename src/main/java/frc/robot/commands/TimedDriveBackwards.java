// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class TimedDriveBackwards extends CommandBase {
//Declares varible names and creates timer object
  double val;
  private Timer ShootTimer = new Timer();
  public TimedDriveBackwards() {
//Requires these subsystems
    addRequirements(RobotContainer.getDrivetrain());
    // Use addRequirements() here to declare subsystem dependencies.
  }

//When the command is first called, reset and start the timer 
  @Override
  public void initialize() {
    ShootTimer.reset();
    ShootTimer.start();
  }

//Each loop will update the val variable and it also sets the motors on the robot to drive backwards
  @Override
  public void execute() {
    val = ShootTimer.get();
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(.5, 0.0, 0.0));
  }

//When command ends, set motor values to zero - Fun fact, I had this set to -0.5 rather than zero which explains why the robot would always drive forward towards the end of autonomous
  @Override
  public void end(boolean interrupted) {
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(0.0, 0.0, 0.0));
  }

//Command will end after 4 seconds
  @Override
  public boolean isFinished() {
    return (val > 4);
  }
}
