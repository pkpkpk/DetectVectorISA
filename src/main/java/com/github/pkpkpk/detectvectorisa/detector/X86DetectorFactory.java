package com.github.pkpkpk.detectvectorisa.detector;

public class X86DetectorFactory {
    public static X86Detector create() {
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.startsWith("win")) {
            // return new WindowsX86InstructionSetDetector();
            return null;
        } else if (osName.startsWith("mac")) {
            // return new MacOSX86InstructionSetDetector();
            return null;
        } else {
            return new UnixLikeX86Detector();
        }
    }
}
