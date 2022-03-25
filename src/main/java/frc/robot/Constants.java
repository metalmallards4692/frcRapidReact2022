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
    public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(91.58203141060403); 

    public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 21; 
    public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 22; 
    public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 13;
    public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(70.75195568749196);  //22.060546

    public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 25; 
    public static final int BACK_LEFT_MODULE_STEER_MOTOR = 29; 
    public static final int BACK_LEFT_MODULE_STEER_ENCODER = 11; 
    public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(136.84570870065687); //77.255860

    public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 23; 
    public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 24; 
    public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 10; 
    public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(6.679688086085636);
    
  //Joystick
    public static final int rightJoystick = 0;
  	public static final int leftJoystick = 1;
   
   //Limelight Constants
    public static final double cameraAngleDegrees = 30 ;
    public static final double goalHeightMeters = 2.6416;
    public static final double cameraHeightMeters = 1.1049;

    //Distance
    public static double distance = 3.0;
    public static double rpm;

    //Auto Junk
    public static double SpeedMax;
   
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
    public static int gamepad = 3;

  //Gamepad Buttons
    public static int GamepadA = 1;
    public static int GamepadB = 2;
    public static int GamepadX = 3;
    public static int GamepadY = 4;
    public static int GamepadL1 = 5;
    public static int GamepadR1 = 6;          
    //public static int GamepadSelect = 0;
    //public static int GamepadStart = 0;
    public static int GamepadR3 = 9;
    public static int GamepadL3 = 10;

  //shooter motor ids
    public static int SHOOTER_MOTOR_1 = 34;
    public static int SHOOTER_MOTOR_2 = 37;
  //Creating Motors
    public static CANSparkMax ShootMotor1 = new CANSparkMax(Constants.SHOOTER_MOTOR_1, MotorType.kBrushless);
    public static CANSparkMax ShootMotor2 = new CANSparkMax(Constants.SHOOTER_MOTOR_2, MotorType.kBrushless);

  //Indexer Motors
    public static int RIGHT_INDEX = 38;
    public static int LEFT_INDEX = 33;
  //Create Index Motors
    public static CANSparkMax RightIndex = new CANSparkMax(Constants.RIGHT_INDEX, MotorType.kBrushless);
    public static CANSparkMax LeftIndex = new CANSparkMax(Constants.LEFT_INDEX, MotorType.kBrushless);
    
  //intake Motor
    public static int INTAKE_MOTOR = 30;
    public static int TRANSFER_MOTOR = 36;
  //Create Intake Motor
    public static CANSparkMax IntakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR, MotorType.kBrushless);
    public static CANSparkMax TransferMotor = new CANSparkMax(Constants.TRANSFER_MOTOR, MotorType.kBrushless);
  //compressor
    public static Compressor cp;
    
}