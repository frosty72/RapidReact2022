// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.climberS1Defualt;
import frc.robot.commands.climberS1EndGame;
import frc.robot.commands.climberS1Extended;
import frc.robot.commands.intakeEat;
import frc.robot.commands.intakeHome;
import frc.robot.commands.popper;
import frc.robot.subsystems.arm;
import frc.robot.subsystems.climberS1;
import frc.robot.subsystems.climberS2;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.pnuematics;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {


  //substystems 
  public final static pnuematics m_pnuematics = new pnuematics();

  public final static driveTrain m_drivetrain = new driveTrain();
  public final static climberS1 m_climbers1 = new climberS1();
  public final static climberS2 m_climbers2 = new climberS2();

  public final static arm m_arm = new arm();


  //commands 
  private final intakeHome m_armintakehome = new intakeHome();
  private final intakeEat m_armintakeat = new intakeEat();

  private final climberS1Defualt m_climbers1defualf = new climberS1Defualt();
  private final climberS1Extended m_climbers1extended = new climberS1Extended();
  private final climberS1EndGame m_climbers1endgame = new climberS1EndGame();
  






 // declaring hids \\
  Joystick driverController = new Joystick(Constants.portDriverController); // sets joystick varibles to joysticks
  XboxController coDriverController = new XboxController(Constants.portCoDriverController);
  
  //gets the joystick axis value where ever you want, 
  //for y use Robot.m_robotContainer.getJoystickRawAxis(Constants.joystickY); 
  //for x use Robot.m_robotContainer.getJoystickRawAxis(Constants.joystickX);
  public double getJoystickRawAxis(int axis){
    return driverController.getRawAxis(axis);
  }
  public double getXboxRawAxis(int axis){
    return coDriverController.getRawAxis(axis);
  }



























  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {


 JoystickButton buttonA = new JoystickButton(coDriverController, Constants.buttonA);
 JoystickButton buttonB = new JoystickButton(coDriverController, Constants.buttonB);
 JoystickButton buttonX = new JoystickButton(coDriverController, Constants.buttonX);
 JoystickButton buttonY = new JoystickButton(coDriverController, Constants.buttonY);
 JoystickButton bumperLeft = new JoystickButton(coDriverController, Constants.bumperLeft);
 JoystickButton bumperRight = new JoystickButton(coDriverController, Constants.bumperRight);

 
 // example for button commands buttonB.whenPressed(new limeLightTargetX());
    //buttonA.whenPressed(new pnuematicsCmd(solenoidIntakeArmForward));


    buttonA.whenPressed(new climberS1Defualt());
    buttonB.whenPressed(new climberS1Extended());
    buttonX.whenPressed(new climberS1EndGame());

    bumperLeft.whenPressed(new intakeEat());
    bumperRight.whenPressed(new intakeHome());

    buttonY.whenPressed(new popper());

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
  }

