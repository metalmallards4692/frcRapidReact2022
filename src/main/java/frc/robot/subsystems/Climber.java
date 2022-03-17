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
  private DoubleSolenoid HookCylinders;

  public Climber() {
    ClimbCylinders = new DoubleSolenoid(3,PneumaticsModuleType.REVPH, 4, 5);
    ClimbCylinders.set(Value.kForward);
    HookCylinders = new DoubleSolenoid(3,PneumaticsModuleType.REVPH, 6, 7);
    ClimbCylinders.set(Value.kForward);
  }

  public void ArmOut() {
    ClimbCylinders.set(DoubleSolenoid.Value.kForward);
  }
  
  public void ArmIn() {
    ClimbCylinders.set(DoubleSolenoid.Value.kReverse);
  }
/*
  public void HookToggle() {
    if (HookCylinders.get()==Value.kReverse || HookCylinders.get() == Value.kOff) {
      HookCylinders.set(Value.kForward);
    } if (HookCylinders.get()==Value.kForward){
        HookCylinders.set(Value.kReverse);
    }
  }

public void HookOff() {
  HookCylinders.set(Value.kOff);
}
*/
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
  public void initDefaultCommand() {
    ClimbCylinders.set(Value.kOff);
  }
}
