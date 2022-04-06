// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class Shoot extends CommandBase {
  /** Creates a new Shoot. */
  public Shoot() {
//Requires these subsystems
      addRequirements(Robot.m_shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

//Gets the value of the HoodCylinders, and depending on the value, run the shooteron command with different values. Sadly this command was never really used outside of testing..
//So the values are currently the same regardless of Cylinder position.
  @Override
  public void execute() {
    DoubleSolenoid.Value val = Robot.m_shooter.HoodCylinder.get();
    if(val == Value.kForward) {
      Robot.m_shooter.ShooterOn(.50);
    } else {
      Robot.m_shooter.ShooterOn(.50);
    }    
  }

//Sets motor values to zero
  @Override
  public void end(boolean interrupted) {
    //shooter goes off
   Robot.m_shooter.ShooterOn(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
