// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class TimedShoot extends CommandBase {
//Declares variables and creates timer object
  private Timer ShootTimer = new Timer();
  private Double index_Power = .5;
  private double SHOOT_POWER = .6; //.435
  private double val;

  
  public TimedShoot() {
//Requires these subsystems
    addRequirements(Robot.m_shooter);
    addRequirements(Robot.indexer);
  }

//When command is first called, reset and start the timer
  @Override
  public void initialize() {
    ShootTimer.reset();
    ShootTimer.start();
  }

//Each loop will update the val varible with the current timer value and depending on the timer value, will run different parts of the IF statement
  @Override
  public void execute() {
    val = ShootTimer.get();
    if (val < .5) {
      Robot.m_shooter.ShooterOn(SHOOT_POWER);
    } else {
      Robot.m_shooter.ShooterOn(SHOOT_POWER);
      Robot.indexer.IndexOn(index_Power);
    }
  }

// When command ends, set motors to zero
  @Override
  public void end(boolean interrupted) {
    Robot.m_shooter.ShooterOn(0.0);
    Robot.indexer.IndexOn(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
