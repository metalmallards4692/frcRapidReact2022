// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.SPI;

public class AutoShoot extends CommandBase {
  private final DrivetrainSubsystem m_DrivetrainSubsystem;
  private Timer ShootTimer = new Timer();
  private Double Shooter_Power = .42;
  private Double index_Power = .3;
  /** Creates a new AutoShoot. */
  public AutoShoot(DrivetrainSubsystem m_DrivetrainSubsystem) {
    this.m_DrivetrainSubsystem = m_DrivetrainSubsystem;
    addRequirements(Robot.m_shooter);
    addRequirements(Robot.indexer);
    addRequirements(RobotContainer.getDrivetrain());
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ShootTimer.reset();
    ShootTimer.start();
    m_DrivetrainSubsystem.zeroGyroscope();
    
  }  

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Double val = ShootTimer.get();
    if (val < 2) {
      Robot.m_shooter.ShooterOn(Shooter_Power);
    } else if (val < 4) {
      Robot.m_shooter.ShooterOn(Shooter_Power);
      Robot.indexer.TopIndexOn(index_Power);
    } else if (val < 6) {
      Robot.m_shooter.ShooterOn(Shooter_Power);
      Robot.indexer.TopIndexOn(index_Power);
      Robot.indexer.BottomIndexOn(index_Power);
    } else if (val < 10){
      RobotContainer.getDrivetrain().drive(new ChassisSpeeds(-0.4, 0.0, 0.0));
    } else if (val <=11.5) {
      RobotContainer.getDrivetrain().drive(new ChassisSpeeds(0.0, 0.0, 0.0));
      Robot.m_shooter.ShooterOn(0.0);
      Robot.indexer.TopIndexOn(0.0);
      Robot.indexer.BottomIndexOn(0.0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_shooter.ShooterOn(0.0);
    Robot.indexer.TopIndexOn(0.0);
    Robot.indexer.BottomIndexOn(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
