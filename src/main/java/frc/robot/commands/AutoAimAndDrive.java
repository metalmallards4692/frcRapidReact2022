// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.math.MathUtil;

public class AutoAimAndDrive extends CommandBase {
  private double kpAim = -0.1;
  private double kpDistance = -0.1;
  private double m_moveValue;
  private double m_rotateValue;
  private double min_command = 0.05;
  public AutoAimAndDrive(DrivetrainSubsystem m_DrivetrainSubsystem) {

    addRequirements(RobotContainer.getDrivetrain());
    addRequirements(Robot.visioncamera);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.visioncamera.switchPipeline(true);
    Robot.visioncamera.setLedOn(true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double tx = MathUtil.applyDeadband(Robot.visioncamera.gLimeLight().getdegRotationToTarget(), .1);
    double ty = MathUtil.applyDeadband(Robot.visioncamera.gLimeLight().getdegVerticalToTarget(), .1);
    boolean targetFound = Robot.visioncamera.gLimeLight().getIsTargetFound();

    //new limelight code from their website
    if (targetFound==true && tx > 1.0) {
      m_rotateValue = tx * kpAim - min_command;
    } else if (targetFound==true && tx < 1.0) {
      m_rotateValue = tx * kpAim - min_command;
    } else {
      m_rotateValue = RobotContainer.modifyAxis(RobotContainer.rightJoy.getZ()) * DrivetrainSubsystem.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND * -.5;
    }
     m_moveValue = ty * kpDistance - min_command;
     //m_moveValue = MathUtil.applyDeadband(m_moveValue, .1);
     //m_rotateValue = MathUtil.applyDeadband(m_rotateValue, .1);

    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(m_moveValue, (RobotContainer.modifyAxis(RobotContainer.rightJoy.getX()) * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND * -1), m_rotateValue));
    SmartDashboard.putNumber("X Error", Robot.visioncamera.gLimeLight().getdegRotationToTarget());
    SmartDashboard.putNumber("Y Error", Robot.visioncamera.gLimeLight().getdegVerticalToTarget());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(0.0, 0.0, 0.0));
    Robot.visioncamera.switchPipeline(false);
    Robot.visioncamera.setLedOn(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
