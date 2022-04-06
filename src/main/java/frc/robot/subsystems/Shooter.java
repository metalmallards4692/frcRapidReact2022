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
//This is what is needed to setup a motor so it can be used in a subsystem  
  CANSparkMax ShooterMotor1 = Constants.ShootMotor1;
  CANSparkMax ShooterMotor2 = Constants.ShootMotor2;
//Delares name of a DoubleSolenoid   
  public DoubleSolenoid HoodCylinder;
  
  
  /** Creates a new Shooter. */
  public Shooter() {
//Creates DoubleSolenoid using constructor method. 3 refers to the devices CAN ID. Next is the brand of PneumaticHub, 0 and 1 are the on/off channels on said Hub    
    HoodCylinder = new DoubleSolenoid(3,PneumaticsModuleType.REVPH, 0, 1);
//Sets initial value for Cylinder when it is created. Usually you want this to be kOff, but I needed the hood to stay up so I made it kForward    
    HoodCylinder.set(Value.kForward);
  }
//Basic set Motor output to a number. The * -1 inverts the direction the motor is running.   
  public void ShooterOn(double output) {
    ShooterMotor1.set(output * -1);
    ShooterMotor2.set(output * -1); 
 }

//Basic toggle function to change the value of a cylinder. I copy pasted this function with simple name changes for each of the togglable cylinders.
public void HoodToggle() {
  DoubleSolenoid.Value val = HoodCylinder.get();
  if(val == DoubleSolenoid.Value.kForward) {
    HoodCylinder.set(Value.kReverse);
  }
  else {
    HoodCylinder.set(Value.kForward);
  }
}
//All this does is set the value of the Hood to forward because it broke during comp and I needed a way to make it go back up. 
public void HoodUp() {
  HoodCylinder.set(Value.kForward);
}

 @Override
 public void periodic() {
    // This method will be called once per scheduler run
 }
  
}
