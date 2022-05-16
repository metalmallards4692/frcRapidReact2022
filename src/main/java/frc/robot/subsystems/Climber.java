// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
//Declares the names for the double solenoids  
  private DoubleSolenoid ClimbCylinders;
  private DoubleSolenoid HookCylinders;

//Main climber method that will run on robot start
  public Climber() {
  //Creates doublesolenoid object with the channels 6,7 and sets inital value to off  
    ClimbCylinders = new DoubleSolenoid(3,PneumaticsModuleType.REVPH, 6, 7);
    ClimbCylinders.set(Value.kOff);
  //Creates DoubleSolenoid object with the channels 4,5 and sets unital value to forward
    HookCylinders = new DoubleSolenoid(3,PneumaticsModuleType.REVPH, 4, 5);
    HookCylinders.set(Value.kForward);
  }
//Function to set Cylinder value to forward
  public void ArmOut() {
    ClimbCylinders.set(DoubleSolenoid.Value.kForward);
  }
//Function to set Cylinder value to reverse 
  public void ArmIn() {
    ClimbCylinders.set(DoubleSolenoid.Value.kReverse);
  }
//Function to set Cylinder value to off
  public void ArmOff() {
    ClimbCylinders.set(DoubleSolenoid.Value.kOff);
  }

//Togglable cylinder function. 
public void HookToggle() {
  DoubleSolenoid.Value val = HookCylinders.get();
  if(val == DoubleSolenoid.Value.kForward) {
    HookCylinders.set(Value.kReverse);
  }
  else {
    HookCylinders.set(Value.kForward);
  }
}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
