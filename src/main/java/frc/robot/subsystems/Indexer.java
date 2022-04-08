// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
//Create Index Motors
  public static CANSparkMax RightIndex = new CANSparkMax(Constants.RIGHT_INDEX, MotorType.kBrushless);
  public static CANSparkMax LeftIndex = new CANSparkMax(Constants.LEFT_INDEX, MotorType.kBrushless);
  
//Creates Color Sensor object using the I2C.Port on the RoboRio  
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  
  /** Creates a new Indexer. */
  public Indexer() {}
//Basic set motor function
  public void IndexOn(Double output) {
    RightIndex.set(output * -1);
    LeftIndex.set(output);
  }
//Returns name of Color Sensor so you can use it in other commands and subsystems
public ColorSensorV3 getSensor() {
  return m_colorSensor;
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
