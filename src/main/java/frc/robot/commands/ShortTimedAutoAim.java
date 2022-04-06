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

public class ShortTimedAutoAim extends CommandBase {
//Declares a bunch of varibles and creates a timer object
  private double kpAim = -0.1;
  private double kpDistance = -0.1;
  private double m_moveValue;
  private double m_rotateValue;
  private Timer ShootTimer = new Timer();
  private double val;
  public ShortTimedAutoAim() {
//Requires these subsystems
    addRequirements(RobotContainer.getDrivetrain());
    addRequirements(Robot.visioncamera);
  }
//When command is first run, switch limelight pipeline to targeting and leds to On. Also reset and start up the timer. 
  @Override
  public void initialize() {
    Robot.visioncamera.switchPipeline(true);
    Robot.visioncamera.setLedOn(true);
    ShootTimer.reset();
    ShootTimer.start();
  }

//Each loop, val gets updated with current time. Tx, Ty, and targetFound also get updated based on the network table values for the limelight. 
  @Override
  public void execute() {
    val = ShootTimer.get();
    double tx = MathUtil.applyDeadband(Robot.visioncamera.gLimeLight().getdegRotationToTarget(), .2);
    double ty = MathUtil.applyDeadband(Robot.visioncamera.gLimeLight().getdegVerticalToTarget(), .2);
    boolean targetFound = Robot.visioncamera.gLimeLight().getIsTargetFound();

 //Those values get plugged into this conditional to calcuate motor speeds based on a PID control loop. It then sets motor speeds to those values
    if (targetFound==true && tx > 1.0) {
      m_rotateValue = tx * kpAim;
    } else if (targetFound==true && tx < 1.0) {
      m_rotateValue = tx * kpAim;
    } else {
// This allows the driver to control the rotation of the robot to find the target faster if facing wrong direction.
      m_rotateValue = RobotContainer.modifyAxis(RobotContainer.rightJoy.getZ()) * DrivetrainSubsystem.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND * -.5;
    }
     m_moveValue = ty * kpDistance;
// By passing in the joystick values for X Axis, the driver can strafe the target while maintaining aiming and distance from the target. - Very cool might I add
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(m_moveValue, (RobotContainer.modifyAxis(RobotContainer.rightJoy.getX() * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND )), m_rotateValue));
    SmartDashboard.putNumber("X Error", Robot.visioncamera.gLimeLight().getdegRotationToTarget());
    SmartDashboard.putNumber("Y Error", Robot.visioncamera.gLimeLight().getdegVerticalToTarget());
  }

//When command ends, set motors to zero and switch limelight back to driver pipeline and turn off leds.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(0.0, 0.0, 0.0));
    Robot.visioncamera.switchPipeline(false);
    Robot.visioncamera.setLedOn(false);
  }

//This command ends when the timer reaches 2 seconds
  @Override
  public boolean isFinished() {
    return (val > 2);
  }
}
