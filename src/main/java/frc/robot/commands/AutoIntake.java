// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class AutoIntake extends CommandBase {
//Create Timer object and declares a couple varibles
  private Timer ShootTimer = new Timer();
  private double val;
  double IR;

  public AutoIntake() {
//Requires these subsystems
    addRequirements(Robot.intake);
    addRequirements(Robot.indexer);
    addRequirements(RobotContainer.getDrivetrain());
  }

//Sets Gyroscope to zero so when it drives, it acutally goes backwards. It then deploys the intake and starts the timer. 
  @Override
  public void initialize() {
   RobotContainer.getDrivetrain().zeroGyroscope();
   Robot.intake.IntakeToggle();
   ShootTimer.reset();
   ShootTimer.start();
  }

//Each time this loops, it saves the current timer value and the value from the IR sensor. It also sets the motor speeds of the intake, index, and the robot itself
  @Override
  public void execute() {
    val = ShootTimer.get();
    IR = Robot.indexer.getSensor().getProximity();
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(-.5, 0.0, 0.0));
    Robot.intake.IntakeOn(1.0);
    Robot.indexer.IndexOn(.3);
  }

//When command ends, set all motors back to zero so it doesn't continue driving infinitly
  @Override
  public void end(boolean interrupted) {
    RobotContainer.getDrivetrain().drive(new ChassisSpeeds(0.0, 0.0, 0.0));
    Robot.intake.IntakeOn(0.0);
    Robot.indexer.IndexOn(0.0);
  }

//Ends command when the IR sensor gets tripped or the timer reaches 5 seconds
  @Override
  public boolean isFinished() {
    return (IR >= 250 || val > 5);
  }
}
