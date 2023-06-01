package com.github.pkpkpk.detectvectorisa;

import com.github.pkpkpk.detectvectorisa.detector.X86DetectorFactory;
import com.github.pkpkpk.detectvectorisa.detector.X86Detector;

import java.util.EnumSet;

import static com.github.pkpkpk.detectvectorisa.InstructionSet.*;

public class VectorISADetector {
    private static final EnumSet<InstructionSet> supportedInstructions;

    static {
        supportedInstructions = EnumSet.of(InstructionSet.DEFAULT);

        String arch = System.getProperty("os.arch").toUpperCase();

        if (arch.startsWith("ARM")) {
            supportedInstructions.add(InstructionSet.NEON);
        } else if (arch.startsWith("PPC")) {
            supportedInstructions.add(InstructionSet.ALTIVEC);
        } else if (arch.equals("AMD64") || arch.equals("X86")) {
            X86Detector detector = X86DetectorFactory.create();
            assert detector != null;
            supportedInstructions.addAll(detector.detectX86Support());
        }
    }

    public static EnumSet<InstructionSet> detectSupportedArchitectures() {
        return EnumSet.copyOf(supportedInstructions);
    }

    public static boolean supportsNEON() {
        return supportedInstructions.contains(NEON);
    }

    public static boolean supportsAVX2() {
        return supportedInstructions.contains(AVX2);
    }

    public static boolean supportsSSE42() {
        return supportedInstructions.contains(SSE42);
    }

    public static boolean supportsPCLMULQDQ() {
        return supportedInstructions.contains(PCLMULQDQ);
    }

    public static boolean supportsBMI1() {
        return supportedInstructions.contains(BMI1);
    }

    public static boolean supportsBMI2() {
        return supportedInstructions.contains(BMI2);
    }

    public static boolean supportsALTIVEC() {
        return supportedInstructions.contains(ALTIVEC);
    }

    public static boolean supportsAVX512F() {
        return supportedInstructions.contains(AVX512F);
    }

    public static boolean supportsAVX512DQ() {
        return supportedInstructions.contains(AVX512DQ);
    }

    public static boolean supportsAVX512IFMA() {
        return supportedInstructions.contains(AVX512IFMA);
    }

    public static boolean supportsAVX512PF() {
        return supportedInstructions.contains(AVX512PF);
    }

    public static boolean supportsAVX512ER() {
        return supportedInstructions.contains(AVX512ER);
    }

    public static boolean supportsAVX512CD() {
        return supportedInstructions.contains(AVX512CD);
    }

    public static boolean supportsAVX512BW() {
        return supportedInstructions.contains(AVX512BW);
    }

    public static boolean supportsAVX512VL() {
        return supportedInstructions.contains(AVX512VL);
    }

    public static boolean supportsAVX512VBMI2() {
        return supportedInstructions.contains(AVX512VBMI2);
    }

    public static String summarizeVectorSupport() {
        if (supportedInstructions.isEmpty()) {
            return "No vector instruction sets supported.";
        }

        StringBuilder summary = new StringBuilder("Supported vector instruction sets: ");
        for (InstructionSet instructionSet : supportedInstructions) {
            summary.append(instructionSet.name()).append(", ");
        }

        // remove last comma and space
        summary.setLength(summary.length() - 2);

        return summary.toString();
    }


}

