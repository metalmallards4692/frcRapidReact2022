// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
  CANSparkMax RightIndexer = Constants.RightIndex;
  CANSparkMax LeftIndexer = Constants.LeftIndex;
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  
  /** Creates a new Indexer. */
  public Indexer() {}

  public void IndexOn(Double output) {
    RightIndexer.set(output * -1);
    LeftIndexer.set(output);
  }

public ColorSensorV3 getSensor() {
  return m_colorSensor;
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void IndexerOn() {
  }
}
