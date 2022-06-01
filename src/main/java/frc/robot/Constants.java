package frc.robot;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Compressor;

public final class Constants {
//Constants are numbers that will not change, or if you do change them, it will make it easy to find since everything is here.
  // If you use a number more than once for something, throw it in here to make your life a lot easier.
    //I should have created a shooter motor speed value since I have 4+ commands that use it and changing them all around is tedious and you will forget a few here and there.

  //Drive Train Constants
    public static final double DRIVETRAIN_TRACKWIDTH_METERS = Units.inchesToMeters(23.5); 
    public static final double DRIVETRAIN_WHEELBASE_METERS = Units.inchesToMeters(23.5);

//CAN ID of the SpeedContoller linked to the Motor in question
    public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 27; 
    public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 28; 
    public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 12;
//The offset recorded in shuffleboard when lining up the wheels forward. 
    public static final double FRONT_LEFT_MODULE_STEER_OFFSET = Math.toRadians(271.7578454887965); 
//Same format as above
    public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 21; 
    public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 22; 
    public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 13;
    public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(71.89453705260837);  //22.060546

    public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 25; 
    public static final int BACK_LEFT_MODULE_STEER_MOTOR = 29; 
    public static final int BACK_LEFT_MODULE_STEER_ENCODER = 11; 
    public static final double BACK_LEFT_MODULE_STEER_OFFSET = Math.toRadians(315.8789004325979 - 90); //77.255860

    public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 23; 
    public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 24; 
    public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 10; 
    public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(6.240234995547485);
    
  //Joystick - ID Values - Can be found in DriverStation under the USB tab
    public static final int rightJoystick = 0;
  	public static final int leftJoystick = 1;
   
  //Limelight Constants - These are values to plug into the imported Limelight functions and to find distance. Check the oi.limelight.java file for commands
    public static final int LED_ON = 3;
    public static final int LED_OFF = 1;
    public static final int TARGET_PIPELINE = 0;
    public static final int DEFAULT_PIPELINE = 0;
    public static final int DRIVE_PIPELINE = 2;
//These are the ID values for each button on the joysticks - These can be found in Drivestation on the USB Tab indicated by the green lights that popup when a button is pressed.   
  //Joystick Buttons
    public static int JoystickTriggerR = 1;
    public static int JoystickTriggerL = 1;
    public static int JoystickLeftInside = 4;
    public static int JoystickRightInside = 3;
    public static int JoystickRightOutside = 4;
    public static int JoystickLeftOutside = 3;
    public static int JoystickRightBottom = 2;
    public static int JoystickLeftBottom = 2;
//ID of USB Gamepad - Everything same format as joystick, but for Gamepad
  //Gamepad
    public static int gamepad = 3;

  //Gamepad Buttons
    public static int GamepadA = 1;
    public static int GamepadB = 2;
    public static int GamepadX = 3;
    public static int GamepadY = 4;
    public static int GamepadL1 = 5;
    public static int GamepadR1 = 6;          
    public static int GamepadR3 = 9;
    public static int GamepadL3 = 10;
    public static int GamepadSelect = 8;

//CAN ID of SpeedContrller responsible for each of the motors used
  //Shooter Motor IDs
    public static int SHOOTER_MOTOR_1 = 34;
    public static int SHOOTER_MOTOR_2 = 37;

  //Indexer Motors
    public static int RIGHT_INDEX = 38;
    public static int LEFT_INDEX = 33;
  
  //intake Motor
    public static int INTAKE_MOTOR = 30;
    public static int TRANSFER_MOTOR = 36;

//Creates compressor object so it runs when robot is enabled. One line and forget about it     
  //compressor
    public static Compressor cp;
    
  // Value of motor divided by speed.
  // Eg.  / 2
  public static int METERS_PER_SECOND_DIVIDED = 1;
}