// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  //CANSparkMax ShooterMotor1 = Constants.ShootMotor1;
  //CANSparkMax ShooterMotor2 = Constants.ShootMotor2;
  
  
  /** Creates a new Shooter. */
  public Shooter() {
    
  }
  //public void ShooterOn(double output) {
    //ShooterMotor1.set(output);
   // ShooterMotor2.set(output * -1); 
 // }
 @Override
 public void periodic() {
    // This method will be called once per scheduler run
 }
  
}
