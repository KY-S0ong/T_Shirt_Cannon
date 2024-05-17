// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Cannon extends SubsystemBase {
  private Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
  private Solenoid solenoid = new Solenoid(1, PneumaticsModuleType.CTREPCM, 1);
  public Cannon() {
    compressor.enableDigital();
  }

  @Override
  public void periodic() {

  }

  public void shoot() {
    solenoid.set(true);;
  }

  public void stop() {
    solenoid.set(false);;
  }
}
