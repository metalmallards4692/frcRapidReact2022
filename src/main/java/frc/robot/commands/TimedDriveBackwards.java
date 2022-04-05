// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class TimedDriveBackwards extends CommandBase {
  /** Creates a new TimedDriveBackwards. */
  double val;
  private Timer ShootTimer = new Timer();
  public TimedDriveBackwards() {
    addRequirements(RobotContainer.getDrivetrain());
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ShootTimer.reset();
    ShootTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    val = ShootTimer.get();
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(.5, 0.0, 0.0));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(-.5, 0.0, 0.0));
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (val > 4);
  }
}
