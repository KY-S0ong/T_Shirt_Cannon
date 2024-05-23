// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.GameConstants;
import frc.robot.Constants.LimitConstants;
import frc.robot.subsystems.KYSTankDrive;

public class tankDrive extends Command {
  private KYSTankDrive tank;
  private SlewRateLimiter lYLimiter = new SlewRateLimiter(15);
  private SlewRateLimiter rXLimiter = new SlewRateLimiter(15);
  private Supplier<Double> xSpdFunction;
  private Supplier<Double> ySpdFunction;
  Supplier<Boolean> saftey;

  double ly;
  double rx;
  boolean safe;
  String safeMode;

  public tankDrive(KYSTankDrive tank, Supplier<Double> ySpdFunction, Supplier<Double> xSpdFunction, Supplier<Boolean> saftey) {
    this.tank = tank;

    this.xSpdFunction = ySpdFunction;
    this.ySpdFunction = xSpdFunction;
    this.saftey = saftey;
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
    safe = saftey.get();
    

    ly = (ly > GameConstants.kDeadband) ? ly : 0;
    rx = (rx > GameConstants.kDeadband) ? rx : 0;

    ly = lYLimiter.calculate(ly) * LimitConstants.kTeleDriveMaxSpeedMetersPerSecond;
    rx = rXLimiter.calculate(rx) * LimitConstants.kTeleDriveMaxSpeedMetersPerSecond;


    SmartDashboard.putNumber("xbox ly", ly);
    SmartDashboard.putNumber("xbox rx", rx);
   

    if (safe == false){
    tank.tankDrive(ly, rx);
    tank.setSafteyOff();
    String safeMode = "False";
    SmartDashboard.putString("Robot Stopped", safeMode);
    }
    else {
      tank.stop();
      tank.setSafteyOn();
      String safeMode = "True";
      SmartDashboard.putString("Robot Stopped", safeMode);
    }
    
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
