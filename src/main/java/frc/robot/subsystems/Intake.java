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

public class Intake extends SubsystemBase {
  CANSparkMax IntakeMotor = Constants.IntakeMotor;
  private DoubleSolenoid IntakeCylinders;
  CANSparkMax TransferMotor = Constants.TransferMotor;
  

  /** Creates a new Intake. */
 
  public Intake() {
    IntakeCylinders = new DoubleSolenoid(3,PneumaticsModuleType.REVPH, 2, 3);
    IntakeCylinders.set(Value.kOff);
  }
  /*
  public void IntakeOn(Double output) {
    if (IntakeCylinders.get()==Value.kReverse || IntakeCylinders.get() == Value.kOff) {
      IntakeMotor.set(0.0);
      TransferMotor.set(output * -1);
    } else {
      IntakeMotor.set(output * -1);
      TransferMotor.set(output * -1);
    }
  }
  */
  public void IntakeOn(Double output) {
    IntakeMotor.set(output * -1);
    TransferMotor.set(output * -1);
  }
  

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
