// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class KYSTankDrive extends SubsystemBase {
  private final Talon fleft = new Talon(0);
  private final Talon bleft = new Talon(1);
  private final Talon fright = new Talon(2);
  private final Talon bright = new Talon(3);

  private final ProfiledPIDController controller = new ProfiledPIDController(
      2, 0, 0,
      new TrapezoidProfile.Constraints(20, 10));



  public KYSTankDrive() {
  }
  

  @Override
  public void periodic() {
  }

  public void tankDrive(double ly, double rx) {
    fleft.set(controller.calculate((ly + (2 * rx)) * Math.PI));
    bleft.set(controller.calculate((ly + (2 * rx)) * Math.PI));
    bleft.set(controller.calculate((ly - (2 + rx)) * Math.PI));
    fleft.set(controller.calculate((ly - (2 + rx)) * Math.PI));
  }


  

  public void stop() {
    fleft.set(0);
    bleft.set(0);
    fright.set(0);
    bright.set(0);
  }
}
