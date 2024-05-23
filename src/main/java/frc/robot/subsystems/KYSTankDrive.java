// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class KYSTankDrive extends SubsystemBase {
  private final Spark fleft = new Spark(0); // Motor Contollers
  private final Spark bleft = new Spark(1);
  private final Spark fright = new Spark(2);
  private final Spark bright = new Spark(3);

  private final ProfiledPIDController controller = new ProfiledPIDController(
      2, 0, 0,
      new TrapezoidProfile.Constraints(10, 5));

  

  public KYSTankDrive() {
    fleft.setInverted(false);
    fright.setInverted(false);
    bleft.setInverted(false);
    bright.setInverted(false);
  }

  @Override
  public void periodic() {

    Boolean[] getSaftey = new Boolean[] {
      fleft.isSafetyEnabled(), fright.isSafetyEnabled(), 
      bleft.isSafetyEnabled(), bright.isSafetyEnabled()};
      
    SmartDashboard.getBooleanArray("Saftey Enabled: ", getSaftey);
    

  }

  public void tankDrive(double ly, double rx) {
    fleft.set(controller.calculate((ly + rx)) * Math.PI);
    bleft.set(controller.calculate((ly + rx)) * Math.PI);
    fright.set(controller.calculate((ly - rx)) * Math.PI);
    bright.set(controller.calculate((ly - rx)) * Math.PI);
  }

  public void stop() {
    fleft.set(0);
    bleft.set(0);
    fright.set(0);
    bright.set(0);
  }

  public void setSafteyOn() {
    fleft.setSafetyEnabled(true);
    fright.setSafetyEnabled(true);
    bleft.setSafetyEnabled(true);
    bright.setSafetyEnabled(true);
  }
  public void setSafteyOff() {
    fleft.setSafetyEnabled(false);
    fright.setSafetyEnabled(false);
    bleft.setSafetyEnabled(false);
    bright.setSafetyEnabled(false);
  }

}
