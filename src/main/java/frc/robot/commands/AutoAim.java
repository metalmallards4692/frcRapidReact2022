// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class AutoAim extends CommandBase {
  /** Creates a new AutoAim. */
  private double kpAim = 0.05;
  //private double kpDistance = 0.05;
  //private double m_moveValue;
  private double m_rotateValue;

  public AutoAim() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.getDrivetrain());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double tx = RobotContainer.getDrivetrain().gLimeLight().getdegRotationToTarget();
    //double ty = RobotContainer.getDrivetrain().gLimeLight().getdegVerticalToTarget();
    boolean targetFound = RobotContainer.getDrivetrain().gLimeLight().getIsTargetFound();

    if(targetFound){
      //m_moveValue = ty * kpDistance;
      m_rotateValue = tx * kpAim;
    }else{
     // m_moveValue = 0;
      m_rotateValue = .3;
    }

    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(0.0, 0.0, m_rotateValue));
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
