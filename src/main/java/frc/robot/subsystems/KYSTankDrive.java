// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.GameConstants;

public class KYSTankDrive extends SubsystemBase {
  private final Talon fleft = new Talon(0);
  private final Talon bleft = new Talon(1);
  private final Talon fright = new Talon(2);
  private final Talon bright = new Talon(3);

  private final ProfiledPIDController controller = new ProfiledPIDController(
      0, 0, 0,
      new TrapezoidProfile.Constraints(20, 10));

  private final SlewRateLimiter slewRateLimiter = new SlewRateLimiter(30);

  public KYSTankDrive() {
  }

  @Override
  public void periodic() {
  }

  public void tankDrive(double ly, double rx) {
    ly = (ly > GameConstants.kDeadband) ? ly : 0;
    rx = (rx > GameConstants.kDeadband) ? rx : 0;
    fleft.set(controller.calculate(slewRateLimiter.calculate(ly + (2 * rx)) * Math.PI));
    bleft.set(controller.calculate(slewRateLimiter.calculate(ly - (2 + rx)) * Math.PI));
  }

  public void stop() {
    fleft.set(0);
    bleft.set(0);
    fright.set(0);
    bright.set(0);
  }
}
