// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoTimedShoot extends CommandBase {
  /** Creates a new TimedShoot. */
  private Timer ShootTimer = new Timer();
  private Double index_Power = .5;
  private double SHOOT_POWER;
  private double val;

  
  public AutoTimedShoot() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_shooter);
    addRequirements(Robot.indexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ShootTimer.reset();
    ShootTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SHOOT_POWER = Robot.m_shooter.CalculateRPM();
    val = ShootTimer.get();
    if (val < 2) {
      Robot.m_shooter.ShooterOn(SHOOT_POWER);
    } else {
      Robot.m_shooter.ShooterOn(SHOOT_POWER);
      Robot.indexer.IndexOn(index_Power);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_shooter.ShooterOn(0.0);
    Robot.indexer.IndexOn(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (val > 5);
  }
}
