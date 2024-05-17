// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;




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

  public final class GameConstants {
    public static final String SelectedPath = "ExamplePath";

    public static final double kDeadband = 0.15;
    public static final int xc = 0;
  }

  public final class ButtonConstants {
    public static final int buttonA = 1;
    public static final int buttonB = 2;
    public static final int buttonX = 3;
    public static final int buttonY = 4;
    public static final int buttonLB = 5;
    public static final int buttonRB = 6;
    public static final int buttonStart = 7;
  }

  public final class LimitConstants {
    public static final double kPhysicalMaxSpeedMetersPerSecond = 10;
    public static final double kTeleDriveMaxSpeedMetersPerSecond = 10;
    public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 5;
    public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 8.5;
  }

  public final class BotConstants {
  }
}
