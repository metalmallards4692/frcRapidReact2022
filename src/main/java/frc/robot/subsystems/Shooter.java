// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  CANSparkMax ShooterMotor1 = Constants.ShootMotor1;
  CANSparkMax ShooterMotor2 = Constants.ShootMotor2;
  public DoubleSolenoid HoodCylinder;
  
  
  /** Creates a new Shooter. */
  public Shooter() {
    HoodCylinder = new DoubleSolenoid(3,PneumaticsModuleType.REVPH, 0, 1);
    HoodCylinder.set(Value.kForward);
  }
  public void ShooterOn(double output) {
    ShooterMotor1.set(output * -1);
    ShooterMotor2.set(output * -1); 
 }
 /*public void HoodToggle() {
  if (HoodCylinder.get()==Value.kReverse || HoodCylinder.get() == Value.kOff) {
    HoodCylinder.set(Value.kForward);
  } if (HoodCylinder.get()==Value.kForward){
      HoodCylinder.set(Value.kReverse);
  }
}
public void HoodOff() {
  HoodCylinder.set(Value.kOff);
}
*/
public void HoodToggle() {
  DoubleSolenoid.Value val = HoodCylinder.get();
  if(val == DoubleSolenoid.Value.kForward) {
    HoodCylinder.set(Value.kReverse);
  }
  else {
    HoodCylinder.set(Value.kForward);
  }
}

public void AutoShoot(Double output) {
  ShooterMotor1.set(output * -1 / 2);
  ShooterMotor2.set(output * -1);
}
 @Override
 public void periodic() {
    // This method will be called once per scheduler run
 }
  
}
