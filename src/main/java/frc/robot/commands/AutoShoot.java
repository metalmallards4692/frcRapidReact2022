// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoShoot extends CommandBase {
  private Timer ShootTimer = new Timer();
  /** Creates a new AutoShoot. */
  public AutoShoot() {
    addRequirements(Robot.m_shooter);
    addRequirements(Robot.indexer);
    // Use addRequirements() here to declare subsystem dependencies.
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
    Double val = ShootTimer.get();
    if (val < 10) {
      Robot.m_shooter.ShooterOn(0.1);
    } if (val < 100) {
      Robot.m_shooter.ShooterOn(0.1);
      Robot.indexer.TopIndexOn(0.1);
    } if (val < 1000) {
      Robot.m_shooter.ShooterOn(0.1);
      Robot.indexer.TopIndexOn(0.1);
      Robot.indexer.BottomIndexOn(0.1);
    } else {
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
