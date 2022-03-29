// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import oi.limelightvision.limelight.frc.LimeLight;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class VisionCamera extends SubsystemBase {
  /** Creates a new ShooterVision. */
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");;
  private NetworkTableEntry ledMode = table.getEntry("ledMode");
  private LimeLight _limelight;

  public VisionCamera() {
    /**
     * tx - Horizontal Offset
     * ty - Vertical Offset 
     * ta - Area of target 
     * tv - Target Visible
     */
    _limelight = new LimeLight();
    
    this.ledMode = table.getEntry("ledMode");
    setPipeline(Constants.TARGET_PIPELINE);
    setLedOn(false);
  }

public LimeLight gLimeLight() {
  return _limelight;
}

public void setPipeline(int pipeline){
  this.table.getEntry("pipeline").setNumber(pipeline);
}

public void setLedOn(boolean isOn) {
  if (isOn){
    ledMode.setNumber(Constants.LED_ON);
  } else {
    ledMode.setNumber(Constants.LED_OFF);
  }
}

public void switchPipeline(boolean targeting){
  if(targeting == true){
    setPipeline(Constants.TARGET_PIPELINE);
  } else {
    setPipeline(Constants.DRIVE_PIPELINE);
  }
}
  @Override
  public void periodic() {}

}