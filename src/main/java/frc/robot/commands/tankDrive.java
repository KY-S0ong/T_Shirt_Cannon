// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import java.util.function.Supplier;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.GameConstants;
import frc.robot.Constants.LimitConstants;
import frc.robot.subsystems.KYSTankDrive;

public class tankDrive extends Command {
  private KYSTankDrive tank;
  private XboxController xc;
  private SlewRateLimiter lYLimiter = new SlewRateLimiter(15);
  private SlewRateLimiter rXLimiter = new SlewRateLimiter(15);
  private Supplier<Double> xSpdFunction;
  private Supplier<Double> ySpdFunction;

  double ly;
  double rx;

  boolean driveModeInt;

  public tankDrive(KYSTankDrive tank, Supplier<Double> ySpdFunction, Supplier<Double> xSpdFunction) {
    this.tank = tank;

    this.xSpdFunction = ySpdFunction;
    this.ySpdFunction = xSpdFunction;


    addRequirements(tank);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ly = ySpdFunction.get();
    rx = xSpdFunction.get();

    ly = lYLimiter.calculate(ly) * LimitConstants.kTeleDriveMaxSpeedMetersPerSecond;
    rx = rXLimiter.calculate(rx) * LimitConstants.kTeleDriveMaxSpeedMetersPerSecond;
    

    ly = (ly > GameConstants.kDeadband) ? ly : 0;
    rx = (rx > GameConstants.kDeadband) ? rx : 0;


    SmartDashboard.putNumber("xbox ly", ly);
    SmartDashboard.putNumber("xbox rx", rx);


    tank.tankDrive(ly, rx);


    SmartDashboard.getNumber("Throttle", ly);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    tank.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
