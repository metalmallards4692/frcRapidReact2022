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
//Declares a bunch of varibles and creates a timer object
  private double kpAim = -0.1;
  private double kpDistance = -0.1;
  private double m_moveValue;
  private double m_rotateValue;
  private Timer ShootTimer = new Timer();
  private double val;

  public TimedAutoAim() {
//Requires these subsystems
    addRequirements(RobotContainer.getDrivetrain());
    addRequirements(Robot.visioncamera);
  }

  //When command is first called, switch to targeting pipeline and turn on LEDS for limelight. Also reset and start up the timer counter.
  @Override
  public void initialize() {
    Robot.visioncamera.switchPipeline(true);
    Robot.visioncamera.setLedOn(true);
    ShootTimer.reset();
    ShootTimer.start();
  }

  //Each loop, the varibles get updated. 
  @Override
  public void execute() {
    val = ShootTimer.get();
    double tx = Robot.visioncamera.gLimeLight().getdegRotationToTarget();
    double ty = Robot.visioncamera.gLimeLight().getdegVerticalToTarget();
    boolean targetFound = Robot.visioncamera.gLimeLight().getIsTargetFound();

 //Runs varible values through conditional to calucate motor speeds and sets them accordingly
    if (targetFound==true && tx > 1.0) {
      m_rotateValue = tx * kpAim;
    } else if (targetFound==true && tx < 1.0) {
      m_rotateValue = tx * kpAim;
    } else {
      
    }
     m_moveValue = ty * kpDistance;
     m_moveValue = MathUtil.applyDeadband(m_moveValue, .1);
     m_rotateValue = MathUtil.applyDeadband(m_rotateValue, .1);

    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(m_moveValue, (RobotContainer.modifyAxis(RobotContainer.rightJoy.getX() * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND )), m_rotateValue));
    SmartDashboard.putNumber("X Error", Robot.visioncamera.gLimeLight().getdegRotationToTarget());
    SmartDashboard.putNumber("Y Error", Robot.visioncamera.gLimeLight().getdegVerticalToTarget());

  //After looking through this, this uses my old method for getting values and setting them. Not sure why I never updated it but hey... it works i guess.
  }

//Sets motors to zero when command ends and swicthes back to driver pipeline and turns off leds.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(0.0, 0.0, 0.0));
    Robot.visioncamera.switchPipeline(false);
    Robot.visioncamera.setLedOn(false);
  }

//Ends command when timer reaches 4 seconds.
  @Override
  public boolean isFinished() {
    return (val > 4);
  }
}
