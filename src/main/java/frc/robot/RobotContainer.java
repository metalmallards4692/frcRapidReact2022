package frc.robot;

//import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArmIn;
import frc.robot.commands.ArmOut;
import frc.robot.commands.AutoShoot;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.commands.HoodToggle;
import frc.robot.commands.HookToggle;
import frc.robot.commands.IndexOn;
import frc.robot.commands.IntakeOn;
import frc.robot.commands.IntakeToggle;
import frc.robot.commands.Lob;
import frc.robot.commands.Reverse;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.DrivetrainSubsystem;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();

 //Joystick
 public final Joystick leftJoy = new Joystick(Constants.leftJoystick);
 public final Joystick rightJoy = new Joystick(Constants.rightJoystick);
 //Joystick button
   public JoystickButton rTrigger;
   public JoystickButton lTrigger;
   public JoystickButton lInside;
   public JoystickButton rInside;
   public JoystickButton lOutside;
   public JoystickButton rOutside;
   public JoystickButton rBottom;
   public JoystickButton lBottom;
//GamePad
 public final Joystick gamepad = new Joystick(Constants.gamepad);
 public JoystickButton gamepadX;	
 public JoystickButton gamepadA;
 public JoystickButton gamepadY;
 public JoystickButton gamepadB;
 public JoystickButton gamepadStart;
 public JoystickButton gamepadSelect;
 public JoystickButton gamepadL1;
 public JoystickButton gamepadR1;
 public JoystickButton gamepadR3;
 public JoystickButton gamepadL3;

// Try to find a way to get damp rate on joystick values or motors soit doesnt go from 0 - 100;
  public RobotContainer() {
    m_drivetrainSubsystem.setDefaultCommand(new DefaultDriveCommand(m_drivetrainSubsystem,
        () -> -modifyAxis(rightJoy.getY()) * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND,
        () -> -modifyAxis(rightJoy.getX()) * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND,
        () -> -modifyAxis(rightJoy.getZ()) * DrivetrainSubsystem.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND / 2));

    configureButtonBindings();
  }

  private void configureButtonBindings() {


    rTrigger = new JoystickButton(rightJoy, Constants.JoystickTriggerR);
    lTrigger = new JoystickButton(leftJoy, Constants.JoystickTriggerL);
    rInside = new JoystickButton(rightJoy, Constants.JoystickRightInside);
    lInside = new JoystickButton(leftJoy, Constants.JoystickLeftInside);
    rOutside = new JoystickButton(rightJoy, Constants.JoystickRightOutside);
    lOutside = new JoystickButton(leftJoy, Constants.JoystickLeftOutside);
    rBottom = new JoystickButton(rightJoy, Constants.JoystickRightBottom);
    lBottom = new JoystickButton(leftJoy, Constants.JoystickLeftBottom);

    //Gamepad
    gamepadX = new JoystickButton(gamepad, Constants.GamepadX);
		gamepadA = new JoystickButton(gamepad, Constants.GamepadA);
		gamepadY = new JoystickButton(gamepad, Constants.GamepadY);
		gamepadB = new JoystickButton(gamepad, Constants.GamepadB);
		//gamepadStart = new JoystickButton(gamepad, Constants.GamepadStart);
		//gamepadSelect = new JoystickButton(gamepad, Constants.GamepadSelect);
		gamepadR1 = new JoystickButton(gamepad, Constants.GamepadR1);
    gamepadL1 = new JoystickButton(gamepad, Constants.GamepadL1);
    gamepadR3 = new JoystickButton(gamepad, Constants.GamepadR3);
    gamepadL3 = new JoystickButton(gamepad, Constants.GamepadL3);
   
   
    //Joystick Functions
    rBottom.whenPressed(m_drivetrainSubsystem::zeroGyroscope);
    lInside.whenPressed(new ArmIn());
    rInside.whenPressed(new ArmOut());
    rOutside.whenPressed(new HookToggle());

    

    //Gamepad Functions
    gamepadX.whenPressed(new IntakeToggle());
    gamepadL1.whenPressed(new HoodToggle());
    gamepadA.whenHeld(new IntakeOn());
    gamepadR1.whenHeld(new Shoot());
    gamepadY.whenHeld(new IndexOn());
    gamepadB.whenHeld(new Reverse());
    gamepadR3.whenHeld(new Lob());

    
  }

  public Command getAutonomousCommand() {
    return new AutoShoot();
  }

  private static double deadband(double value, double deadband) {
    if (Math.abs(value) > deadband) {
      if (value > 0.0) {
        return (value - deadband) / (1.0 - deadband);
      } else {
        return (value + deadband) / (1.0 - deadband);
      }
    } else {
      return 0.0;
    }
  }
  private static double modifyAxis(double value) {
    // Deadband
    value = deadband(value, 0.05);

    // Square the axis
    value = Math.copySign(value * value, value);

    return value;
  }
}
