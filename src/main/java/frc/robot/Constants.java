package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Compressor;

public final class Constants {
  //Drive Train Constants
    public static final double DRIVETRAIN_TRACKWIDTH_METERS = Units.inchesToMeters(23.5); 
    public static final double DRIVETRAIN_WHEELBASE_METERS = Units.inchesToMeters(23.5);

    public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 27; 
    public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 28; 
    public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 12;
    public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(91.845704); 

    public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 21; 
    public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 22; 
    public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 13;
    public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(69.433593);  //22.060546

    public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 25; 
    public static final int BACK_LEFT_MODULE_STEER_MOTOR = 29; 
    public static final int BACK_LEFT_MODULE_STEER_ENCODER = 11; 
    public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(135.615236); //(77.255860

    public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 23; 
    public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 24; 
    public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 10; 
    public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(7.734375);
    
  //Joystick
    public static final int rightJoystick = 0;
  	public static final int leftJoystick = 1;
   
  //Joystick Buttons
    public static int JoystickTriggerR = 1;
    public static int JoystickTriggerL = 1;
    public static int JoystickLeftInside = 4;
    public static int JoystickRightInside = 3;
    public static int JoystickRightOutside = 4;
    public static int JoystickLeftOutside = 3;
    public static int JoystickRightBottom = 2;
    public static int JoystickLeftBottom = 2;

  //Gamepad
    public static int gamepad = 2;

  //Gamepad Buttons
    public static int GamepadA = 2;
    public static int GamepadB = 3;
    public static int GamepadX = 1;
    public static int GamepadY = 4;
    public static int GamepadL1 = 5;
    public static int GamepadR1 = 6;           
    public static int GamepadSelect = 9;
    public static int GamepadStart = 10;
    public static int GamepadR3 = 11;
    public static int GamepadL3 = 12;

  //shooter motor ids
    public static int SHOOTER_MOTOR_1 = 34;
    public static int SHOOTER_MOTOR_2 = 37;
  //Creating Motors
    public static CANSparkMax ShootMotor1 = new CANSparkMax(Constants.SHOOTER_MOTOR_1, MotorType.kBrushless);
    public static CANSparkMax ShootMotor2 = new CANSparkMax(Constants.SHOOTER_MOTOR_2, MotorType.kBrushless);

  //Indexer Motors
    public static int BOTTOM_INDEX = 30;
    public static int TOP_INDEX = 31;
  //Create Index Motors
    public static CANSparkMax BottomIndex = new CANSparkMax(Constants.BOTTOM_INDEX, MotorType.kBrushless);
    public static CANSparkMax TopIndex = new CANSparkMax(Constants.TOP_INDEX, MotorType.kBrushless);
  //intake Motor
    public static int INTAKE_MOTOR = 36;
  //Create Intake Motor
    public static CANSparkMax IntakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR, MotorType.kBrushless);

  //compressor
    public static Compressor cp;
    
}