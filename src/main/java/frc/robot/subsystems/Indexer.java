// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
  CANSparkMax TopIndexer = Constants.TopIndex;
  CANSparkMax BottomIndexer = Constants.BottomIndex;
  
  /** Creates a new Indexer. */
  public Indexer() {}

  public void IndexOn(Double output) {
    TopIndexer.set(output);
    BottomIndexer.set(output);
  }
  public void TopIndexOn(Double output) {
    TopIndexer.set(output);
  }
  public void BottomIndexOn(Double output) {
    BottomIndexer.set(output);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void IndexerOn() {
  }
}
