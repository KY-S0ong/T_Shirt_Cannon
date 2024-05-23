// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.ButtonConstants;
import frc.robot.Constants.GameConstants;
import frc.robot.commands.shoot;
import frc.robot.commands.tankDrive;
import frc.robot.subsystems.Cannon;
import frc.robot.subsystems.KYSTankDrive;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainer {

  private final XboxController xc = new XboxController(GameConstants.xc);
  // *____________________Subsystems___________________________________________
  private final KYSTankDrive drive = new KYSTankDrive();
  private final Cannon cannon = new Cannon();

  // *____________________Commands_____________________________________________
  // private final zeroHeading zeroHeading = new zeroHeading(driveTrain);
  //private final emergancyStop stop = new emergancyStop(drive);

  public RobotContainer() {
    drive.setDefaultCommand(
        new tankDrive(
            drive,
            () -> xc.getLeftY(),
            () -> xc.getRightX(),
            () -> xc.getBButtonPressed()));

    configureBindings();

  }

  // private void registerCommands(){}
  private void configureBindings() {
    new JoystickButton(xc, ButtonConstants.buttonA).whileTrue(new shoot(cannon));
    //new JoystickButton(xc, ButtonConstants.buttonB).onTrue(stop);
  }

  public Command getAutonomousCommand() {
   return null;
  }
}
