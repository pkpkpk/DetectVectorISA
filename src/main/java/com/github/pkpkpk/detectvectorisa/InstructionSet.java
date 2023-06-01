package com.github.pkpkpk.detectvectorisa;

public enum InstructionSet {
    DEFAULT(0x0),
    NEON(0x1),
    AVX2(0x4),
    SSE42(0x8),
    PCLMULQDQ(0x10),
    BMI1(0x20),
    BMI2(0x40),
    ALTIVEC(0x80),
    AVX512F(0x100),
    AVX512DQ(0x200),
    AVX512IFMA(0x400),
    AVX512PF(0x800),
    AVX512ER(0x1000),
    AVX512CD(0x2000),
    AVX512BW(0x4000),
    AVX512VL(0x8000),
    AVX512VBMI2(0x10000);

    InstructionSet(int value) { }
}
