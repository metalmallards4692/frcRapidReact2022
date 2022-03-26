// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class AutoAimAndDrive extends CommandBase {
  /** Creates a new AutoAim. */
  private double kpAim = 0.05;
  private double kpDistance = 0.05;
  private double m_moveValue;
  private double m_rotateValue;
  private double min_command = 1;

  public AutoAimAndDrive() {
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
    double tx = RobotContainer.getDrivetrain().gLimeLight().getdegRotationToTarget();
    double ty = RobotContainer.getDrivetrain().gLimeLight().getdegVerticalToTarget();
    boolean targetFound = RobotContainer.getDrivetrain().gLimeLight().getIsTargetFound();

    if(targetFound==true){
      m_moveValue = ty * kpDistance * -1;
      m_rotateValue = tx * kpAim * -1;
    } else if (targetFound==true && tx < min_command) {
      m_moveValue = ty * kpDistance * -1;
      m_rotateValue = 0.0;
    } else if (targetFound==true && ty < min_command) {
      m_moveValue = 0.0;
      m_rotateValue = tx * kpAim * -1;
    } else if (targetFound==true && ty < min_command && tx < min_command) {
      m_moveValue = 0.0;
      m_rotateValue = 0.0;
    } else if(targetFound==false) {
      m_moveValue = 0.0;
      m_rotateValue = .3;
    }


    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(m_moveValue, (RobotContainer.modifyAxis(RobotContainer.rightJoy.getX())), m_rotateValue));
    SmartDashboard.putNumber("X Error", RobotContainer.getDrivetrain().gLimeLight().getdegRotationToTarget());
    SmartDashboard.putNumber("Y Error", RobotContainer.getDrivetrain().gLimeLight().getdegVerticalToTarget());
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
