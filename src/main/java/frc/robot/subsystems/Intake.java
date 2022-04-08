// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
//Create Intake Motor
  public static CANSparkMax IntakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR, MotorType.kBrushless);
  public static CANSparkMax TransferMotor = new CANSparkMax(Constants.TRANSFER_MOTOR, MotorType.kBrushless);

  private DoubleSolenoid IntakeCylinders;
 
  public Intake() {
//Creates Double Solenoid on the ID 3 Hub and channel 2, 3.     
    IntakeCylinders = new DoubleSolenoid(3,PneumaticsModuleType.REVPH, 2, 3);

// Sets initial value of Cylinder to kOff, AKA no air flowing to Cylinder    
    IntakeCylinders.set(Value.kOff);
  }
//Function to stop the Intake motors from running if the intake is retracted because it could damage stuff. But still alows the transfer motors to run.  
  public void IntakeOnWithStopper(Double output) {
    if (IntakeCylinders.get()==Value.kReverse || IntakeCylinders.get() == Value.kOff) {
      IntakeMotor.set(0.0);
      TransferMotor.set(output * -1 * 0.5);
    } else {
      IntakeMotor.set(output * -1 );
      TransferMotor.set(output * -1);
    }
  }
  
//Basic set motor value function  
  public void IntakeOn(Double output) {
    IntakeMotor.set(output * -1);
    TransferMotor.set(output * -1);
  }
  
//Toggle Cylinder function for intake. Same as HoodToggle because I copy pasted it. 
  public void IntakeToggle() {
    DoubleSolenoid.Value val = IntakeCylinders.get();
    if(val == DoubleSolenoid.Value.kForward) {
      IntakeCylinders.set(Value.kReverse);
    }
    else {
      IntakeCylinders.set(Value.kForward);
    }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
