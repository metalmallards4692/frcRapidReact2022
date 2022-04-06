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
//Defines different things - creates a Network Table object called table that can be accessed and is linked to the limelight table
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");;
  private NetworkTableEntry ledMode = table.getEntry("ledMode");
  private LimeLight _limelight;

  public VisionCamera() {
    /*
     * tx - Horizontal Offset
     * ty - Vertical Offset 
     * ta - Area of target 
     * tv - Target Visible
     */
    _limelight = new LimeLight();
//Sets pipeline and Ledmode. Pipeline is a fancy term that pretty much means presets for the Limelight camera.    
    this.ledMode = table.getEntry("ledMode");
    setPipeline(Constants.TARGET_PIPELINE);
    setLedOn(false);
  }
//Function to return name of limelight so it can be used in other commands and subsystems 
public LimeLight gLimeLight() {
  return _limelight;
}
//Function that allows one to swap to any pipeline on the Limelight
public void setPipeline(int pipeline){
  this.table.getEntry("pipeline").setNumber(pipeline);
}
//Function to turn on LEDs on the Limelight, or turn them off
public void setLedOn(boolean isOn) {
  if (isOn){
    ledMode.setNumber(Constants.LED_ON);
  } else {
    ledMode.setNumber(Constants.LED_OFF);
  }
}
//Swaps between two pipelines based on it the parameter is true or false
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