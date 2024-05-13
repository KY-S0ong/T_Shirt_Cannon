// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  
  
  public final class GameConstants{
    public static final String SelectedPath = "ExamplePath";
    
    public static final double kDeadband = 0.15;
    public static final int xc = 0;
  }

  public final class LimitConstants {
    public static final double kPhysicalMaxSpeedMetersPerSecond = 12;
    public static final double kTeleDriveMaxSpeedMetersPerSecond = 12;
    public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 5;
    public static double kTeleDriveMaxAngularSpeedRadiansPerSecond = 3;
    public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 8.5;
  }

  public final class BotConstants {
    public static DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(0);
    
    public static double wheelRadius = 0.6;
  }
}
