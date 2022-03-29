// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.math.MathUtil;

public class AutoAimAndDrive extends CommandBase {
  private double kpAim = -0.05;
  private double kpDistance = -0.05;
  private double m_moveValue;
  private double m_rotateValue;
 // private double min_command = 0.1;
  public AutoAimAndDrive(DrivetrainSubsystem m_DrivetrainSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.getDrivetrain());
    addRequirements(Robot.visioncamera);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.visioncamera.setLedOn(true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double tx = Robot.visioncamera.gLimeLight().getdegRotationToTarget();
    double ty = Robot.visioncamera.gLimeLight().getdegVerticalToTarget();
    boolean targetFound = Robot.visioncamera.gLimeLight().getIsTargetFound();
    //Old Limelight Code - Was wonky
/*
    if(targetFound==false) {
      m_moveValue = 0.0;
      m_rotateValue = .3;
    } else if (targetFound==true && ty < min_command && tx < min_command) {
      m_moveValue = 0.0;
      m_rotateValue = 0.0;
    } else if (targetFound==true && tx < min_command) {
      m_moveValue = ty * kpDistance * -1;
      m_rotateValue = 0.0;
    } else if (targetFound==true && ty < min_command) {
      m_moveValue = 0.0;
      m_rotateValue = tx * kpAim * -1;
    } else if(targetFound==true){
      m_moveValue = ty * kpDistance * -1;
      m_rotateValue = tx * kpAim * -1;
    } 

*/ //new limelight code from their website
    if (targetFound==true && tx > 1.0) {
      m_rotateValue = tx * kpAim
      // - min_command
       ;
    } else if (targetFound==true && tx < 1.0) {
      m_rotateValue = tx * kpAim
      // + min_command
       ;
    } else {
      m_rotateValue = .6;
    }
     m_moveValue = ty * kpDistance
     // - min_command
      ;
     m_moveValue = MathUtil.applyDeadband(m_moveValue, .05);
     m_rotateValue = MathUtil.applyDeadband(m_rotateValue, .05);

    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(m_moveValue, (RobotContainer.modifyAxis(RobotContainer.rightJoy.getX() * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND )), m_rotateValue));
    SmartDashboard.putNumber("X Error", Robot.visioncamera.gLimeLight().getdegRotationToTarget());
    SmartDashboard.putNumber("Y Error", Robot.visioncamera.gLimeLight().getdegVerticalToTarget());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(0.0, 0.0, 0.0));
    //RobotContainer.getDrivetrain().gLimeLight().setLEDMode(LedMode.kforceOff);
    Robot.visioncamera.setLedOn(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
