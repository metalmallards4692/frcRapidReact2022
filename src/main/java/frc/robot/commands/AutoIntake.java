// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class AutoIntake extends CommandBase {
  /** Creates a new AutoIntake. */
  double IR;
  public AutoIntake() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.intake);
    addRequirements(Robot.indexer);
    addRequirements(RobotContainer.getDrivetrain());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   RobotContainer.getDrivetrain().zeroGyroscope();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    IR = Robot.indexer.getSensor().getProximity();
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(.4, 0.0, 0.0));
    Robot.intake.IntakeOn(1.0);
    Robot.indexer.IndexOn(.3);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(0.0, 0.0, 0.0));
    Robot.intake.IntakeOn(0.0);
    Robot.indexer.IndexOn(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (IR >= 150);
  }
}
