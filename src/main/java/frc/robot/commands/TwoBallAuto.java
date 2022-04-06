// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class TwoBallAuto extends SequentialCommandGroup {
  /** Creates a new TwoBallAuto. */
  public TwoBallAuto() {
/*
This is a SequencialCommandGroup. It will run each of the commands in this list in order. Within this sequcialgroup, I have made a couple parallelcommandGroups that will
run multiple commands at the same time rather in sequence. 

What is important when using sequencial and parallel command groups is that you need the commands to be able to end on their own, epecally if this is for autonomous
Each of these commands either stops using a timer value or a sensor value. 

When one command ends, it moves to the next command in the list. And in the parallel groups, they all start at the time time, however I believe when the final command in the group ends it will 
go onto the next in the list. So lets say in the first group AutoTimedShoot lasts 4 seconds while ShortTimedAutoAim lasts only 3 seconds. They will start at the same time, but it will only leave that
command group and move onto the AutoIntake when AutoTimedShoot ends since it ends last. 
Now that I think about it, IntakeToggle never ends, which means that my TimedDriveBackwards never starts.... Hmm, that may explain some of the weird behavior I was seeing during auto.
*/
    addCommands(new ParallelCommandGroup(new AutoTimedShoot(),
                                         new ShortTimedAutoAim()),
                                         new AutoIntake(),
                new ParallelCommandGroup(new TimedAutoAim(),
                                         new AutoTimedShoot()),
                                         new IntakeToggle(),
                                         new TimedDriveBackwards()
                                      

    );
  }
}
