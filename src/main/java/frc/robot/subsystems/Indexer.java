// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
  CANSparkMax RightTopIndexer = Constants.RightTopIndex;
  CANSparkMax RightBottomIndexer = Constants.RightBottomIndex;
  CANSparkMax LeftTopIndexer = Constants.LeftTopIndex;
  CANSparkMax LeftBottomIndexer = Constants.LeftBottomIndex;
  
  /** Creates a new Indexer. */
  public Indexer() {}

  public void IndexOn(Double output) {
    RightTopIndexer.set(output * -1);
    RightBottomIndexer.set(output * -1);
    LeftTopIndexer.set(output);
    LeftBottomIndexer.set(output);
  }
  public void TopIndexOn(Double output) {
    RightTopIndexer.set(output * -1);
    LeftTopIndexer.set(output);
  }
  public void BottomIndexOn(Double output) {
    RightBottomIndexer.set(output * -1);
    LeftBottomIndexer.set(output);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void IndexerOn() {
  }
}
