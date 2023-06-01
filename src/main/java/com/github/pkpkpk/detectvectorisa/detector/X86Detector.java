package com.github.pkpkpk.detectvectorisa.detector;

import com.github.pkpkpk.detectvectorisa.InstructionSet;

import java.util.EnumSet;

public interface X86Detector {

    /**
     * Detects the instruction sets supported by the host system.
     *
     * @return An EnumSet containing the supported instruction sets.
     */
    EnumSet<InstructionSet> detectX86Support();
}
