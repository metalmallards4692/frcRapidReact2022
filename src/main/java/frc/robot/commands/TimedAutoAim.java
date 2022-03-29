// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.math.MathUtil;

public class TimedAutoAim extends CommandBase {
  private double kpAim = -0.05;
  private double kpDistance = -0.05;
  private double m_moveValue;
  private double m_rotateValue;
  private Timer ShootTimer = new Timer();
  private double val;
  public TimedAutoAim() {

    addRequirements(RobotContainer.getDrivetrain());
    addRequirements(Robot.visioncamera);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.visioncamera.setLedOn(true);
    ShootTimer.reset();
    ShootTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    val = ShootTimer.get();
    double tx = Robot.visioncamera.gLimeLight().getdegRotationToTarget();
    double ty = Robot.visioncamera.gLimeLight().getdegVerticalToTarget();
    boolean targetFound = Robot.visioncamera.gLimeLight().getIsTargetFound();

 //new limelight code from their website
    if (targetFound==true && tx > 1.0) {
      m_rotateValue = tx * kpAim;
    } else if (targetFound==true && tx < 1.0) {
      m_rotateValue = tx * kpAim;
    } else {
      m_rotateValue = .6;
    }
     m_moveValue = ty * kpDistance;
     m_moveValue = MathUtil.applyDeadband(m_moveValue, .1);
     m_rotateValue = MathUtil.applyDeadband(m_rotateValue, .1);

    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(m_moveValue, (RobotContainer.modifyAxis(RobotContainer.rightJoy.getX() * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND )), m_rotateValue));
    SmartDashboard.putNumber("X Error", Robot.visioncamera.gLimeLight().getdegRotationToTarget());
    SmartDashboard.putNumber("Y Error", Robot.visioncamera.gLimeLight().getdegVerticalToTarget());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(0.0, 0.0, 0.0));
    Robot.visioncamera.setLedOn(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (val > 3);
  }
}
