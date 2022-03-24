// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import oi.limelightvision.limelight.frc.ControlMode.LedMode;

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

public double estimateDis() {
  double cot = cotan(Constants.cameraAngleDegrees + RobotContainer.getDrivetrain().gLimeLight().getdegVerticalToTarget());
  return cot * (Constants.goalHeightMeters - Constants.cameraHeightMeters);
}

public double cotan(double aDegrees) {
  return Math.cos(Math.toRadians(aDegrees))/Math.sin(Math.toRadians(aDegrees));
}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //RobotContainer.getDrivetrain().gLimeLight().setLEDMode(LedMode.kforceOn);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double tx = RobotContainer.getDrivetrain().gLimeLight().getdegRotationToTarget();
    //double ty = RobotContainer.getDrivetrain().gLimeLight().getdegVerticalToTarget();
    boolean targetFound = RobotContainer.getDrivetrain().gLimeLight().getIsTargetFound();
    Constants.distance = estimateDis();

    if(targetFound==true){
      //m_moveValue = ty * kpDistance;
      m_rotateValue = tx * kpAim * -1;
    }else{
     // m_moveValue = 0;
      m_rotateValue = 0.0;
    }

    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(0.0, 0.0, m_rotateValue));
    SmartDashboard.putNumber("X Error", RobotContainer.getDrivetrain().gLimeLight().getdegRotationToTarget());
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
