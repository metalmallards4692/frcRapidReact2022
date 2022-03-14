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
  private DoubleSolenoid IntakeCylinder;
  

  /** Creates a new Intake. */
  public Intake() {
    IntakeCylinder = new DoubleSolenoid(3,PneumaticsModuleType.REVPH, 0, 1);
    IntakeCylinder.set(Value.kOff);
  }
  public void IntakeOn(Double output) {
    if (IntakeCylinder.get()==Value.kReverse || IntakeCylinder.get() == Value.kOff) {
      IntakeMotor.set(0.0);
    } else {
      IntakeMotor.set(output);
    }
  }
  public void IntakeToggle() {
    IntakeCylinder.toggle();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
