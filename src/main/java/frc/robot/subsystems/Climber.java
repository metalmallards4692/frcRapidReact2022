// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
  private DoubleSolenoid ClimbCylinders;

  public Climber() {
    ClimbCylinders = new DoubleSolenoid(2,PneumaticsModuleType.REVPH, 4, 5);
    ClimbCylinders.set(Value.kOff);
  }

  public void ArmOut() {
    ClimbCylinders.set(DoubleSolenoid.Value.kForward);
  }
  
  public void ArmIn() {
    ClimbCylinders.set(DoubleSolenoid.Value.kReverse);
  }





  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void initDefaultCommand() {
    ClimbCylinders.set(Value.kOff);
  }
}
