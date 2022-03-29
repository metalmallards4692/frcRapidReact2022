// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
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
  public void initialize() {
    //RobotContainer.getDrivetrain().gLimeLight().setLEDMode(LedMode.kforceOn);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double tx = Robot.visioncamera.gLimeLight().getdegRotationToTarget();
    //double ty = RobotContainer.getDrivetrain().gLimeLight().getdegVerticalToTarget();
    boolean targetFound = Robot.visioncamera.gLimeLight().getIsTargetFound();

    if(targetFound==true){
      //m_moveValue = ty * kpDistance;
      m_rotateValue = tx * kpAim * -1;
    }else{
     // m_moveValue = 0;
      m_rotateValue = 0.0;
    }

    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(0.0, 0.0, m_rotateValue));
    SmartDashboard.putNumber("X Error", Robot.visioncamera.gLimeLight().getdegRotationToTarget());
    SmartDashboard.putNumber("Distance", Constants.distance);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(0.0, 0.0, 0.0));
    //RobotContainer.getDrivetrain().gLimeLight().setLEDMode(LedMode.kforceOff);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
