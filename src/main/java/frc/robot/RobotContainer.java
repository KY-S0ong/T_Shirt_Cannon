// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.GameConstants;
import frc.robot.commands.tankDrive;
import frc.robot.subsystems.KYSTankDrive;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.path.PathPlannerPath;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {

  private final XboxController xc = new XboxController(GameConstants.xc);
  //*____________________Subsystems___________________________________________ 
  //private final KYSDriveTrain driveTrain = new KYSDriveTrain(
            //PathPlannerAuto.getStaringPoseFromAutoFile(GameConstants.SelectedPath));
    
    private final KYSTankDrive drive = new KYSTankDrive();
  //*____________________Commands_____________________________________________
  //private final zeroHeading zeroHeading = new zeroHeading(driveTrain);
  private final tankDrive cmd = new tankDrive(drive, xc);


  public RobotContainer() {
    drive.setDefaultCommand(cmd);
    configureBindings();

  }

  //private void registerCommands(){}
  private void configureBindings() {
 
  }

  public Command getAutonomousCommand() {
    PathPlannerPath path = PathPlannerPath.fromPathFile(GameConstants.SelectedPath);
    return AutoBuilder.followPath(path);
  }
}
