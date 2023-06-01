package com.github.pkpkpk.detectvectorisa.detector;

import com.github.pkpkpk.detectvectorisa.InstructionSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumSet;

public class UnixLikeX86Detector implements X86Detector {

    private static final String CPU_FLAGS_PATH = "/proc/cpuinfo";

    public EnumSet<InstructionSet> detectX86Support() {
        EnumSet<InstructionSet> supportedInstructions = EnumSet.noneOf(InstructionSet.class);

        try (BufferedReader reader = new BufferedReader(new FileReader(CPU_FLAGS_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("flags")) {

                    String flags = line.substring(line.indexOf(':') + 1).trim();

                    if (flags.contains("avx2")) {
                        supportedInstructions.add(InstructionSet.AVX2);
                    }
                    if (flags.contains("sse4_2")) {
                        supportedInstructions.add(InstructionSet.SSE42);
                    }
                    if (flags.contains("pclmulqdq")) {
                        supportedInstructions.add(InstructionSet.PCLMULQDQ);
                    }
                    if (flags.contains("bmi1")) {
                        supportedInstructions.add(InstructionSet.BMI1);
                    }
                    if (flags.contains("bmi2")) {
                        supportedInstructions.add(InstructionSet.BMI2);
                    }
                    if (flags.contains("avx512f")) {
                        supportedInstructions.add(InstructionSet.AVX512F);
                    }
                    if (flags.contains("avx512dq")) {
                        supportedInstructions.add(InstructionSet.AVX512DQ);
                    }
                    if (flags.contains("avx512ifma")) {
                        supportedInstructions.add(InstructionSet.AVX512IFMA);
                    }
                    if (flags.contains("avx512pf")) {
                        supportedInstructions.add(InstructionSet.AVX512PF);
                    }
                    if (flags.contains("avx512er")) {
                        supportedInstructions.add(InstructionSet.AVX512ER);
                    }
                    if (flags.contains("avx512cd")) {
                        supportedInstructions.add(InstructionSet.AVX512CD);
                    }
                    if (flags.contains("avx512bw")) {
                        supportedInstructions.add(InstructionSet.AVX512BW);
                    }
                    if (flags.contains("avx512vl")) {
                        supportedInstructions.add(InstructionSet.AVX512VL);
                    }
                    if (flags.contains("avx512vbmi2")) {
                        supportedInstructions.add(InstructionSet.AVX512VBMI2);
                    }
                }
            }
        } catch (IOException e) {
            // TODO throw this in unified way with other detectors
            e.printStackTrace();
        }

        return supportedInstructions;
    }
}
