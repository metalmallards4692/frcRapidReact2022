// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;

public class AutoShoot extends CommandBase {

// This Command is obsolete and has been replaced by the TwoBallAuto, however it is smart to keep it just in case we are put in a situation where the TwoBall is not viable
// Is is also poorly setup but may serve as a decent reference on what not to do.

//Declares varibles, and creates a timer object
  private final DrivetrainSubsystem m_DrivetrainSubsystem;
  private Timer ShootTimer = new Timer();
  private Double Shooter_Power = .48;
  private Double index_Power = .3;
  private Double val;

  /** Creates a new AutoShoot. */
  public AutoShoot(DrivetrainSubsystem m_DrivetrainSubsystem) {
//Requires these subsystems - Also by adding a drivetrain parameter, I can use the static varibles from that subsystem such as MAX_VELOCITY and functions such as zero gyroscope    
    this.m_DrivetrainSubsystem = m_DrivetrainSubsystem;
    addRequirements(Robot.m_shooter);
    addRequirements(Robot.indexer);
    addRequirements(RobotContainer.getDrivetrain());
    // Use addRequirements() here to declare subsystem dependencies.
  }

  //When Command first starts, reset and start timer, then zero gyroscope so that when it drives backwards, it goes backwards in reference to the current postion rather than previous headings
  @Override
  public void initialize() {
    ShootTimer.reset();
    ShootTimer.start();
    m_DrivetrainSubsystem.zeroGyroscope();
    
  }  

 //Each loop, the value of val gets updated with the current time, and depending on the time, it will run certain parts of the IF ELSE statement. 
  @Override
  public void execute() {
    val = ShootTimer.get();
    if (val < 2) {
      Robot.m_shooter.ShooterOn(Shooter_Power);
    } else if (val < 4) {
      Robot.m_shooter.ShooterOn(Shooter_Power);
      Robot.indexer.IndexOn(index_Power);
    } else if (val < 6) {
      Robot.m_shooter.ShooterOn(Shooter_Power);
      Robot.indexer.IndexOn(index_Power);
    } else if (val < 10){
      RobotContainer.getDrivetrain().drive(new ChassisSpeeds(-0.4, 0.0, 0.0));
    } else if (val <=11.5) {
      RobotContainer.getDrivetrain().drive(new ChassisSpeeds(0.0, 0.0, 0.0));
      Robot.m_shooter.ShooterOn(0.0);
      Robot.indexer.IndexOn(0.0);
    }
  }

  //When Command ends, set motors to zero
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
