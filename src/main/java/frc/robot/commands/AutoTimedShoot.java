// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoTimedShoot extends CommandBase {
//Declares varibles and creates timer object
  private Timer ShootTimer = new Timer();
  private Double index_Power = .5;
  private double SHOOT_POWER = .435;
  private double val;

  
  public AutoTimedShoot() {
//Requires these subsystems
    addRequirements(Robot.m_shooter);
    addRequirements(Robot.indexer);
  }

  //Resets and starts the timer when command is first called
  @Override
  public void initialize() {
    ShootTimer.reset();
    ShootTimer.start();
  }

  //Every loop, varible val gets updated with current time and depending on time, different parts of the IF statements will run
  @Override
  public void execute() {
    val = ShootTimer.get();
    if (val < 2) {
      Robot.m_shooter.ShooterOn(SHOOT_POWER);
    } else {
      Robot.m_shooter.ShooterOn(SHOOT_POWER);
      Robot.indexer.IndexOn(index_Power);
    }
  }

  //Set motor values back to zero when command ends
  @Override
  public void end(boolean interrupted) {
    Robot.m_shooter.ShooterOn(0.0);
    Robot.indexer.IndexOn(0.0);
  }

  //When timer is greater than four, end command
  @Override
  public boolean isFinished() {
    return (val > 4);
  }
}
